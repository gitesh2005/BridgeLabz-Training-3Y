import java.time.*;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first date (yyyy-MM-dd): ");
        LocalDate date1 = LocalDate.parse(sc.nextLine());

        System.out.print("Enter second date (yyyy-MM-dd): ");
        LocalDate date2 = LocalDate.parse(sc.nextLine());

        if (date1.isBefore(date2))
            System.out.println(date1 + " is before " + date2);
        else if (date1.isAfter(date2))
            System.out.println(date1 + " is after " + date2);
        else
            System.out.println(date1 + " is equal to " + date2);
    }
}
