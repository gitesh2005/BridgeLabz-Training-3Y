import java.util.*;

public class NumberGuessingGame {
    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);

    public static int generateGuess(int low, int high) {
        return rand.nextInt(high - low + 1) + low;
    }

    public static String getFeedback(int guess) {
        System.out.print("Is " + guess + " correct, high, or low? ");
        return sc.next().toLowerCase();
    }

    public static void main(String[] args) {
        int low = 1, high = 100;
        String feedback = "";

        System.out.println("Think of a number between 1 and 100.");
        while (!feedback.equals("correct")) {
            int guess = generateGuess(low, high);
            feedback = getFeedback(guess);

            if (feedback.equals("low")) {
                low = guess + 1;
            } else if (feedback.equals("high")) {
                high = guess - 1;
            } else if (!feedback.equals("correct")) {
                System.out.println("Please enter 'low', 'high', or 'correct'.");
            }
        }
        System.out.println("Yay! The computer guessed your number!");
    }
}
