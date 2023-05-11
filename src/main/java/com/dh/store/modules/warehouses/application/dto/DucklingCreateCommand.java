package com.dh.store.modules.warehouses.application.dto;

import com.dh.store.modules.warehouses.domain.Duckling;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record DucklingCreateCommand(
        @NotNull(message = "The color value is required") Duckling.Color color,
        @NotNull(message = "The size value is required") Duckling.Size size,
        @DecimalMin(value = "0.01", message = "The price should be greater than 0") double price,
        @Min(value = 1, message = "The quantity should be greater than 0") int quantity) {

}
