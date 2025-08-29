import java.util.*;
/**
 * Approach Explanation (Simple Words)

We are solving the 4 Sum Problem:

Find all unique quadruplets (a, b, c, d) in an array that add up to target.

Steps in this approach:

Sort the array → Helps avoid duplicates and apply two-pointer technique efficiently.

Pick the first two numbers using two loops (i and j).

For the remaining two numbers, use two pointers (k and l) to find pairs that sum up correctly:

If sum < target → move k forward to increase sum.

If sum > target → move l backward to decrease sum.

If sum == target → add to the result and skip duplicates.

Skip duplicates after every step (for i, j, k, l).

Return the list of quadruplets.

✅ Time Complexity: O(n³) (because of two loops + two-pointer)
✅ Space Complexity: O(1) extra (excluding result list).
 */


public class FourSum {
    
    // Method to find all unique quadruplets that sum to target
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        // Sort the array to apply two-pointer technique
        Arrays.sort(nums);
        
        // First loop for the first element
        for (int i = 0; i < nums.length; i++) {
            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            // Second loop for the second element
            for (int j = i + 1; j < nums.length; j++) {
                // Skip duplicate elements for j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                // Two pointers for the remaining two numbers
                int k = j + 1;
                int l = nums.length - 1;
                
                while (k < l) {
                    // Use long to avoid integer overflow
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    
                    if (sum < target) {
                        k++; // Need bigger sum, move left pointer
                    } else if (sum > target) {
                        l--; // Need smaller sum, move right pointer
                    } else {
                        // Found a quadruplet
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        
                        // Skip duplicates for k
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        // Skip duplicates for l
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }
                }
            }
        }
        
        return ans;
    }
    
    // Main method to test the function
    public static void main(String[] args) {
        FourSum solution = new FourSum();
        
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        
        List<List<Integer>> result = solution.fourSum(nums, target);
        
        // Print result
        System.out.println("Quadruplets that sum to target:");
        for (List<Integer> quad : result) {
            System.out.println(quad);
        }
    }
}
