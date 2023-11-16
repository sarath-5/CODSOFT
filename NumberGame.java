import java.util.Random;
import java.util.Scanner;
public class NumberGame {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attempts = 5;
        int rounds = 0;
        int score = 0;
        System.out.println("Welcome to the Number Guessing Game!");

        while (true) 
        {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int currentAttempts = 0;
            boolean hasGuessedCorrectly = false;
            System.out.println("Round " + (rounds + 1));

            while (currentAttempts < attempts) 
            {
                System.out.print('\n' + "Guess a number between " + minRange + " and " + maxRange + ": ");
                int userGuess = scanner.nextInt();
                if (userGuess < 1 || userGuess > 100) 
                 {
                    System.out.println("The number is beyond the range of 1 to 100");
                 } 
                else 
                 {
                    if (userGuess == targetNumber) 
                    {
                        System.out.println("Congratulations! You guessed the correct number.");
                        hasGuessedCorrectly = true;
                        score++;
                        break;
                    } else if (userGuess < targetNumber) 
                    {
                        System.out.print("Sorry! Your guess is too low. Try again.");
                    } else {
                        System.out.println("Your guess is too high. Try again.");
                    }

                    currentAttempts++;
                    int remainingAttempts = attempts - currentAttempts;
                    System.out.print('\n'+"You have " + remainingAttempts + " attempts left !!!");
                 }
            }

            if (!hasGuessedCorrectly)
            {
                System.out.println('\n' + "Sorry, you are out of attempts. The correct number was: " + targetNumber);
            }

            System.out.println("Your current score: " + score);
            System.out.print('\n'+"Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println('\n'+"Thanks for playing! Your final score is " + score);
                break;
            }
            rounds++;
        }
        scanner.close();
    }
}
