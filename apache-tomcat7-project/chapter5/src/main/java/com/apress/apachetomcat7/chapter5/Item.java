package com.apress.apachetomcat7.chapter5;

import java.io.Serializable;

/**
 * @author aleksav
 */
public class Item implements Serializable{
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
