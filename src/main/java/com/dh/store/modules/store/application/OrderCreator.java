package com.dh.store.modules.store.application;

import com.dh.store.modules.store.application.costs.*;
import com.dh.store.modules.store.application.dto.OrderCommand;
import com.dh.store.modules.store.application.dto.OrderResponse;
import com.dh.store.modules.store.application.packages.PackageType;
import com.dh.store.modules.store.application.packages.PackageTypeFactory;
import com.dh.store.modules.store.domain.Order;
import org.springframework.stereotype.Component;

@Component("orderCreator")
public class OrderCreator {
    public OrderResponse create(OrderCommand orderCommand, double ducklingPrice) {
        Order order = new Order(
                orderCommand.color(),
                orderCommand.size(),
                orderCommand.quantity(),
                orderCommand.country(),
                orderCommand.shipping());

        PackageType packageType = PackageTypeFactory.getInstance(order.getSize());

        OrderCostDecorator orderCostDecorator =
                new QuantityCostDecorator(
                        new PackageTypeCostDecorator(packageType.getPackaging(),
                                new CountryCostDecorator(
                                        new ShippingCostDecorator(
                                                new CostCalculator(ducklingPrice)))
                        )
                );

        orderCostDecorator.applyCost(order);

        return new OrderResponse(
                packageType.getPackaging(),
                packageType.getProtection(order.getShipping()),
                order.getTotalAmount(),
                order.getDetailList());
    }
}
