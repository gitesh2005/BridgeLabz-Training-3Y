import java.util.Scanner;

public class KilometersToMiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take distance in kilometers
        System.out.print("Enter distance in kilometers: ");
        double kilometers = scanner.nextDouble();

        // Convert to miles
        double miles = kilometers * 0.621371;

        // Display result
        System.out.println(kilometers + " kilometers is equal to " + miles + " miles.");

        scanner.close();
    }
}
