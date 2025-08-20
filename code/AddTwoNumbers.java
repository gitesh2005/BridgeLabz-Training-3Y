
import java.util.Scanner;
public class AddTwoNumbers {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Taking first number as input
            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();

            // Taking second number as input
            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            // Calculating sum
            double sum = num1 + num2;

            // Displaying result
            System.out.println("The sum is: " + sum);

            scanner.close();
        }
    }
