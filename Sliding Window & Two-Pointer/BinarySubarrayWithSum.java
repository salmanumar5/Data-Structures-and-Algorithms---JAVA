import java.util.*;

public class BinarySubarrayWithSum {

    // Helper function: Counts the number of subarrays with sum at most 'goal'
    public static int atMost(int[] nums, int goal) {
        // If goal is negative, there can't be any subarray with sum <= goal
        if (goal < 0) return 0;

        int l = 0; // Left pointer of the sliding window
        int r = 0; // Right pointer of the sliding window
        int sum = 0; // Current window sum
        int cnt = 0; // Count of valid subarrays

        // Expand the window by moving the right pointer
        while (r < nums.length) {
            sum += nums[r];

            // Shrink the window from the left if sum exceeds the goal
            while (sum > goal) {
                sum -= nums[l];
                l++;
            }

            // Add the number of subarrays ending at r
            cnt += (r - l + 1);
            r++;
        }
        return cnt;
    }

    // Main function to count subarrays with sum exactly equal to 'goal'
    public static int numSubarraysWithSum(int[] nums, int goal) {
        // Count subarrays with sum <= goal and subtract those with sum <= (goal - 1)
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1, 0, 1, 0, 1};
        int goal1 = 2;
        System.out.println("Example 1:");
        System.out.println("Input: " + Arrays.toString(nums1) + ", goal = " + goal1);
        System.out.println("Output: " + numSubarraysWithSum(nums1, goal1)); // Expected: 4

        // Example 2
        int[] nums2 = {0, 0, 0, 0, 0};
        int goal2 = 0;
        System.out.println("\nExample 2:");
        System.out.println("Input: " + Arrays.toString(nums2) + ", goal = " + goal2);
        System.out.println("Output: " + numSubarraysWithSum(nums2, goal2)); // Expected: 15
    }
}
