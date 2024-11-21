package com.neuefische;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class GameTest {

    @Test
    void characterInitialPosition() {
        // GIVEN: A game board of 5x5
        Gameboard gameboard = new Gameboard(5, 5);

        // WHEN: Retrieving the character's initial position
        Point actualPosition = gameboard.getCharacterPosition();

        // THEN: The initial position should be (0, 0)
        Point expectedPosition = new Point(0, 0);
        Assertions.assertEquals(expectedPosition, actualPosition);
    }

    @Test
    void characterMovesDownWhenSKeyIsPressed() {
        // GIVEN: A game board of 5x5
        Gameboard gameboard = new Gameboard(5, 5);

        // WHEN: Character moves down
        Point actualPosition = gameboard.moveCharacter('S'); // Down

        // THEN: Character's position should be (0, 1)
        Point expectedPosition = new Point(0, 1);
        Assertions.assertEquals(expectedPosition, actualPosition);
    }

    @Test
    void characterMovesUpWhenWKeyIsPressed() {
        // GIVEN: A game board of 5x5
        Gameboard gameboard = new Gameboard(5, 5);
        gameboard.moveCharacter('S'); // Move down first to (0, 1)

        // WHEN: Character moves up
        Point actualPosition = gameboard.moveCharacter('W'); // Up

        // THEN: Character's position should return to (0, 0)
        Point expectedPosition = new Point(0, 0);
        Assertions.assertEquals(expectedPosition, actualPosition);
    }

    @Test
    void characterMovesRightWhenDKeyIsPressed() {
        // GIVEN: A game board of 5x5
        Gameboard gameboard = new Gameboard(5, 5);

        // WHEN: Character moves right
        Point actualPosition = gameboard.moveCharacter('D'); // Right

        // THEN: Character's position should be (1, 0)
        Point expectedPosition = new Point(1, 0);
        Assertions.assertEquals(expectedPosition, actualPosition);
    }

    @Test
    void characterMovesLeftWhenAKeyIsPressed() {
        // GIVEN: A game board of 5x5
        Gameboard gameboard = new Gameboard(5, 5);
        gameboard.moveCharacter('D'); // Move right first to (1, 0)

        // WHEN: Character moves left
        Point actualPosition = gameboard.moveCharacter('A'); // Left

        // THEN: Character's position should return to (0, 0)
        Point expectedPosition = new Point(0, 0);
        Assertions.assertEquals(expectedPosition, actualPosition);
    }

    @Test
    void characterCannotMoveBelowBottomEdge() {
        // GIVEN: A game board of 2x2
        Gameboard gameboard = new Gameboard(2, 2);
        gameboard.moveCharacter('S'); // Move down to (0, 1)
        gameboard.moveCharacter('S'); // Attempt to move below the bottom edge

        // WHEN: Retrieving the character's position
        Point actualPosition = gameboard.getCharacterPosition();

        // THEN: Character should remain at (0, 1)
        Point expectedPosition = new Point(0, 1);
        Assertions.assertEquals(expectedPosition, actualPosition);
    }

    @Test
    void characterCannotMoveAboveTopEdge() {
        // GIVEN: A game board of 2x2
        Gameboard gameboard = new Gameboard(2, 2);

        // WHEN: Attempt to move up at the top edge
        gameboard.moveCharacter('W'); // Invalid move
        Point actualPosition = gameboard.getCharacterPosition();

        // THEN: Character should remain at (0, 0)
        Point expectedPosition = new Point(0, 0);
        Assertions.assertEquals(expectedPosition, actualPosition);
    }

    @Test
    void characterCannotMoveLeftOfLeftEdge() {
        // GIVEN: A game board of 2x2
        Gameboard gameboard = new Gameboard(2, 2);

        // WHEN: Attempt to move left at the left edge
        gameboard.moveCharacter('A'); // Invalid move
        Point actualPosition = gameboard.getCharacterPosition();

        // THEN: Character should remain at (0, 0)
        Point expectedPosition = new Point(0, 0);
        Assertions.assertEquals(expectedPosition, actualPosition);
    }

    @Test
    void characterCannotMoveRightOfRightEdge() {
        // GIVEN: A game board of 2x2
        Gameboard gameboard = new Gameboard(2, 2);
        gameboard.moveCharacter('D'); // Move right to (1, 0)

        // WHEN: Attempt to move right beyond the right edge
        gameboard.moveCharacter('D'); // Invalid move
        Point actualPosition = gameboard.getCharacterPosition();

        // THEN: Character should remain at (1, 0)
        Point expectedPosition = new Point(1, 0);
        Assertions.assertEquals(expectedPosition, actualPosition);
    }

    @Test
    void characterDoesNotMoveOnInvalidInput() {
        // GIVEN: A game board of 5x5
        Gameboard gameboard = new Gameboard(5, 5);

        // WHEN: Invalid input is given
        gameboard.moveCharacter('X'); // Invalid key
        Point actualPosition = gameboard.getCharacterPosition();

        // THEN: Character's position should remain at (0, 0)
        Point expectedPosition = new Point(0, 0);
        Assertions.assertEquals(expectedPosition, actualPosition);
    }
}
