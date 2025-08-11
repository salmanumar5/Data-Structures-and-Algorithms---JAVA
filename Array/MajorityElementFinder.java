public class MajorityElementFinder {

    /**
     * Finds the majority element in the array using Boyer-Moore Voting Algorithm.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        // Step 1: Find candidate
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Step 2: Verify candidate (only necessary if the problem doesn't guarantee a majority)
        int freq = 0;
        for (int num : nums) {
            if (num == candidate) {
                freq++;
            }
        }

        // If candidate occurs more than n/2 times, return it
        if (freq > nums.length / 2) {
            return candidate;
        }

        // If no majority found (fallback)
        return -1;
    }

    // 🧪 Test the function with a sample input
    public static void main(String[] args) {
        int[] nums1 = {2, 2, 1, 1, 1, 2, 2};
        int[] nums2 = {3, 3, 4};

        System.out.println("Majority element in nums1: " + majorityElement(nums1));  // Output: 2
        System.out.println("Majority element in nums2: " + majorityElement(nums2));  // Output: 3 (only if appears > n/2)
    }
}
