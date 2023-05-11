package com.dh.store.modules.store.application.packages;

import com.dh.store.modules.warehouses.domain.Duckling;

public class PackageTypeFactory {
    public static PackageType getInstance(Duckling.Size size) {
        if (size == Duckling.Size.XLarge || size == Duckling.Size.Large) {
            return new WoodPackage();
        } else if (size == Duckling.Size.Medium) {
            return new CardboardPackage();
        } else {
            return new PlasticPackage();
        }
    }
}
