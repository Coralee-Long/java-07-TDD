package com.neuefische;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FizzBuzzTest {

    @Test
    void expect1_whenGivenNumber1(){
        // GIVEN
        int number = 1;
        // WHEN
        String actualResult = FizzBuzz.calculate(number);
        // THEN
        String expectedResult = "1";
        Assertions.assertEquals(expectedResult, actualResult);

    }

    @Test
    void expect2_whenGivenNumber2(){
        // GIVEN
        int number = 2;
        // WHEN
        String actualResult = FizzBuzz.calculate(number);
        // THEN
        String expectedResult = "2";
        Assertions.assertEquals(expectedResult, actualResult);

    }

    @Test
    void expectFizz_whenGivenNumber3(){
        // GIVEN
        int number = 3;
        // WHEN
        String actualResult = FizzBuzz.calculate(number);
        // THEN
        String expectedResult = "fizz";
        Assertions.assertEquals(expectedResult, actualResult);

    }

    @Test
    void expect4_whenGivenNumber4(){
        // GIVEN
        int number = 4;
        // WHEN
        String actualResult = FizzBuzz.calculate(number);
        // THEN
        String expectedResult = "4";
        Assertions.assertEquals(expectedResult, actualResult);

    }

    @Test
    void expectBuzz_whenGivenNumber5(){
        // GIVEN
        int number = 5;
        // WHEN
        String actualResult = FizzBuzz.calculate(number);
        // THEN
        String expectedResult = "buzz";
        Assertions.assertEquals(expectedResult, actualResult);

    }

    @Test
    void expectFizzBuzz_whenGivenNumber15(){
        // GIVEN
        int number = 15;
        // WHEN
        String actualResult = FizzBuzz.calculate(number);
        // THEN
        String expectedResult = "fizzbuzz";
        Assertions.assertEquals(expectedResult, actualResult);

    }
}