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
}