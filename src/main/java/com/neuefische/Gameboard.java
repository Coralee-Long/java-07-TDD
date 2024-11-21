package com.neuefische;

import java.awt.*;

/* BOARD VISUALIZATION:
(0, 0)  (1, 0)  (2, 0)  (3, 0)  (4, 0)  ← (y = 0)
(0, 1)  (1, 1)  (2, 1)  (3, 1)  (4, 1)
(0, 2)  (1, 2)  (2, 2)  (3, 2)  (4, 2)
(0, 3)  (1, 3)  (2, 3)  (3, 3)  (4, 3)
(0, 4)  (1, 4)  (2, 4)  (3, 4)  (4, 4)  ← (y = 4)
 */

public class Gameboard {

    // Fields to store the state of the game board
    private Point characterPosition; // Tracks the character's position on the board
    private int width; // Width of the board
    private int height; // Height of the board

    // Constructor to initialize the board dimensions and the starting position of the character
    public Gameboard(int width, int height) {
        this.characterPosition = new Point(0, 0); // Character starts at the top-left corner
        this.width = width;
        this.height = height;
    }

    // Getter method to retrieve the character's current position
    public Point getCharacterPosition() {
        return characterPosition;
    }

    // Method to move the character based on the given key input ('W', 'A', 'S', 'D')
    public Point moveCharacter(char key) {
        switch (Character.toUpperCase(key)) { // Handle case-insensitive inputs
            case 'S': // Move down
                if (characterPosition.y < height - 1) { // Ensure not at the bottom edge
                    characterPosition.translate(0, 1); // Increase y-coordinate
                }
                break;
            case 'W': // Move up
                if (characterPosition.y > 0) { // Ensure not at the top edge
                    characterPosition.translate(0, -1); // Decrease y-coordinate
                }
                break;
            case 'A': // Move left
                if (characterPosition.x > 0) { // Ensure not at the left edge
                    characterPosition.translate(-1, 0); // Decrease x-coordinate
                }
                break;
            case 'D': // Move right
                if (characterPosition.x < width - 1) { // Ensure not at the right edge
                    characterPosition.translate(1, 0); // Increase x-coordinate
                }
                break;
            default: // Invalid input
                System.out.println("Invalid direction: " + key); // Print a message for invalid input
        }
        return characterPosition; // Return the updated position
    }
}
