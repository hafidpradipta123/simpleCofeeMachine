package org.example;

import java.util.HashMap;

public class MenuItem {
    private String name;
    private double cost;
    private HashMap<String, Integer> ingredients;

    public MenuItem(String name, int water, int milk, int coffee, double cost){
        this.name = name;
        this.cost = cost;
        ingredients = new HashMap<>();
        ingredients.put("water", water);
        ingredients.put("milk", milk);
        ingredients.put("coffee", coffee);

    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public HashMap<String, Integer> getIngredients() {
        return ingredients;
    }
}
