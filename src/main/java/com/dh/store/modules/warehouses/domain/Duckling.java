package com.dh.store.modules.warehouses.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Duckling {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Color color;
    private Size size;
    private double price;
    private int quantity;
    private boolean deleted;

    public int getId() {
        return id;
    }

    public Duckling() {
    }

    public Duckling(Color color, Size size, double price, int quantity) {
        this.color = color;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
    }

    public Duckling.Color getColor() {
        return color;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void AddQuantity(int toAdd) {
        this.quantity += toAdd;
    }

    public enum Size {
        XSmall,
        Small,
        Medium,
        Large,
        XLarge
    }

    public enum Color {
        Red,
        Green,
        Yellow,
        Black;

        @Override
        public String toString() {
            switch (this){
                case Red:
                    return "Rojo";
                case Black:
                    return "Negro";
                case Green:
                    return "Verde";
                case Yellow:
                    return "Amarillo";
                default:
                    return "undefined";
            }
        }
    }
}
