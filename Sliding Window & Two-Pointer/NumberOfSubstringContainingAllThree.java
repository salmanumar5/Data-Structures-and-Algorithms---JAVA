import java.util.*;

public class NumberOfSubstringContainingAllThree {

    /**
     * Method to count substrings containing at least one 'a', 'b', and 'c'.
     * Approach:
     * - Track the last seen index of each character (a, b, c).
     * - For every index i, if all three have been seen,
     *   add (min of lastSeen indices + 1) to the count.
     */
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] lastSeen = {-1, -1, -1}; // lastSeen[0]=a, lastSeen[1]=b, lastSeen[2]=c
        int count = 0;

        for (int i = 0; i < n; i++) {
            // Update the last seen index of current character
            lastSeen[s.charAt(i) - 'a'] = i;

            // If all three characters have appeared at least once
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                // Find the smallest lastSeen index
                int minIndex = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
                // Add all possible starting positions for substrings ending at i
                count += (minIndex + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfSubstringContainingAllThree sol = new NumberOfSubstringContainingAllThree();

        String s1 = "abcabc";
        String s2 = "aaacb";
        String s3 = "abc";

        System.out.println("Input: " + s1 + " -> Output: " + sol.numberOfSubstrings(s1)); // Expected 10
        System.out.println("Input: " + s2 + " -> Output: " + sol.numberOfSubstrings(s2)); // Expected 3
        System.out.println("Input: " + s3 + " -> Output: " + sol.numberOfSubstrings(s3)); // Expected 1
    }
}
