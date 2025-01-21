import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int lowerBound = 1; // Changeable range
            int upperBound = 100;
            int attempts = 0;
            int maxAttempts = 7; // Limit attempts per round
            int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            boolean guessedCorrectly = false;

            System.out.println("\nA number has been generated between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            while (attempts < maxAttempts) {
                System.out.print("\nEnter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number correctly in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1; // Higher score for fewer attempts
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                System.out.println("Attempts remaining: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("\nSorry, you've used all attempts. The correct number was " + randomNumber + ".");
            }

            System.out.println("Your current score: " + score);
            System.out.print("\nWould you like to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("\nThank you for playing! Your final score is: " + score);
        scanner.close();
    }
}
