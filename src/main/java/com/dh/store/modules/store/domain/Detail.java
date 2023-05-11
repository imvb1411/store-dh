package com.dh.store.modules.store.domain;

public record Detail(int amount, DetailType detailType, AmountType amountType) {
    public enum DetailType {
        Discount,
        Increment
    }

    public enum AmountType {
        Percentage,
        Fixed
    }

}
