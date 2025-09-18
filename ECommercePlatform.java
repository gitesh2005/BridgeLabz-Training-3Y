// Abstract Product class
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Abstract method for discount
    public abstract double calculateDiscount();

    // Getters and Setters (Encapsulation)
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}

// Interface for Taxable products
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Electronics product
class Electronics extends Product implements Taxable {
    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax: " + calculateTax();
    }
}

// Clothing product
class Clothing extends Product implements Taxable {
    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15; // 15% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% GST
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax: " + calculateTax();
    }
}

// Groceries product
class Groceries extends Product {
    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return 0; // No discount
    }
}

// Main class
public class ECommercePlatform {
    // Method to calculate final price using polymorphism
    public static void printFinalPrice(Product p) {
        double tax = 0;
        if (p instanceof Taxable) {
            tax = ((Taxable) p).calculateTax();
        }
        double finalPrice = p.getPrice() + tax - p.calculateDiscount();
        System.out.println("Product: " + p.getName());
        System.out.println("Original Price: " + p.getPrice());
        if (p instanceof Taxable) {
            System.out.println(((Taxable) p).getTaxDetails());
        }
        System.out.println("Discount: " + p.calculateDiscount());
        System.out.println("Final Price: " + finalPrice);
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        Product p1 = new Electronics(101, "Laptop", 50000);
        Product p2 = new Clothing(102, "T-Shirt", 1000);
        Product p3 = new Groceries(103, "Rice", 200);

        Product[] products = { p1, p2, p3 };

        for (Product p : products) {
            printFinalPrice(p);
        }
    }
}
