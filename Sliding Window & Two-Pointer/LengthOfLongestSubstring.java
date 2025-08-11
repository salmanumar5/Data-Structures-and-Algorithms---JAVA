import java.util.*;

public class LengthOfLongestSubstring {

    /**
     * Finds the length of the longest substring without repeating characters.
     * Uses a sliding window approach with an array to store the last seen index
     * of each character for O(1) access and update.
     *
     * @param s the input string
     * @return the length of the longest substring without repeating characters
     */
    public int lengthOfLongestSubstring(String s) {
        // Array to store the last seen index of each ASCII character
        // Initialized to -1, meaning the character hasn't been seen yet
        int[] mpp = new int[256];
        Arrays.fill(mpp, -1);

        int l = 0; // Left pointer of the sliding window
        int r = 0; // Right pointer of the sliding window
        int n = s.length(); // Length of the input string
        int maxLen = 0; // Stores the maximum length found

        // Expand the window by moving 'r'
        while (r < n) {
            char currentChar = s.charAt(r);

            // If currentChar was seen and is inside the current window
            if (mpp[currentChar] != -1 && mpp[currentChar] >= l) {
                // Move the left pointer to one position after the last occurrence
                l = mpp[currentChar] + 1;
            }

            // Calculate current window length and update maxLen if needed
            int len = r - l + 1;
            maxLen = Math.max(len, maxLen);

            // Update the last seen index of the current character
            mpp[currentChar] = r;

            // Move the right pointer to expand the window
            r++;
        }
        return maxLen;
    }

    // Main method for local testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        String test1 = "abcabcbb"; // Expected output: 3 ("abc")
        String test2 = "bbbbb";    // Expected output: 1 ("b")
        String test3 = "pwwkew";   // Expected output: 3 ("wke")
        String test4 = "";         // Expected output: 0 (empty string)
        String test5 = "au";       // Expected output: 2 ("au")

        System.out.println(sol.lengthOfLongestSubstring(test1));
        System.out.println(sol.lengthOfLongestSubstring(test2));
        System.out.println(sol.lengthOfLongestSubstring(test3));
        System.out.println(sol.lengthOfLongestSubstring(test4));
        System.out.println(sol.lengthOfLongestSubstring(test5));
    }
}
