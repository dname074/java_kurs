package org.task2;

public class Product {
    private String name;
    private double price; // cena w PLN

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
