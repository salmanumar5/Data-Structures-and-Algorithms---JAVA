public class FirstAndLastPosition {

    // Find the lower bound: first index where nums[i] >= target
    public static int lowerBound(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int ans = nums.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    // Find the upper bound: first index where nums[i] > target
    public static int upperBound(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int ans = nums.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    // Main function to return the start and end index of the target
    public static int[] searchRange(int[] nums, int target) {
        int lb = lowerBound(nums, target);

        // If target is not present in the array
        if (lb == nums.length || nums[lb] != target) 
            return new int[]{-1, -1};

        int ub = upperBound(nums, target);
        return new int[]{lb, ub - 1};
    }

    // Driver code for testing
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] result = searchRange(nums, target);

        System.out.print("First and Last Position of " + target + ": ");
        for (int i : result) {
            System.out.print(i + " ");
        }
        // Output: 3 4
    }
}
