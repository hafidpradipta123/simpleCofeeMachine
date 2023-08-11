package org.example;

import java.util.Scanner;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        MoneyMachine moneyMachine = new MoneyMachine();
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        Menu menu = new Menu();
        boolean isOn = true;
        Scanner scanner = new Scanner(System.in);

        while (isOn){
            System.out.printf("What would you like ?" + menu.getItems() + ": ");
            String choice = scanner.nextLine();
            if (choice.equals("off") ){
                isOn = false;
            }
            else if (choice.equals("report")){
                coffeeMaker.report();
                moneyMachine.report();
            }
            else{
                MenuItem drink = menu.findDrink(choice);
                double moneyReceived = moneyMachine.processCoin();
                if(coffeeMaker.isResourcesSufficient(drink.getIngredients()) && moneyMachine.makePayments(drink.getCost(), moneyReceived) ){
                    coffeeMaker.makeCoffee(drink);
                }

            }
        }

    }
}