package com.dh.store.modules.store.application.dto;

import com.dh.store.modules.store.application.packages.PackageType;
import com.dh.store.modules.store.domain.Detail;
import com.dh.store.modules.store.domain.Order;
import java.util.List;

public record OrderResponse(
        PackageType.Packaging packaging,
        Order.Protection protection,
        double totalAmount,
        List<Detail> details) {
}
