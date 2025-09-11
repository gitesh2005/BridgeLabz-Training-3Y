// Employee class
class Employee {
    private String name;
    private final int id;           // final so it can't be changed
    private String designation;

    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
    }

    public void displayEmployee() {
        if (this instanceof Employee) {
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        } else {
            System.out.println("Not an Employee object");
        }
    }
}

// Company class
class Company {
    private static String companyName;
    private static int totalEmployees = 0;
    private Employee[] employees;
    private int count;

    public Company(String name, int size) {
        companyName = name;
        employees = new Employee[size];
        count = 0;
    }

    public void addEmployee(Employee emp) {
        if (count < employees.length) {
            employees[count++] = emp;
            totalEmployees++;
            System.out.println("Employee added successfully!");
        } else {
            System.out.println("Company employee limit reached!");
        }
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void displayCompany() {
        System.out.println("\n--- " + companyName + " Employee List ---");
        for (int i = 0; i < count; i++) {
            employees[i].displayEmployee();
            System.out.println("----------------------");
        }
        System.out.println("Total Employees in Company: " + totalEmployees);
    }
}

// Main class
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee e1 = new Employee("Thamarai", 101, "Software Engineer");
        Employee e2 = new Employee("Rohan", 102, "Project Manager");

        Company company = new Company("Tech Solutions Inc.", 5);
        company.addEmployee(e1);
        company.addEmployee(e2);

        Company.displayTotalEmployees();
        company.displayCompany();
    }
}
