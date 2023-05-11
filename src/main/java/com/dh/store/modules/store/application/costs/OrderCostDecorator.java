package com.dh.store.modules.store.application.costs;

import com.dh.store.modules.store.domain.Order;

public class OrderCostDecorator implements OrderCost {
    private OrderCost orderCost;

    public OrderCostDecorator(OrderCost orderCost) {
        this.orderCost = orderCost;
    }

    @Override
    public void applyCost(Order order) {
        orderCost.applyCost(order);
    }
}
