## Notes: TDD

- Write test first and then generate the Class and Method from it:

```java
package com.neuefische;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FizzBuzzTest {

    @Test
    void expect1_whenGivenNumber1(){
        // GIVEN
        int number = 1;
        // WHEN
        // Hover on the FizzBuzz to create a class "FizzBuzz", same twith "calculation" method
        String actualResult = FizzBuzz.calculate(number); 
        // THEN
        String expectedResult = "1";
        Assertions.assertEquals(expectedResult, actualResult);

    }
}
```

```java
public class FizzBuzz {
    public static String calculate(int number) {
        return number;
    }
}

// If you want the expected result to be a number and not a string:

public class FizzBuzz {
    public static String calculate(int number) {
        return String.valueOf(number);
    }
}

```


