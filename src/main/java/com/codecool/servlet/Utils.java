package com.codecool.servlet;

import java.util.ArrayList;

public class Utils {

    public static Item returnItem(String elName, ArrayList<Item> list) {
        Item it = null;
        for (Item item : list) {
            if (item.nameToString().equals(elName)) {
                it= item;
                System.out.println(it.nameToString());
            }
        }
        return it;
    }
}
