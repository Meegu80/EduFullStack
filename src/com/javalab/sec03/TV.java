package com.javalab.sec03;

public class TV {
    private String model;
    private int price;

    public TV() {
    }

    public TV(String model, int price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TV{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
