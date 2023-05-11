package com.dh.store.modules.store.application.costs;

import com.dh.store.modules.store.domain.Detail;
import com.dh.store.modules.store.domain.Order;

public class CostCalculator implements OrderCost {
    private final double price;

    public CostCalculator(double price) {
        this.price = price;
    }

    @Override
    public void applyCost(Order order) {
        order.setTotalAmount(order.getQuantity() * price);
        double total = order.getTotalAmount();
        for (Detail detail : order.getDetailList()) {
            if (detail.amountType() == Detail.AmountType.Percentage) {
                total += getPercentageCost(detail, order.getTotalAmount());
            } else {
                total += getFixedCost(detail);
            }
        }
        order.setTotalAmount(total);
    }

    private double getPercentageCost(Detail detail, double totalAmount) {
        double percentage = detail.amount() / 100.0;
        if (detail.detailType() == Detail.DetailType.Increment) {
            return totalAmount * percentage;
        } else {
            return -(totalAmount * percentage);
        }
    }

    private double getFixedCost(Detail detail) {
        if (detail.detailType() == Detail.DetailType.Increment) {
            return detail.amount();
        } else {
            return -detail.amount();
        }
    }
}
