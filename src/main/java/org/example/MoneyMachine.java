package org.example;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class MoneyMachine {
    private static final String CURRENCY = "$";

    private static final LinkedHashMap<String, Double> COIN_VALUES = new LinkedHashMap<>();
    static {
        COIN_VALUES.put("quarters (0.25)", 0.25);
        COIN_VALUES.put("dimes (0.10)", 0.10);
        COIN_VALUES.put("nickels (0.05)", 0.05);
        COIN_VALUES.put("pennies (0.01)", 0.01);
    }

    private double moneyReceived;
    private double profit;

    public MoneyMachine(){
        moneyReceived = 0;
        profit =0;
    }

    public void report(){
        System.out.println("Money" + CURRENCY + profit);
    }

    public double processCoin(){
        Scanner scanner = new Scanner(System.in);
        for (String coin : COIN_VALUES.keySet()){
            System.out.println("How many " + coin + "?:");
            int numCoins = scanner.nextInt();
            moneyReceived += numCoins * COIN_VALUES.get(coin);
        }
        return moneyReceived;

    }

    public boolean makePayments(double cost, double moneyReceived){
        if(moneyReceived >= cost){
            double change = moneyReceived - cost;
            DecimalFormat f = new DecimalFormat("##.00");
            System.out.println("Here is your change" + CURRENCY + " " + f.format(change));
            profit += cost;
            moneyReceived = 0;
            return true;
        } else{
            System.out.println("Sorry you don't have enough money. The money refunded");
            moneyReceived =0;
            return false;
        }
    }


}
