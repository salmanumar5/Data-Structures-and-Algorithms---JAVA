import java.util.*;


/**
 * Approach Explanation (Simple)

What is a subarray sum?
A subarray is a continuous sequence. Its sum is just the sum of numbers inside it.
Example: [1, 2, 3], subarray [1, 2] has sum 3.

Key Idea:
Use prefix sums and a hashmap.

preSum keeps track of the running sum from the start to the current index.

If at some index we have preSum, and we know that (preSum - k) appeared before,
it means the subarray between those two points has sum = k.

Example:

nums = [1, 2, 3], k = 3
prefix sums: [1, 3, 6]

At prefix sum = 3, check (3 - 3 = 0) → found in map → subarray [1,2]
At prefix sum = 6, check (6 - 3 = 3) → found in map → subarray [3]


Why store prefix sums in map?

The map keeps track of how many times a prefix sum has appeared.

This way, we can count multiple subarrays efficiently in O(n).
 */

public class SubarraySum {

    // Function to count subarrays whose sum = k
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;       // To store the count of valid subarrays
        int preSum = 0;    // Running prefix sum
        Map<Integer, Integer> mpp = new HashMap<>();
        
        // Base case: prefix sum 0 is seen once
        mpp.put(0, 1);

        // Traverse through the array
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];  // Update prefix sum

            // If (preSum - k) exists in map, it means
            // there is a subarray ending at index i with sum = k
            int remove = preSum - k;
            cnt += mpp.getOrDefault(remove, 0);

            // Update frequency of current prefix sum
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }

        return cnt;
    }

    // Main function to test the code
    public static void main(String[] args) {
        SubarraySum sol = new SubarraySum();

        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Output 1: " + sol.subarraySum(nums1, k1)); // Expected: 2

        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("Output 2: " + sol.subarraySum(nums2, k2)); // Expected: 2
    }
}
