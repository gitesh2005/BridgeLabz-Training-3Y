import java.util.Scanner;

public class PowerCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take base input
        System.out.print("Enter the base number: ");
        double base = scanner.nextDouble();

        // Take exponent input
        System.out.print("Enter the exponent: ");
        double exponent = scanner.nextDouble();

        // Calculate power using Math.pow
        double result = Math.pow(base, exponent);

        // Display result
        System.out.println(base + " raised to the power " + exponent + " is: " + result);

        scanner.close();
    }
}
