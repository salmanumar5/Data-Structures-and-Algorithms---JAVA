import java.util.*;

public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0; // Edge case: if array is empty, no sequence exists

        // Step 1: Put all numbers into a HashSet for O(1) lookup
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        int longest = 1; // At least one number means sequence length = 1

        // Step 2: Iterate over each number in the set
        for (int it : set) {
            // Only start a new sequence if `it-1` is not present
            // This ensures we only start counting from the beginning of a sequence
            if (!set.contains(it - 1)) {
                int cnt = 1; // Current sequence length
                int x = it;  // Start number of the sequence

                // Step 3: Keep moving forward while the next number exists
                while (set.contains(x + 1)) {
                    x++;    // Move to the next consecutive number
                    cnt++;  // Increase sequence length
                }

                // Step 4: Update longest sequence found so far
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }

    // Main method for local testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Sequence: " + sol.longestConsecutive(nums1));
        // Expected: 4 (sequence: [1, 2, 3, 4])

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Longest Consecutive Sequence: " + sol.longestConsecutive(nums2));
        // Expected: 9 (sequence: [0,1,2,3,4,5,6,7,8])

        int[] nums3 = {};
        System.out.println("Longest Consecutive Sequence: " + sol.longestConsecutive(nums3));
        // Expected: 0 (empty array)

        int[] nums4 = {1, 2, 0, 1};
        System.out.println("Longest Consecutive Sequence: " + sol.longestConsecutive(nums4));
        // Expected: 3 (sequence: [0,1,2])
    }
}
