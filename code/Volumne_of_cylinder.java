import java.util.*;
public class Volumne_of_cylinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int radius = sc.nextInt();
        int height = sc.nextInt();
        double volume = radius * radius * 3.14 * height;
        System.out.println(volume);
    }
}
