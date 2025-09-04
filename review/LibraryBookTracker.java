public class LibraryBookTracker {
    public static void main(String[] args) {
        // Example array: number of books borrowed each day for 7 days
        int[] borrowings = {10, 0, 25, 18, 30, 12, 20};

        int total = 0;
        int maxBorrowings = borrowings[0];
        int dayOfMax = 0;
        boolean holiday = false;

        // Loop through the week
        for (int i = 0; i < borrowings.length; i++) {
            total += borrowings[i];

            // Find max
            if (borrowings[i] > maxBorrowings) {
                maxBorrowings = borrowings[i];
                dayOfMax = i;
            }

            // Check for holiday
            if (borrowings[i] == 0) {
                holiday = true;
            }
        }

        // Average
        double average = (double) total / borrowings.length;

        // Display results
        System.out.println("Total borrowings in the week: " + total);
        System.out.println("Day with highest borrowings: Day " + (dayOfMax + 1) + " (" + maxBorrowings + " books)");
        if (holiday) {
            System.out.println("There was at least one holiday (zero borrowings).");
        } else {
            System.out.println("No holidays this week.");
        }
        System.out.println("Average daily borrowings: " + average);
    }
}
