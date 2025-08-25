import java.util.Scanner;

public class StringIndexDemo {
    public static void generateException(String str) {
        System.out.println(str.charAt(str.length())); // beyond range
    }

    public static void handleException(String str) {
        try {
            System.out.println(str.charAt(str.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.next();

        // Uncomment to see abrupt stop
        // generateException(str);

        handleException(str);
    }
}
