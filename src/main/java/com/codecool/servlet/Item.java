package com.codecool.servlet;

public class Item {
    private int id=0;
    private String name;
    private float price;


    public String nameToString() {
        return this.name;
    }

    public String priceToString() {
        return Float.toString(this.price);
    }

    public Item(String name, float price) {
        this.id++;
        this.name = name;
        this.price = price;
        //ItemStore.addToItemList(this);
    }


}
