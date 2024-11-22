package com.neuefische;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class PlayerCharacterTest {
    /*
    #### 1. Project Setup: "The 2D Game Board and the Game Character"

    **Goal**: Develop a simple 2D game board and a game character.
    The game board is a grid where the character can move using the
    keys W (up), S (down), D (right), and A (left). Write tests to
    ensure that the game character moves correctly.
    */

    @BeforeEach
    void resetAllXY() {
        // Reset x & y values to 0 for every test
        PlayerCharacter.x = 0;
        PlayerCharacter.y = 0;
    }

    @Test
    void getX_shouldReturnZero_onStart() {
        // GIVEN
        int expectedResult = 0;
        // WHEN
        int actualResult = PlayerCharacter.getX();
        // THEN
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void getY_shouldReturnZero_onStart() {
        // GIVEN
        int expectedResult = 0;
        // WHEN
        int actualResult = PlayerCharacter.getY();
        // THEN
        Assertions.assertEquals(expectedResult, actualResult);
    }

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

    @Test
    void move_ShouldReturnZero_WhenInputIsInvalid() {
        //GIVEN
        String key = "invalid";
        int expected = 0;
        //WHEN
        int actualResult = PlayerCharacter.move(key);
        //THEN
        Assertions.assertEquals(expected, actualResult);
    }
}
