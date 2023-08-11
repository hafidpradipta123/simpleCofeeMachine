package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class CoffeeMakerTest {

    @Test
    void report() {
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        coffeeMaker.report();

        // Restore normal output
        System.setOut(System.out);

        String expectedOutput = "Water: 300ml\nMilk: 200ml\nCoffee: 100g\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testisResourcesSufficient() {
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        MenuItem item = new MenuItem("test", 100, 50, 10, 2.0);

        assertTrue(coffeeMaker.isResourcesSufficient(item.getIngredients()));
    }

    @Test
    void makeCoffee() {
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        MenuItem item = new MenuItem("latte",  200, 150, 24,2.5);

        // Redirect System.out for testing
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        coffeeMaker.makeCoffee(item);

        // Restore normal output
        System.setOut(System.out);

        String expectedOutput = "Here is your latte enjoy!!\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

}