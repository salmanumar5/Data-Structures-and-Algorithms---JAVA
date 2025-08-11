import java.util.*;

public class IsomorphicStrings {

    /**
     * This method checks if two strings s and t are isomorphic.
     * It uses two arrays of size 128 (ASCII range) to keep track of mappings from s -> t and t -> s.
     * Each character from one string must consistently map to the other, and vice versa.
     */
    public static boolean isIsomorphic(String s, String t) {
        // Arrays to store mapping of characters
        int[] match1 = new int[128];  // s -> t
        int[] match2 = new int[128];  // t -> s

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // If charS is already mapped, it should match the current charT
            // Similarly for charT to charS mapping
            if ((match1[charS] != 0 && match1[charS] != charT) ||
                (match2[charT] != 0 && match2[charT] != charS)) {
                return false;
            }

            // Store the mapping in both directions
            match1[charS] = charT;
            match2[charT] = charS;
        }

        return true;
    }

    // Main method for testing locally
    public static void main(String[] args) {
        String s1 = "egg";
        String t1 = "add";
        System.out.println("Is '" + s1 + "' and '" + t1 + "' isomorphic? " + isIsomorphic(s1, t1));

        String s2 = "foo";
        String t2 = "bar";
        System.out.println("Is '" + s2 + "' and '" + t2 + "' isomorphic? " + isIsomorphic(s2, t2));

        String s3 = "paper";
        String t3 = "title";
        System.out.println("Is '" + s3 + "' and '" + t3 + "' isomorphic? " + isIsomorphic(s3, t3));

        String s4 = "ab";
        String t4 = "aa";
        System.out.println("Is '" + s4 + "' and '" + t4 + "' isomorphic? " + isIsomorphic(s4, t4));
    }
}
