package com.dh.store.modules.store.application.costs;

import com.dh.store.modules.store.application.packages.PackageType;
import com.dh.store.modules.store.domain.Detail;
import com.dh.store.modules.store.domain.Order;

public class PackageTypeCostDecorator extends OrderCostDecorator {
    private final PackageType.Packaging packaging;

    public PackageTypeCostDecorator(PackageType.Packaging packaging, OrderCost orderCost) {
        super(orderCost);
        this.packaging = packaging;
    }

    @Override
    public void applyCost(Order order) {
        if (this.packaging == PackageType.Packaging.Cardboard) {
            order.addDetail(new Detail(1, Detail.DetailType.Discount, Detail.AmountType.Percentage));
        } else if (this.packaging == PackageType.Packaging.Plastic) {
            order.addDetail(new Detail(10, Detail.DetailType.Increment, Detail.AmountType.Percentage));
        } else {
            order.addDetail(new Detail(5, Detail.DetailType.Increment, Detail.AmountType.Percentage));
        }
        super.applyCost(order);
    }
}
