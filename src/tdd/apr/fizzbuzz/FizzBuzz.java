package tdd.apr.fizzbuzz;

public class FizzBuzz {
    public void print(int number) {
        if (number % 3 == 0) {
            System.out.print("Fizz");
        }

        if (number % 5 == 0) {
            System.out.print("Buzz");
        }

        if (number % 3 != 0 && number % 5 != 0) {
            System.out.print(number);
        }
    }
}