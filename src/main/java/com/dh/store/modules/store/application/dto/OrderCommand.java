package com.dh.store.modules.store.application.dto;

import com.dh.store.modules.store.domain.Order;
import com.dh.store.modules.warehouses.domain.Duckling;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record OrderCommand(
        @NotNull(message = "The color value is required") Duckling.Color color,
        @NotNull(message = "The size value is required") Duckling.Size size,
        @Min(value = 1, message = "The min value is 1") int quantity,
        @NotNull(message = "The country value is required") Order.Country country,
        @NotNull(message = "The shipping value is required") Order.Shipping shipping) {
}
