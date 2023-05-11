package com.dh.store.modules.store.application.packages;

import com.dh.store.modules.store.domain.Order;

public interface PackageType {
    Packaging getPackaging();

    Order.Protection getProtection(Order.Shipping shipping);

    enum Packaging {
        Wood,
        Plastic,
        Cardboard
    }
}
