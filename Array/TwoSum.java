import java.util.HashMap;

public class TwoSum {

    /**
     * Problem: Given an array of integers nums and an integer target,
     * return indices of the two numbers such that they add up to target.
     * 
     * Assumption: Each input will have exactly one solution,
     * and you may not use the same element twice.
     * 
     * Approach: HashMap to store seen numbers and their indices.
     * - Traverse the array and for each element, calculate its complement (target - current element).
     * - If complement is already in map, return its index and current index.
     * - Else, put current element in map with its index.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        // Map to store the element and its index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Loop through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Value we need to find

            // Check if the complement already exists in the map
            if (map.containsKey(complement)) {
                // If found, return the index of complement and current index
                return new int[] { map.get(complement), i };
            }

            // Otherwise, store the current value and its index
            map.put(nums[i], i);
        }

        // Return empty if no solution found (as per problem, this won't happen)
        return new int[] {};
    }

    // Driver code for testing
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);

        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        // Output: Indices: [0, 1]
    }
}
