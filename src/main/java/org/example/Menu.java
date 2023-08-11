package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuItem> menu;

    public Menu(){
        menu = new ArrayList<>();
        menu.add(new MenuItem("latte", 200, 150, 24, 2.5));
        menu.add(new MenuItem("espresso", 50, 0, 18, 1.5));
        menu.add(new MenuItem("cappuccino", 250, 50, 24, 3));
    }

    public String getItems(){
        StringBuilder options = new StringBuilder();
        for (MenuItem item : menu){
            options.append(item.getName()).append("/");
        }
        return options.toString();
    }

    public MenuItem findDrink(String orderName){
        for (MenuItem item: menu){
            if(item.getName().equals(orderName)){
                return item;
            }
        }
        System.out.println("Sorry your item is not available");
        return null;
    }
}
