package com.dh.store.modules.store.application.costs;

import com.dh.store.modules.store.domain.Order;

public interface OrderCost {
    public void applyCost(Order order);
}
