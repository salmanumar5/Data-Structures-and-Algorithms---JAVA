public class MaxSubArrayKadane {

    /**
     * Problem: Maximum Subarray (Leetcode 53)
     * 
     * Given an integer array `nums`, find the contiguous subarray (containing at least one number)
     * which has the **largest sum**, and return its sum.
     * 
     * Example:
     * Input: [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     * 
     * Approach: Kadane’s Algorithm
     * ------------------------------------------
     * - Traverse the array while maintaining a running sum (`sum`).
     * - At each step, add the current element to `sum`.
     * - If `sum` becomes negative, reset it to 0 (since a negative sum won't help future subarrays).
     * - Track the maximum sum seen so far using `maxi`.
     * 
     * Time Complexity: O(n) – Only one traversal of the array
     * Space Complexity: O(1) – No extra space used
     */

    public int maxSubArray(int[] nums) {
        int sum = 0; // Running sum of the current subarray
        int maxi = Integer.MIN_VALUE; // Store the maximum subarray sum

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];               // Add current element to running sum
            maxi = Math.max(maxi, sum);   // Update maximum if current sum is greater
            if (sum < 0) {
                sum = 0;                  // Reset sum if it becomes negative
            }
        }

        return maxi;
    }

    // Optional: Main method for quick testing
    public static void main(String[] args) {
        MaxSubArrayKadane solver = new MaxSubArrayKadane();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum = " + solver.maxSubArray(nums)); // Output: 6
    }
}
