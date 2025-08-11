// LeetCode Problem: Longest Common Prefix
// Approach: Lexicographic Sorting
// Intuition:
// After sorting the array of strings lexicographically, the common prefix among all strings
// will definitely be the common prefix of the first and last string.
// This is because, lexicographically, the first and last string are most different.
// Any mismatch between the first and last string implies a mismatch with the rest as well.

import java.util.*;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        // To build the result efficiently
        StringBuilder ans = new StringBuilder();

        // Sort the array of strings
        Arrays.sort(strs);

        // Compare characters of the first and last strings only
        String first = strs[0];
        String last = strs[strs.length - 1];

        // Iterate up to the shortest string length
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            // If characters don't match, break and return what we have
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            // Else, keep appending to answer
            ans.append(first.charAt(i));
        }

        return ans.toString(); // Final result
    }

    // Main method to run and test locally
    public static void main(String[] args) {
        LongestCommonPrefix sol = new LongestCommonPrefix();

        String[] input1 = {"flower", "flow", "flight"};
        System.out.println("Input: " + Arrays.toString(input1));
        System.out.println("Longest Common Prefix: " + sol.longestCommonPrefix(input1));

        String[] input2 = {"dog", "racecar", "car"};
        System.out.println("\nInput: " + Arrays.toString(input2));
        System.out.println("Longest Common Prefix: " + sol.longestCommonPrefix(input2));

        String[] input3 = {"interspecies", "interstellar", "interstate"};
        System.out.println("\nInput: " + Arrays.toString(input3));
        System.out.println("Longest Common Prefix: " + sol.longestCommonPrefix(input3));
    }
}
