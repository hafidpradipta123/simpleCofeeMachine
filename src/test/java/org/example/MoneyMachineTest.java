package org.example;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyMachineTest {

    @Test
    public void report() {
        MoneyMachine moneyMachine = new MoneyMachine();
        moneyMachine.makePayments(2.5, 5);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        moneyMachine.report();

        // Restore normal output
        System.setOut(System.out);

        String expectedOutput = "Money$2.5\n";
        assertEquals(expectedOutput, outputStream.toString());

    }

    @Test
    public void processCoin() {
        MoneyMachine moneyMachine = new MoneyMachine();
        String input = "2\n3\n4\n10\n"; // Simulate user input
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Redirect System.out for testing
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        double totalMoneyReceived = moneyMachine.processCoin();

        // Restore normal input and output
        System.setIn(originalSystemIn);
        System.setOut(System.out);

        double expectedTotal = (0.25 * 2) + (0.10 * 3) + (0.05 * 4) + (0.01 * 10);
        assertEquals(expectedTotal, totalMoneyReceived, 0.001);

        String expectedOutput =
                "How many quarters (0.25)?:\nHow many dimes (0.10)?:\nHow many nickels (0.05)?:\nHow many pennies (0.01)?:\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void makePayments() {
        MoneyMachine moneyMachine = new MoneyMachine();
        boolean paymentResult =  moneyMachine.makePayments(2.5,5);
        assertTrue(paymentResult);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        moneyMachine.makePayments(2.5,5);
        // Restore normal output
        System.setOut(System.out);

        String expectedOutput = "Here is your change$ 2.50\n";
        assertEquals(expectedOutput, outputStream.toString());

    }

    @Test
    public void failedMakePayments() {
        MoneyMachine moneyMachine = new MoneyMachine();
        boolean paymentResult =  moneyMachine.makePayments(2.5,1);
        assertFalse(paymentResult);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        moneyMachine.makePayments(2.5,1);
        // Restore normal output
        System.setOut(System.out);

        String expectedOutput = "Sorry you don't have enough money. The money refunded\n";
        assertEquals(expectedOutput, outputStream.toString());

    }
}