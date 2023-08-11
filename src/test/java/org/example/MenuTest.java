package org.example;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuTest extends TestCase {

    @Test
    public void testGetItems() {
        Menu menu = new Menu();
        String expectedOutput = "latte/espresso/cappuccino/";
        assertEquals(expectedOutput, menu.getItems());


    }

    @Test
    public void testFindDrink() {
        Menu menu = new Menu();
        MenuItem foundItem = menu.findDrink("latte");
        assertNotNull(foundItem);
        assertEquals("latte", foundItem.getName());



    }

    @Test
    public void testNotFindDrink() {
        Menu menu = new Menu();
        MenuItem notFoundItem = menu.findDrink("es jeruk");
        assertNull(notFoundItem);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        menu.findDrink("mocha");

        // Restore normal output
        System.setOut(System.out);

        assertEquals("Sorry your item is not available\n", outputStream.toString());
    }
}