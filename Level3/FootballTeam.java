import java.util.Random;

public class FootballTeam {
    public static void main(String[] args) {
        int[] heights = new int[11];
        Random rand = new Random();

        // Generate random heights between 150 and 250
        for (int i = 0; i < heights.length; i++) {
            heights[i] = rand.nextInt(101) + 150; // (250 - 150) + 1 = 101
        }

        // Display heights
        System.out.println("Heights of players:");
        for (int h : heights) {
            System.out.print(h + " ");
        }
        System.out.println();

        // Results
        System.out.println("Shortest Height: " + findShortest(heights));
        System.out.println("Tallest Height: " + findTallest(heights));
        System.out.println("Mean Height: " + findMean(heights));
    }

    public static int findShortest(int[] arr) {
        int min = arr[0];
        for (int h : arr) {
            if (h < min) min = h;
        }
        return min;
    }

    public static int findTallest(int[] arr) {
        int max = arr[0];
        for (int h : arr) {
            if (h > max) max = h;
        }
        return max;
    }

    public static double findMean(int[] arr) {
        int sum = 0;
        for (int h : arr) {
            sum += h;
        }
        return (double) sum / arr.length;
    }
}
