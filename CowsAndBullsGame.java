package myapp;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
public class CowsAndBullsGame {
    String secretNumber;
    private int attempts;

    public CowsAndBullsGame() {
        this.secretNumber = generateSecretNumber();
        this.attempts = 0;
    }

    String generateSecretNumber() {
        Random random = new Random();
        Set<Integer> digits = new HashSet<>();
        StringBuilder number = new StringBuilder();

        while (number.length() < 4) {
            int digit = random.nextInt(10);
            if (digits.add(digit)) {  
                number.append(digit);
            }
        }
        return number.toString();
    }

    boolean isValidGuess(String guess) {
        
        if (guess.length() != 4) {
      
            return false;
        }
        
        
        if (!guess.matches("\\d+")) {
            
            return false;
        }
        
        
        long uniqueCount = guess.chars().distinct().count();
        if (uniqueCount != 4) {
            
            return false;
        }
        
        return true;
    }

    int[] calculateCowsAndBulls(String guess) {
        int cows = 0, bulls = 0;
        for (int i = 0; i < 4; i++) {
            if (guess.charAt(i) == secretNumber.charAt(i)) {
                bulls++;
            } else if (secretNumber.contains(String.valueOf(guess.charAt(i)))) {
                cows++;
            }
        }
        return new int[]{cows, bulls};
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Cows and Bulls Game!");
        System.out.println("Guess the 4-digit number with unique digits.");

        while (true) {
            System.out.print("Enter your guess: ");
            String guess = scanner.nextLine();

            if (!isValidGuess(guess)) {
                continue;
            }

            attempts++;
            int[] result = calculateCowsAndBulls(guess);
            int cows = result[0];
            int bulls = result[1];

            if (bulls == 4) {
                System.out.println("Congratulations! You've guessed the number " + secretNumber + " in " + attempts + " attempts.");
                break;
            } else {
                System.out.println("Cows: " + cows + ", Bulls: " + bulls);
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        CowsAndBullsGame game = new CowsAndBullsGame();
        game.play();
    }
}


