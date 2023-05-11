package com.dh.store.modules.store.application.packages;

import com.dh.store.modules.store.domain.Order;

public class PlasticPackage implements PackageType {
    @Override
    public Packaging getPackaging() {
        return Packaging.Plastic;
    }

    @Override
    public Order.Protection getProtection(Order.Shipping shipping) {
        if (shipping == Order.Shipping.Ground)
            return Order.Protection.PlasticformBalls;
        if (shipping == Order.Shipping.Ocean)
            return Order.Protection.AbsorbentBalls;

        return Order.Protection.Bubbles;
    }
}
