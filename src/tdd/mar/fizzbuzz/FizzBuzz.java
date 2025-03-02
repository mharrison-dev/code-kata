package tdd.mar.fizzbuzz;

public class FizzBuzz {
    public String convert(int number) {
        String string = "";
        if (number % 3 == 0) {
            string += "Fizz";
        }

        if (number % 5 == 0) {
            string += "Buzz";
        }

        return string;
    }
}
