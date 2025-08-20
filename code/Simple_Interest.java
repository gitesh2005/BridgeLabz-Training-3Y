import java.util.*;
public class Simple_Interest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("principle interest is: ");
        int principle = sc.nextInt();
        System.out.println("rate is : ");
        int rate = sc.nextInt();
        System.out.println("time is : ");
        int time = sc.nextInt();
        int simple_Interest = (principle * rate * time) / 100;
        System.out.println(simple_Interest);
    }
}
