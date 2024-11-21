# Test-Driven Development (TDD)

## Learning Objectives
- [ ] Understanding Test-Driven Development (TDD) as a development approach
- [ ] Recognizing the benefits of TDD and its significance in software development
- [ ] Applying the TDD cycle: Red-Green-Refactor
- [ ] Writing simple unit tests in Java

## Introduction to Test-Driven Development (TDD)
Test-Driven Development (TDD) is an agile development approach where developers write tests before implementing the actual functionality. The TDD cycle consists of three steps: Red, Green, and Refactor.

1. **Red**: First, we write a test that describes the desired functionality but fails because the implementation does not exist yet.

2. **Green**: Then, we implement the code to make the test pass.

3. **Refactor**: Afterwards, we improve the code, keeping it clean and understandable without affecting the tests.

TDD offers many advantages, such as:
- Early detection of errors and issues
- Ensuring test coverage
- Better understanding of requirements
- Structuring the code through iterative development

> 💡 TDD also promotes incremental expansion of functionality, which is helpful when we add new content in the coming weeks.

## The TDD Cycle in Detail
The TDD cycle follows a clear sequence:

### Step 1: Red - Write Test
In this step, we describe the desired behavioral aspect of the function we want to develop by writing a test. The test should initially fail since the implementation does not exist yet.

```java
// Beispiel: Wir wollen eine Funktion schreiben, die die Summe zweier Zahlen berechnet.
@Test
public void testAddition() {
    int result = Calculator.add(2, 3);
    assertEquals(5, result); // Der Test schlägt zuerst fehl, da die Funktion add noch nicht implementiert ist.
}
```

### Step 2: Green - Implement
Now, we write the simplest code that makes the test pass. This code does not have to be optimal or complete, but it should fulfill the test result.

```java
public class Calculator {
    public static int add(int a, int b) {
        return a + b; // Die einfachste Implementierung, um den Test zu bestehen.
    }
}
```

### Step 3: Refactor - Improve
After the test passes, we can improve and clean up the code without changing the functionality. This helps continuously improve the code quality.

```java
public class Calculator {
    public static int add(int a, int b) {
        return a + b; // Hier könnten wir den Code weiter optimieren, z.B. indem wir ihn lesbarer gestalten.
    }
}
```

> 💡 Note that TDD encourages us to think about code quality early on and continuously improve it.