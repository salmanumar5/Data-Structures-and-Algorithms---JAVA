import java.util.*;

/**
 * We will take a array and sort it and then we will place i, j and k
 * i =0 , j= i + 1, k = n-1
 * Now we will check for the sum of these 3
 * if the sum is less we will increase the j and if we it is more we will decrease the k
 * now once j and k meets or crosses and will move one step ahead and j and k are re assigned to there postion and this continues
 */

public class ThreeSum {

    // ✅ Function to find all unique triplets that sum to zero
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        // ✅ Step 1: Sort the array to use two-pointer approach
        Arrays.sort(nums);

        // ✅ Step 2: Iterate through each element
        for (int i = 0; i < nums.length; i++) {
            // Skip duplicate elements for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;                 // Second pointer (start)
            int k = nums.length - 1;       // Third pointer (end)

            // ✅ Step 3: Use two-pointer technique to find pairs
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    // If sum is too small, increase j to get a bigger sum
                    j++;
                } else if (sum > 0) {
                    // If sum is too big, decrease k to get a smaller sum
                    k--;
                } else {
                    // ✅ Found a triplet
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // Move both pointers inward
                    j++;
                    k--;

                    // Skip duplicates for the second and third numbers
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // ✅ Input array
        int[] nums = {-1, 0, 1, 2, -1, -4};

        // ✅ Call threeSum function
        List<List<Integer>> result = threeSum(nums);

        // ✅ Print the result
        System.out.println("Unique triplets that sum to zero:");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}
