package com.apress.apachetomcat7.chapter5;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 * @author aleksav
 */
public class HttpShoppingBasket implements Serializable{

    private List<Item> items = new ArrayList<Item>();
    private double totalValue = 0;

    public void addToBasket(Item item){
        this.items.add(item);
        this.totalValue+=item.getPrice();
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalValue() {
        return totalValue;
    }
}
