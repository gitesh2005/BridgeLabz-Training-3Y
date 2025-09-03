import java.util.*;

public class MaxOfThree {
    static Scanner sc = new Scanner(System.in);

    public static int inputNumber(String msg) {
        System.out.print(msg);
        return sc.nextInt();
    }

    public static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        int a = inputNumber("Enter first number: ");
        int b = inputNumber("Enter second number: ");
        int c = inputNumber("Enter third number: ");

        System.out.println("Maximum: " + findMax(a, b, c));
    }
}
