import java.util.Random;
import java.util.Scanner;

public class numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int score = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;

            System.out.println("\nRound " + (rounds + 1));
            System.out.println("Guess the number between " + lowerBound + " and " + upperBound + ".");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number " + targetNumber + " in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            rounds++;
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.nextLine();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        } while (true);

        System.out.println("Game over!");
        System.out.println("Your total score: " + score);
    }
}

