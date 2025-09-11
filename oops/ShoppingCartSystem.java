class Product {
    private String name;
    private double price;
    private final String productId;

    public Product(String name, double price, String productId) {
        this.name = name;
        this.price = price;
        this.productId = productId;
    }

    public void displayProduct() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productId);
            System.out.println("Name: " + name);
            System.out.println("Price: ₹" + price);
        }
    }

    public double getPrice() {
        return price;
    }
}

class Cart {
    private static int totalItems = 0;
    private Product[] products;
    private int count;

    public Cart(int size) {
        products = new Product[size];
        count = 0;
    }

    public void addProduct(Product product) {
        if (count < products.length) {
            products[count++] = product;
            totalItems++;
            System.out.println("Added: " + product);
        } else {
            System.out.println("Cart is full!");
        }
    }

    public void displayCart() {
        System.out.println("\n--- Shopping Cart ---");
        for (int i = 0; i < count; i++) {
            products[i].displayProduct();
            System.out.println("---------------------");
        }
        System.out.println("Total items in all carts: " + totalItems);
    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += products[i].getPrice();
        }
        return total;
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 55000.00, "P001");
        Product p2 = new Product("Mobile", 20000.00, "P002");

        Cart cart = new Cart(5);
        cart.addProduct(p1);
        cart.addProduct(p2);

        cart.displayCart();
        System.out.println("Total Cart Value: ₹" + cart.calculateTotal());
    }
}
