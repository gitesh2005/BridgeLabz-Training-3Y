import java.util.Scanner;

public class perimeter_of_rectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lenght = sc.nextInt();
        int  weidth = sc.nextInt();
        double perimete_of_rectangle = 2 * (lenght  + weidth);
        System.out.println(perimete_of_rectangle);
    }
}
