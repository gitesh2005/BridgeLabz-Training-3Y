public class OnlineShoppingCart {
    public static void main(String[] args) {
        // Example array: product prices added to the cart
        int[] prices = {1500, 2500, 1200, 900};

        int total = 0;

        // Simple loop (not enhanced)
        for (int i = 0; i < prices.length; i++) {
            total += prices[i];
        }

        // Apply discount if applicable
        double discountedTotal = total;
        if (total > 5000) {
            discountedTotal = total * 0.90; // 10% discount
        }

        // Add delivery charge if applicable
        if (discountedTotal < 2000) {
            discountedTotal += 100;
        }

        // Display results
        System.out.println("Total cart value: " + total);
        System.out.println("Payable amount after discount/delivery charges: " + discountedTotal);
    }
}
