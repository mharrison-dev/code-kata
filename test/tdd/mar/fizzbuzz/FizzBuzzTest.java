package tdd.mar.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    @Test
    public void printFizzForMultipleOfThree() {
        int number = 3;
        FizzBuzz fizzBuzz = new FizzBuzz();

        String expectedString = "Fizz";
        String actualString = fizzBuzz.convert(number);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void printBuzzForMultipleOfFive() {
        int number = 5;
        FizzBuzz fizzBuzz = new FizzBuzz();

        String expectedString = "Buzz";
        String actualString = fizzBuzz.convert(number);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void printFizzBuzzForMultipleOfThreeAndFive() {
        int number = 3 * 5;
        FizzBuzz fizzBuzz = new FizzBuzz();

        String expectedString = "FizzBuzz";
        String actualString = fizzBuzz.convert(number);
        assertEquals(expectedString, actualString);
    }
}