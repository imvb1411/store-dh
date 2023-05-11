package com.dh.store.modules.store.application.packages;

import com.dh.store.modules.store.domain.Order;

public class WoodPackage implements PackageType {
    @Override
    public Packaging getPackaging() {
        return Packaging.Wood;
    }

    @Override
    public Order.Protection getProtection(Order.Shipping shipping) {
        if (shipping == Order.Shipping.Air || shipping == Order.Shipping.Ground)
            return Order.Protection.PlasticformBalls;
        if (shipping == Order.Shipping.Ocean)
            return Order.Protection.AbsorbentBalls;

        return Order.Protection.Bubbles;
    }
}
