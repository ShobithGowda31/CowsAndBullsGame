package myapp;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class CowsAndBullsGameTest {
    CowsAndBullsGame game;

    @BeforeEach
    void setUp() {
        game = new CowsAndBullsGame();
    }

    @Test
    void testValidGuess() {
        assertTrue(game.isValidGuess("1234"), "Valid guess should return true.");
    }

    @Test
    void testGuessWithNonNumericCharacters() {
        assertFalse(game.isValidGuess("12a4"), "Guess with non-numeric characters should return false.");
    }

    @Test
    void testGuessWithDuplicateDigits() {
        assertFalse(game.isValidGuess("1123"), "Guess with duplicate digits should return false.");
    }

    @Test
    void testGuessWithIncorrectLength() {     
        assertFalse(game.isValidGuess("123"), "Guess with incorrect length should return false.");
        assertFalse(game.isValidGuess("12345"), "Guess with incorrect length should return false.");
    }

    @Test
    void testCalculateCowsAndBulls() { 
        game.secretNumber = "1234"; 
        int[] result = game.calculateCowsAndBulls("1243");
        assertEquals(2, result[0], "Expected 2 cows for guess 1243 with secret 1234.");
        assertEquals(2, result[1], "Expected 2 bulls for guess 1243 with secret 1234.");
    }

    @Test
    void testWinningCondition() {
        game.secretNumber = "1234"; 
        int[] result = game.calculateCowsAndBulls("1234");
        assertEquals(0, result[0], "Expected 0 cows when guess matches the secret number exactly.");
        assertEquals(4, result[1], "Expected 4 bulls when guess matches the secret number exactly.");
    }
}



