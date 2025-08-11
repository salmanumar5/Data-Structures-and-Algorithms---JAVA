// Lower Bound: Index of first element >= k
// → If k exists, it's the first occurrence
// → If k doesn't exist, it's where k can be inserted to maintain order

// Upper Bound: Index of first element > k
// → If k exists multiple times, it's right after the last occurrence
// → If k doesn't exist, it points to the same insertion index as lower bound



public class LowerAndUpperBound {

    // Function to find the lower bound of target 'k'
    public static int lowerBound(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length; // Default: if no element >= k, return length

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If arr[mid] is greater than or equal to k,
            // it could be a potential answer → move to left half
            if (arr[mid] >= k) { // arr[mid] < k --> NOTE: Change this only for Upper Bound 
                ans = mid;
                high = mid - 1;
            } else {
                // Otherwise, search in the right half
                low = mid + 1;
            }
        }

        return ans;
    }

    // Function to find the upper bound of target 'k'
    public static int upperBound(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length; // Default: if no element > k, return length

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If arr[mid] is strictly greater than k,
            // it could be a potential answer → move to left half
            if (arr[mid] > k) { // arr[mid] <= k --> NOTE: This is the only change from lowerBound
                ans = mid;
                high = mid - 1;
            } else {
                // Otherwise, search in the right half
                low = mid + 1;
            }
        }

        return ans;
    }

    // Utility function to print result
    public static void testCase(int[] arr, int k) {
        int lb = lowerBound(arr, k);
        int ub = upperBound(arr, k);

        System.out.println("For target " + k + ":");
        System.out.println("  → Lower bound index (first >= " + k + ") = " + lb);
        System.out.println("  → Upper bound index (first > " + k + ") = " + ub);
        System.out.println();
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 4, 6, 8, 10}; // Sorted input array

        testCase(nums, 4);  // Lower = 2 (first 4), Upper = 4 (first > 4 → 6)
        testCase(nums, 5);  // Lower = 4 (first >= 5 → 6), Upper = 4 (same here)
        testCase(nums, 0);  // Lower = 0 (1), Upper = 0 (1)
        testCase(nums, 11); // Lower = 7 (insert at end), Upper = 7 (insert at end)
    }
}
