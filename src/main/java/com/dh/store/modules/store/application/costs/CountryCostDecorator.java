package com.dh.store.modules.store.application.costs;

import com.dh.store.modules.store.domain.Detail;
import com.dh.store.modules.store.domain.Order;

public class CountryCostDecorator extends OrderCostDecorator {
    public CountryCostDecorator(OrderCost orderCost) {
        super(orderCost);
    }

    @Override
    public void applyCost(Order order) {
        Detail detail;
        if (order.getCountry() == Order.Country.USA) {
            detail = new Detail(18, Detail.DetailType.Increment, Detail.AmountType.Percentage);
        } else if (order.getCountry() == Order.Country.Bolivia) {
            detail = new Detail(13, Detail.DetailType.Increment, Detail.AmountType.Percentage);
        } else if (order.getCountry() == Order.Country.India) {
            detail = new Detail(19, Detail.DetailType.Increment, Detail.AmountType.Percentage);
        } else {
            detail = new Detail(15, Detail.DetailType.Increment, Detail.AmountType.Percentage);
        }
        order.addDetail(detail);
        super.applyCost(order);
    }
}
