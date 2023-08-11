package org.example;


import java.util.HashMap;
import java.util.Map;

public class CoffeeMaker {
    private HashMap<String, Integer> resources;

    public CoffeeMaker(){
        resources = new HashMap<>();
        resources.put("water",300);
        resources.put("milk", 200);
        resources.put("coffee",100);
    }

    public void report(){
        System.out.println("Water: " + resources.get("water") +"ml");
        System.out.println("Milk: " + resources.get("milk") +"ml");
        System.out.println("Coffee: " + resources.get("coffee")+"g");

    }

    public boolean isResourcesSufficient(HashMap<String, Integer> drinkIngredients){
        boolean canMake = true;
        for(String item: drinkIngredients.keySet()){
            if (drinkIngredients.get(item) > resources.getOrDefault(item,0)){
                System.out.println("There is not enough" + item);
                canMake = false;
            }
        }
        return canMake;

    }

    public void makeCoffee(MenuItem order){
        for (String item : order.getIngredients().keySet()){
            resources.put(item, resources.get(item) - order.getIngredients().get(item));
        }
        System.out.println("Here is your " + order.getName()+ " enjoy!!");
    }


}
