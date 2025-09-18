// Abstract class FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Qty: " + quantity);
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Encapsulation
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}

// Interface Discountable
interface Discountable {
    double applyDiscount(double total);
    void getDiscountDetails();
}

// VegItem class
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();  // no extra charges
    }

    @Override
    public double applyDiscount(double total) {
        return total * 0.9; // 10% discount
    }

    @Override
    public void getDiscountDetails() {
        System.out.println("Veg items have 10% discount.");
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double base = getPrice() * getQuantity();
        return base + (base * 0.05); // 5% extra non-veg charge
    }

    @Override
    public double applyDiscount(double total) {
        return total * 0.95; // 5% discount
    }

    @Override
    public void getDiscountDetails() {
        System.out.println("Non-veg items have 5% discount and 5% non-veg charges.");
    }
}

// Main class
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem[] order = {
            new VegItem("Paneer Tikka", 200, 2),
            new NonVegItem("Chicken Biryani", 300, 1)
        };

        double totalBill = 0;

        for (FoodItem item : order) {
            item.getItemDetails();
            double total = item.calculateTotalPrice();
            System.out.println("Total before discount: " + total);

            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                d.getDiscountDetails();
                total = d.applyDiscount(total);
                System.out.println("Total after discount: " + total);
            }

            totalBill += total;
            System.out.println("----------------------");
        }

        System.out.println("Final Bill Amount: " + totalBill);
    }
}
