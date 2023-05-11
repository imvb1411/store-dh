package com.dh.store.modules.store.application.costs;

import com.dh.store.modules.store.domain.Detail;
import com.dh.store.modules.store.domain.Order;

public class QuantityCostDecorator extends OrderCostDecorator {
    public QuantityCostDecorator(OrderCost orderCost) {
        super(orderCost);
    }

    @Override
    public void applyCost(Order order) {
        if (order.getQuantity() > 100) {
            order.addDetail(new Detail(20, Detail.DetailType.Discount, Detail.AmountType.Percentage));
        }
        super.applyCost(order);
    }
}
