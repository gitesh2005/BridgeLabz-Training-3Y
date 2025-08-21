public class NumberChecker {
    public static void main(String[] args) {
        int number = 153;

        System.out.println("Number: " + number);
        int[] digits = getDigits(number);

        System.out.println("Duck Number? " + isDuck(number));
        System.out.println("Armstrong Number? " + isArmstrong(number));
        findLargestSmallest(digits);
    }

    public static int countDigits(int num) {
        return String.valueOf(num).length();
    }

    public static int[] getDigits(int num) {
        String s = String.valueOf(num);
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        return digits;
    }

    public static boolean isDuck(int num) {
        String s = String.valueOf(num);
        return s.contains("0") && s.charAt(0) != '0';
    }

    public static boolean isArmstrong(int num) {
        int[] digits = getDigits(num);
        int power = digits.length;
        int sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, power);
        }
        return sum == num;
    }

    public static void findLargestSmallest(int[] digits) {
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;

        for (int d : digits) {
            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) {
                secondLargest = d;
            }

            if (d < smallest) {
                secondSmallest = smallest;
                smallest = d;
            } else if (d < secondSmallest && d != smallest) {
                secondSmallest = d;
            }
        }

        System.out.println("Largest: " + largest + ", Second Largest: " + secondLargest);
        System.out.println("Smallest: " + smallest + ", Second Smallest: " + secondSmallest);
    }
}

