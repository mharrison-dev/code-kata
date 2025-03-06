package tdd.mar.romannumeralcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class RomanNumeralCalculatorTest {
  @Test
    public void addIAndIToGetII(){
      RomanNumeralCalculator romanNumeralCalculator = new RomanNumeralCalculator();

      String expectedSum = "II";
      String actualSum = romanNumeralCalculator.add("I", "I");
      assertEquals(expectedSum, actualSum);
  }
}