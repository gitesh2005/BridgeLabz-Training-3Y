import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String str = "programming";
        StringBuilder result = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (!seen.contains(c)) {
                result.append(c);
                seen.add(c);
            }
        }

        System.out.println("Without duplicates: " + result.toString());
    }
}
