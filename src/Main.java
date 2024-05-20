import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        while (playAgain) {
            String wordToGuess = storage.getRandomWord();
            int attempts = 6;
            StringBuilder guessedLetters = new StringBuilder();
            for (int i = 0; i < wordToGuess.length(); i++) {
                guessedLetters.append("_");
            }
            System.out.println("Lets play Hangman!");
            while (attempts > 0 && guessedLetters.toString().contains("_")) {
                System.out.println("Word: " + guessedLetters);
                System.out.println("Attempts Left :" + attempts);
                System.out.println("Guess a letter :");
                char guess = scanner.next().charAt(0);
                if (wordToGuess.contains(String.valueOf(guess))) {
                    for (int i = 0; i < wordToGuess.length(); i++) {
                        if (wordToGuess.charAt(i) == guess) {
                            guessedLetters.setCharAt(i, guess);
                        }
                    }
                } else {
                    attempts--;
                    System.out.println("Incorrect guess!");
                }
            }
            if (!guessedLetters.toString().contains("_")) {
                System.out.println("Congratulations! You guessed the word: " + wordToGuess);
            } else {
                System.out.println("Out of attempts! The word was: " + wordToGuess);
            }
            System.out.println("Do you want to play again (yes/no)");
            String playAgainResponse = scanner.next().toLowerCase();
            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }
        }
        System.out.println("Thank you for playing");
    }
}
