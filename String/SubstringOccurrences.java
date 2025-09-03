public class SubstringOccurrences {
    public static void main(String[] args) {
        String str = "abababa";
        String sub = "aba";
        int count = 0, index = 0;

        while ((index = str.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }

        System.out.println("Occurrences: " + count);
    }
}
