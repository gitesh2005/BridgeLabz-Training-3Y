import java.util.*;

public class OTPGenerator {

    // Method to generate 6-digit OTP using Math.random()
    public static int generateOTP() {
        // Math.random() → [0.0,1.0)
        // Multiply by 900000 and add 100000 → ensures always 6 digits
        return 100000 + (int)(Math.random() * 900000);
    }

    // Method to check if all OTPs are unique
    public static boolean checkUnique(int[] otps) {
        Set<Integer> set = new HashSet<>();
        for (int otp : otps) {
            set.add(otp);
        }
        return set.size() == otps.length;
    }

    public static void main(String[] args) {
        int[] otps = new int[10];

        // Generate 10 OTPs
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
            System.out.println("Generated OTP " + (i + 1) + ": " + otps[i]);
        }

        // Validate uniqueness
        if (checkUnique(otps)) {
            System.out.println("✅ All OTPs are unique.");
        } else {
            System.out.println("⚠ Some OTPs are repeated.");
        }
    }
}
