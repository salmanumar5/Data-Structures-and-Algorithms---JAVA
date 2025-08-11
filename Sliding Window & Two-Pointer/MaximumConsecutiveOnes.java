import java.util.*;

public class MaximumConsecutiveOnes {

    /**
     * Given a binary array nums and an integer k,
     * returns the length of the longest subarray that contains only 1's
     * after flipping at most k zeros to 1's.
     *
     * Approach:
     * - Use the sliding window technique (two pointers: l and r).
     * - Expand the window by moving r to the right.
     * - Count how many zeros are in the current window.
     * - If the zero count exceeds k, shrink the window from the left (l++) 
     *   until zeros are back within the allowed limit.
     * - At each step, calculate the window size and track the maximum length.
     *
     * Time Complexity: O(n) — each element is visited at most twice.
     * Space Complexity: O(1) — only constant extra variables are used.
     */
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0;      // Left pointer of the sliding window
        int r = 0;      // Right pointer of the sliding window
        int zeros = 0;  // Number of zeros in the current window
        int maxLen = 0; // Maximum window size found

        while (r < n) {
            // If the current right element is zero, increase zero count
            if (nums[r] == 0) zeros++;

            // If zero count exceeds k, shrink the window from the left
            if (zeros > k) {
                if (nums[l] == 0) zeros--; // Adjust zero count when removing a zero
                l++; // Move left pointer to shrink the window
            }

            // Update the maximum length with the current window size
            maxLen = Math.max(r - l + 1, maxLen);

            // Expand window by moving right pointer
            r++;
        }
        return maxLen;
    }

    // Main method for local testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k1 = 2;
        System.out.println(sol.longestOnes(nums1, k1)); 
        // Expected output: 6
        // Explanation: Flip the 4th and 5th elements (0s) to 1s.

        int[] nums2 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k2 = 3;
        System.out.println(sol.longestOnes(nums2, k2)); 
        // Expected output: 10
        // Explanation: Flip three zeros in the range to get the longest sequence of 1s.

        int[] nums3 = {1, 1, 1, 1};
        int k3 = 0;
        System.out.println(sol.longestOnes(nums3, k3)); 
        // Expected output: 4
        // Explanation: Already all 1s, no flips needed.
    }
}
