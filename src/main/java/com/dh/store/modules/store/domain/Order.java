package com.dh.store.modules.store.domain;

import com.dh.store.modules.warehouses.domain.Duckling;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private final Duckling.Color color;
    private final Duckling.Size size;
    private final int quantity;
    private final Country country;
    private final Shipping shipping;
    private final List<Detail> detailList;
    private double totalAmount;

    public Order(Duckling.Color color, Duckling.Size size, int quantity, Country country, Shipping shipping) {
        this.color = color;
        this.size = size;
        this.quantity = quantity;
        this.country = country;
        this.shipping = shipping;
        detailList = new ArrayList<>();
    }

    public enum Country {
        USA,
        Bolivia,
        India,
        Other
    }

    public enum Shipping {
        Air,
        Ground,
        Ocean
    }

    public enum Protection {
        PlasticformBalls,
        Bubbles,
        AbsorbentBalls

    }

    public List<Detail> getDetailList() {
        return detailList;
    }

    public Duckling.Size getSize() {
        return size;
    }

    public int getQuantity() {
        return quantity;
    }

    public Country getCountry() {
        return country;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void addDetail(Detail detail) {
        this.detailList.add(detail);
    }
}
