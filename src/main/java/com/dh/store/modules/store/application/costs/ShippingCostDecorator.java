package com.dh.store.modules.store.application.costs;

import com.dh.store.modules.store.domain.Detail;
import com.dh.store.modules.store.domain.Order;

public class ShippingCostDecorator extends OrderCostDecorator {
    public ShippingCostDecorator(OrderCost orderCost) {
        super(orderCost);
    }

    @Override
    public void applyCost(Order order) {
        if (order.getShipping() == Order.Shipping.Ocean) {
            order.addDetail(new Detail(400, Detail.DetailType.Increment, Detail.AmountType.Fixed));
        } else if (order.getShipping() == Order.Shipping.Ground) {
            order.addDetail(new Detail(10, Detail.DetailType.Increment, Detail.AmountType.Fixed));
        } else if (order.getShipping() == Order.Shipping.Air) {
            order.addDetail(new Detail(30, Detail.DetailType.Increment, Detail.AmountType.Fixed));
            if (order.getQuantity() > 1000) {
                order.addDetail(new Detail(15, Detail.DetailType.Discount, Detail.AmountType.Percentage));
            }
        }
        super.applyCost(order);
    }
}
