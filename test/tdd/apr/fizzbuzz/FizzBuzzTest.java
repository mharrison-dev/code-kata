package tdd.apr.fizzbuzz;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    private FizzBuzz fizzBuzz = null;
    private ByteArrayOutputStream byteArrayOutputStream = null;
    private final PrintStream consolePrintStream = System.out;

    @BeforeEach
    public void setUp() {
        fizzBuzz = new FizzBuzz();
        byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream testPrintStream = new PrintStream(byteArrayOutputStream);
        System.setOut(testPrintStream);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(consolePrintStream);
    }

    @Test
    public void shouldNotPrint_whenNumberIsNotDivisibleByThreeOrFive() {
        int number = 16;

        fizzBuzz.print(number);
        System.out.flush();

        String expectedPrintStatement = "";
        String actualPrintStatement = byteArrayOutputStream.toString();
        assertEquals(expectedPrintStatement, actualPrintStatement);
    }

    @Test
    public void shouldPrintFizz_whenNumberIsDivisibleByThree() {
        int number = 6;

        fizzBuzz.print(number);
        System.out.flush();

        String expectedPrintStatement = "Fizz";
        String actualPrintStatement = byteArrayOutputStream.toString();
        assertEquals(expectedPrintStatement, actualPrintStatement);
    }

    @Test
    public void shouldPrintBuzz_whenNumberIsDivisibleByFive() {
        int number = 10;

        fizzBuzz.print(number);
        System.out.flush();

        String expectedPrintStatement = "Buzz";
        String actualPrintStatement = byteArrayOutputStream.toString();
        assertEquals(expectedPrintStatement, actualPrintStatement);
    }
}