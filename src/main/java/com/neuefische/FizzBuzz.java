package com.neuefische;

public class FizzBuzz {
    public static String calculate(int number) {

        if (number % 15 == 0) {
            return "fizzbuzz";
        }

        if (number % 3 == 0) {
            return "fizz";
        }
        if (number % 5 == 0) {
            return "buzz";
        }

        return String.valueOf(number);
    }
}
