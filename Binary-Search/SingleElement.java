/**
 * ✅ Approach (Simple Explanation)

Observation:

The array is sorted.

Every element appears twice, except one single element.

Before the single element, pairs follow the rule:

First occurrence at even index, second at odd index.

After the single element, this pattern breaks.

Binary Search Idea:

Check the mid index:

If mid is even and matches mid+1, the single element is on the right.

If mid is odd and matches mid-1, the single element is on the right.

Otherwise, it is on the left.

Base Cases:

Handle edge cases: single at index 0, n-1, or array of size 1.

Complexity:

Time: O(log n) because of binary search.

Space: O(1).
 */


public class SingleElement {

    // Function to find the single element in sorted array
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        // Edge cases: if array has only 1 element or single is at boundary
        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

        int low = 1, high = n - 2;

        // Binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If mid element is unique
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // Check pattern:
            // - If mid is odd and matches left, or
            // - If mid is even and matches right,
            // then the single element lies on the right side.
            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) ||
                (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // Should never happen in valid input
    }

    // Main method for local testing
    public static void main(String[] args) {
        SingleElement sol = new SingleElement();

        int[] nums1 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int[] nums2 = {3, 3, 7, 7, 10, 11, 11};

        System.out.println("Single element in nums1: " + sol.singleNonDuplicate(nums1)); // Expected: 2
        System.out.println("Single element in nums2: " + sol.singleNonDuplicate(nums2)); // Expected: 10
    }
}
