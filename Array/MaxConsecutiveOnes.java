public class MaxConsecutiveOnes {

    // Function to find the maximum number of consecutive 1s in the array
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxi = 0; // Stores the maximum streak of 1s
        int cnt = 0;  // Counts current consecutive 1s

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cnt++; // Continue streak
                maxi = Math.max(maxi, cnt); // Update maximum if needed
            } else {
                cnt = 0; // Reset streak on 0
            }
        }

        return maxi;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1}; // Test case

        int maxStreak = findMaxConsecutiveOnes(nums);
        System.out.println("Maximum consecutive 1s: " + maxStreak);
    }
}
