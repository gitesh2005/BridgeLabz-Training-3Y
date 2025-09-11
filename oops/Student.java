import java.util.Scanner;

class Student {
    String name;
    int age;
    double marks;

    // Default constructor
    Student() {
        name = "Unknown";
        age = 0;
        marks = 0.0;
    }

    // Parameterized constructor
    Student(String name, int age, double marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Method to display student details
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Using default constructor
        Student s1 = new Student();
        System.out.println("Default Student Details:");
        s1.display();

        // Taking input from user for parameterized constructor
        System.out.println("\nEnter student name: ");
        String n = sc.nextLine();
        System.out.println("Enter student age: ");
        int a = sc.nextInt();
        System.out.println("Enter student marks: ");
        double m = sc.nextDouble();

        Student s2 = new Student(n, a, m);
        System.out.println("\nStudent Details from Parameterized Constructor:");
        s2.display();

        sc.close();
    }
}
