public class Multiplication6to9 {
    public static void main(String[] args) {
        int[] multiplicationResult = new int[10];

        for (int num = 6; num <= 9; num++) {
            System.out.println("Multiplication Table of " + num);
            for (int i = 1; i <= 10; i++) {
                multiplicationResult[i - 1] = num * i;
                System.out.println(num + " * " + i + " = " + multiplicationResult[i - 1]);
            }
            System.out.println();
        }
    }
}
