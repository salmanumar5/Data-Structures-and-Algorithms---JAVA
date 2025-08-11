import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements {

    /**
     * Circular one
     * This method finds the next greater element for each element in a circular array.
     * For each index i in nums, we search the circularly next greater number.
     * If none exists, we return -1 for that index.
     *
     * @param nums The circular input array of integers
     * @return An array containing the next greater number for each element
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];  // Output array to store answers
        Stack<Integer> stack = new Stack<>();  // Stack to hold candidates for next greater element

        // Traverse the array twice (simulate circular behavior)
        for (int i = 2 * n - 1; i >= 0; i--) {
            int curr = nums[i % n]; // Circular indexing using modulo

            // Maintain decreasing monotonic stack
            while (!stack.isEmpty() && stack.peek() <= curr) {
                stack.pop();  // Remove elements smaller or equal to current
            }

            // Fill result only in the first pass (i < n)
            if (i < n) {
                result[i] = stack.isEmpty() ? -1 : stack.peek();
            }

            // Push current element for future use
            stack.push(curr);
        }

        return result;
    }

    // Main method for local testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 2, 1};
        int[] nums2 = {1, 2, 3, 4, 3};

        System.out.println("Input: [1, 2, 1]");
        System.out.println("Output: " + Arrays.toString(sol.nextGreaterElements(nums1))); // [2, -1, 2]

        System.out.println("Input: [1, 2, 3, 4, 3]");
        System.out.println("Output: " + Arrays.toString(sol.nextGreaterElements(nums2))); // [2, 3, 4, -1, 4]
    }
}
