import java.util.Scanner;

public class SumNatural {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a natural number (>0)");
        } else {
            // Formula: n*(n+1)/2
            int sumFormula = n * (n + 1) / 2;

            // Using for loop
            int sumLoop = 0;
            for (int i = 1; i <= n; i++) {
                sumLoop += i;
            }

            System.out.println("Sum using formula = " + sumFormula);
            System.out.println("Sum using for loop = " + sumLoop);

            if (sumFormula == sumLoop) {
                System.out.println("Both results match ");
            } else {
                System.out.println("Results do not match ");
            }
        }

        sc.close();
    }
}
