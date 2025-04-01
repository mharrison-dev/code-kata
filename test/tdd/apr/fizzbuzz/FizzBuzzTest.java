package tdd.apr.fizzbuzz;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    @Test
    public void shouldNotPrint_whenNumberIsNotDivisibleByThreeOrFive() {
        PrintStream consolePrintStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream testPrintStream = new PrintStream(byteArrayOutputStream);
        System.setOut(testPrintStream);
        int number = 16;

        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.print(number);
        System.out.flush();
        System.setOut(consolePrintStream);

        String expectedPrintStatement = "";
        String actualPrintStatement = byteArrayOutputStream.toString();
        assertEquals(expectedPrintStatement, actualPrintStatement);
    }
}