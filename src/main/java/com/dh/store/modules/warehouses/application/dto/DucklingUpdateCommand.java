package com.dh.store.modules.warehouses.application.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;

public record DucklingUpdateCommand(
        @Min(value = 1, message = "The quantity should be greater than 0") int quantity,
        @DecimalMin(value = "0.01", message = "The price should be greater than 0") double price) {

}
