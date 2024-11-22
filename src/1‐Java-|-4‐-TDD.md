# Test-Driven Development (TDD)

➡️ [Skip to English Version](#english-version)

## Einleitung

- **Test-Driven Development (TDD)** ist ein agiler Ansatz in der Softwareentwicklung, bei dem Tests geschrieben werden, bevor die eigentliche Funktionalität implementiert wird.
- Es fördert die schrittweise Entwicklung von Code durch einen Zyklus aus drei Schritten: **Red**, **Green**, **Refactor**.

### Der TDD-Zyklus:
1. **Red**: Schreibe einen Test für die gewünschte Funktionalität, der zunächst fehlschlägt (da die Implementierung noch nicht existiert).
2. **Green**: Schreibe den einfachsten möglichen Code, um den Test erfolgreich zu bestehen.
3. **Refactor**: Verbessere den Code, ohne das Verhalten zu ändern.

### Hauptvorteile von TDD:
- **Frühe Fehlererkennung**: Probleme werden früh im Prozess erkannt.
- **Sicherstellung der Testabdeckung**: Jede Funktionalität wird getestet.
- **Verbesserung der Codequalität**: Fördert sauberen und wartbaren Code.
- **Besseres Verständnis der Anforderungen**: Klärt das gewünschte Verhalten des Codes.
- **Beschleunigt die Entwicklung**: Reduziert die Debugging-Zeit und eliminiert zusätzliche Tests am Ende eines Projekts.

> 💡 **Tipp**: TDD fördert die inkrementelle Entwicklung und ist besonders nützlich für logiklastige Anwendungen.

---

## Aufgaben

### A. Fragen

**Wofür wird TDD verwendet? Was sind die Vorteile?**
- Verbessert die Codequalität.
- Reduziert die Debugging-Zeit.
- Simultanes Testen und Entwickeln.
- Bietet eine strukturierte Herangehensweise zur Problemlösung.

**Für welche der Programmieraufgaben „Entwerfe eine schöne Webseite“, „Implementiere eine Berechnungslogik“ und „Erstelle den Datenaustausch mit anderen Programmen“ ist TDD am besten geeignet? Warum?**
- **„Implementiere eine Berechnungslogik“**, da dies die konkreteste Aufgabe ist und leicht in kleinere Testeinheiten (Units) unterteilt werden kann.

**Was sind die grundlegenden Schritte im TDD-Prozess?**
1. Schreibe einen Test, der zunächst fehlschlägt.
2. Setze einen Test mit einem erwarteten Ergebnis auf.
3. Implementiere eine Methode, die dieses erwartete Ergebnis zurückgibt.
4. Schreibe Schritt für Schritt weitere Tests für unterschiedliche gewünschte Ergebnisse.
5. Korrigiere die Methode, falls Tests fehlschlagen.
6. Wiederhole den Prozess, bis alle Tests erfolgreich sind.
7. Refaktoriere den Code (Clean-Up).

**Welche Rolle spielen Unit-Tests im TDD-Prozess?**
- Dokumentieren den Code und reduzieren potenzielle Fehler.
- Stellen sicher, dass der Code wartbar und sauber bleibt.
- Testen eine spezifische, kleine Funktionalität (Unit) und nicht deren Interaktionen.

**Wie kann TDD die Geschwindigkeit der Softwareentwicklung erhöhen?**
- Reduziert die Zeit für manuelle Tests.
- Erleichtert die Planung durch klaren Überblick über die Anforderungen.
- Vermeidet Nacharbeiten am Ende des Projekts.
- Fördert wartbaren Code, der einfacher angepasst werden kann.

---

### B. Codierungsaufgaben

#### 1. Projekt Setup: Das 2D-Spielbrett und der Charakter
**Ziel**: Erstellen Sie ein einfaches 2D-Spielbrett und eine steuerbare Spielfigur. Die Spielfigur bewegt sich in vier Richtungen:
- **W**: Nach oben
- **S**: Nach unten
- **D**: Nach rechts
- **A**: Nach links

Tests sollen sicherstellen, dass die Spielfigur entsprechend der Eingabe korrekt bewegt wird.

> 💡 **Tipp**: Verwenden Sie eine `@BeforeEach`-Methode, um die Werte von `x` und `y` vor jedem Test auf `0` zurückzusetzen. Dies gewährleistet die Unabhängigkeit der Tests und einen konsistenten Anfangszustand.
```java
@BeforeEach
void resetAllXY() {
  // Setzt die Werte von x & y für jeden Test auf 0 zurück
  PlayerCharacter.x = 0;
  PlayerCharacter.y = 0;
}
```
---

#### 2. Write Initial Tests: `getX` and `getY`

1. **Test `getX`**: Überprüft, ob die Methode `getX` in der Klasse `PlayerCharacter` beim Spielstart den Wert `0` zurückgibt.
```java
@Test
void getX_shouldReturnZero_onStart() {
    // GEGEBEN
    int expectedResult = 0;
    // WENN
    int actualResult = PlayerCharacter.getX();
    // DANN
    Assertions.assertEquals(expectedResult, actualResult);
}
```

2. **Test `getY`**: Überprüft, ob die Methode `getY` in der Klasse `PlayerCharacter` beim Spielstart den Wert `0` zurückgibt.
```java
@Test
void getY_shouldReturnZero_onStart() {
    // GEGEBEN
    int expectedResult = 0;
     // WENN
     int actualResult = PlayerCharacter.getY();
     // DANN
     Assertions.assertEquals(expectedResult, actualResult);
}
```
**Erwartetes Ergebnis**: Beide Tests schlagen zunächst fehl, da die Klasse `PlayerCharacter` und ihre Methoden noch nicht implementiert sind.

---
#### 3. Minimale Implementierung: `getX` und `getY`

- Implementieren Sie die Klasse `PlayerCharacter` sowie die Methoden `getX` und `getY`, um die Tests zu bestehen.
```java
public class PlayerCharacter {
    public static int x = 0;
    public static int y = 0;

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }
}
```
---

#### 4. Schreiben Sie Tests für `move`

**Ziel**: Sicherstellen, dass sich die Spielfigur entsprechend der Eingabe korrekt bewegt:
- **W**: Erhöht `y` um 1.
- **S**: Verringert `y` um 1.
- **D**: Erhöht `x` um 1.
- **A**: Verringert `x` um 1.

### Tests:
```java
@Test
void moveW_shouldIncrementYbyOne() {
    // GEGEBEN
    String key = "W";
    int expectedResult = 1;
    // WENN
    int actualResult = PlayerCharacter.move(key);
    // DANN
    Assertions.assertEquals(expectedResult, actualResult);
}

@Test
void moveS_shouldDecrementYbyOne() {
    // GEGEBEN
    String key = "S";
    int expectedResult = -1;
    // WENN
    int actualResult = PlayerCharacter.move(key);
    // DANN
    Assertions.assertEquals(expectedResult, actualResult);
}

@Test
void moveD_shouldIncrementXbyOne() {
    // GEGEBEN
    String key = "D";
    int expectedResult = 1;
    // WENN
    int actualResult = PlayerCharacter.move(key);
    // DANN
    Assertions.assertEquals(expectedResult, actualResult);
}

@Test
void moveA_shouldDecrementXbyOne() {
    // GEGEBEN
    String key = "A";
    int expectedResult = -1;
    // WENN
    int actualResult = PlayerCharacter.move(key);
    // DANN
    Assertions.assertEquals(expectedResult, actualResult);
}
```

---
#### 5. Minimale Implementierung: `move`

- Implementieren Sie die Methode `move` in der Klasse `PlayerCharacter`, um die Bewegungstests zu bestehen.
```java
public static int move(String key) {
    if (key.equals("W")) {
        return ++y;
    } else if (key.equals("S")) {
        return --y;
    } else if (key.equals("D")) {
        return ++x;
    } else if (key.equals("A")) {
        return --x;
    } else {
      return 0; // Keine Bewegung bei ungültiger Eingabe
    }
}
```
---
#### 6. Refaktorierung (Optional)

- Überarbeiten und verbessern Sie den Code, um Lesbarkeit und Effizienz zu steigern.
- Ziehen Sie in Betracht, die Logik für bessere Skalierbarkeit zu kapseln (z. B. Speichern der Richtungen in einer Map).

---

#### 7. Zusätzliche Tests: Ungültige Eingaben und Sonderfälle

- Testen Sie ungültige Eingaben.
```java
@Test
void move_ShouldReturnDefault_WhenInputIsInvalid() {
    // GEGEBEN
    String invalidInput = "X";
    int expectedResult = 66;
    // WENN
    int actualResult = PlayerCharacter.move(invalidInput);
    // DANN
    Assertions.assertEquals(expectedResult, actualResult);
}
```
---

### Abschließende Hinweise

- **Testabdeckung**: Befolgen Sie die TDD-Prinzipien, um sicherzustellen, dass alle Funktionen vor der Implementierung gründlich getestet werden.
- **Fehlerbehandlung**: Berücksichtigen Sie ungültige Eingaben und Sonderfälle, um das System robust zu machen.

---

## English Version

## Introduction

- **Test-Driven Development (TDD)** is an agile approach to software development where tests are written before implementing the actual functionality.
- It promotes the incremental development of code through a cycle of three steps: **Red**, **Green**, **Refactor**.

### The TDD Cycle:
1. **Red**: Write a test for the desired functionality, which initially fails (since the implementation doesn't exist yet).
2. **Green**: Write the simplest possible code to make the test pass.
3. **Refactor**: Improve the code without changing its behavior.

### Key Benefits of TDD:
- **Early Error Detection**: Issues are caught early in the process.
- **Ensures Test Coverage**: Every functionality is tested.
- **Improves Code Quality**: Encourages clean and maintainable code.
- **Better Understanding of Requirements**: Clarifies the expected behavior of the code.
- **Speeds Up Development**: Reduces debugging time and eliminates additional tests at the end of a project.

> 💡 **Tip**: TDD promotes incremental development and is especially useful for logic-heavy applications.

---

## Tasks

### A. Questions

**What is TDD used for? What are its benefits?**
- Improves code quality.
- Reduces debugging time.
- Enables simultaneous testing and development.
- Provides a structured approach to problem-solving.

**For which programming tasks ("Design a beautiful webpage", "Implement a calculation logic", and "Build data exchange with other programs") is TDD most suitable? Why?**
- **"Implement a calculation logic"**, as it is the most concrete task and can be easily broken down into smaller testable units.

**What are the basic steps in the TDD process?**
1. Write a test that initially fails.
2. Set up a test with an expected result.
3. Implement a method that returns the expected result.
4. Write additional tests for different desired outcomes step by step.
5. Adjust the method if tests fail.
6. Repeat the process until all tests pass.
7. Refactor the code (clean-up).

**What role do unit tests play in TDD?**
- Document the code and reduce potential errors.
- Ensure the code remains maintainable and clean.
- Test a specific small functionality (unit), not its interactions.

**How can TDD speed up software development?**
- Reduces the time needed for manual testing.
- Facilitates planning by providing a clear overview of requirements.
- Avoids rework at the end of the project.
- Encourages maintainable code that can be easily adapted.

---

### B. Coding Tasks

#### 1. Project Setup: **"The 2D Game Board and the Game Character"**
**Goal**: Create a simple 2D game board and a controllable game character. The character moves in four directions:
- **W**: Up
- **S**: Down
- **D**: Right
- **A**: Left

Tests will ensure that the character moves correctly according to the input.

> 💡 **Tip**: Use a `@BeforeEach` method to reset `x` and `y` values to `0` before each test. This ensures test independence and a consistent starting state.
```java
@BeforeEach
void resetAllXY() {
  // Reset x & y values to 0 for every test
  PlayerCharacter.x = 0;
  PlayerCharacter.y = 0;
}
```
---

#### 2. Write Initial Tests: `getX` and `getY`

1. **Test `getX`**: Verifies that the `getX` method in the `PlayerCharacter` class returns `0` when the game starts.
   ```java
   @Test
   void getX_shouldReturnZero_onStart() {
       // GIVEN
       int expectedResult = 0;
       // WHEN
       int actualResult = PlayerCharacter.getX();
       // THEN
       Assertions.assertEquals(expectedResult, actualResult);
   }
   ```
   
2. **Test `getY`**: Verifies that the `getY` method in the `PlayerCharacter` class returns `0` when the game starts.
  ```java
   @Test
   void getY_shouldReturnZero_onStart() {
       // GIVEN
       int expectedResult = 0;
       // WHEN
       int actualResult = PlayerCharacter.getY();
       // THEN
       Assertions.assertEquals(expectedResult, actualResult);
   }
```
**Expected Result**: Both tests fail initially as the `PlayerCharacter` class and methods are not yet implemented.

---

#### 3. Minimal Implementation: `getX` and `getY`

- Implement the `PlayerCharacter` class and the `getX` and `getY` methods to pass the tests.
```java
public class PlayerCharacter {
    public static int x = 0;
    public static int y = 0;

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }
}
```
---

#### 4. Write Tests for `move`

**Objective**: Ensure that the character moves correctly based on the input:
- **W**: Increases `y` by 1.
- **S**: Decreases `y` by 1.
- **D**: Increases `x` by 1.
- **A**: Decreases `x` by 1.

### Tests:
```java
@Test
void moveW_shouldIncrementYbyOne() {
    // GIVEN
    String key = "W";
    int expectedResult = 1;
    // WHEN
    int actualResult = PlayerCharacter.move(key);
    // THEN
    Assertions.assertEquals(expectedResult, actualResult);
}

@Test
void moveS_shouldDecrementYbyOne() {
    // GIVEN
    String key = "S";
    int expectedResult = -1;
    // WHEN
    int actualResult = PlayerCharacter.move(key);
    // THEN
    Assertions.assertEquals(expectedResult, actualResult);
}

@Test
void moveD_shouldIncrementXbyOne() {
    // GIVEN
    String key = "D";
    int expectedResult = 1;
    // WHEN
    int actualResult = PlayerCharacter.move(key);
    // THEN
    Assertions.assertEquals(expectedResult, actualResult);
}

@Test
void moveA_shouldDecrementXbyOne() {
    // GIVEN
    String key = "A";
    int expectedResult = -1;
    // WHEN
    int actualResult = PlayerCharacter.move(key);
    // THEN
    Assertions.assertEquals(expectedResult, actualResult);
}
```
---

#### 5. Minimal Implementation: `move`

- Implement the `move` method in the `PlayerCharacter` class to pass the movement tests.
```java
public static int move(String key) {
    if (key.equals("W")) {
        return ++y;
    } else if (key.equals("S")) {
        return --y;
    } else if (key.equals("D")) {
        return ++x;
    } else if (key.equals("A")) {
        return --x;
    } else {
      return 0; // No movement for invalid input
    }
}
```
---

#### 6. Refactor (Optional)

- Review and improve code for readability and efficiency if necessary.
- Consider encapsulating logic for better scalability (e.g., storing directions in a map).

---

#### 7. Additional Tests: Invalid Inputs and Edge Cases

- Test invalid inputs.
```java
@Test
void move_ShouldReturnDefault_WhenInputIsInvalid() {
    // GIVEN
    String invalidInput = "X";
    int expectedResult = 66;
    // WHEN
    int actualResult = PlayerCharacter.move(invalidInput);
    // THEN
    Assertions.assertEquals(expectedResult, actualResult);
}
```
---

### Final Notes

- **Test Coverage**: Follow TDD principles to ensure all features are thoroughly tested before implementation.
- **Error Handling**: Account for invalid inputs and edge cases to make the system robust.

