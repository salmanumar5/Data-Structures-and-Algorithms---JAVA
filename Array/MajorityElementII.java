/**
 * Problem: Majority Element II
 * LeetCode #229
 *
 * Approach:
 * - Use Boyer-Moore Majority Vote algorithm (Extended for n/3 condition).
 * - There can be at most two majority elements (> n/3 times).
 * 
 * Steps:
 * 1. Initialize two candidate elements and their counts.
 * 2. Traverse the array and apply the voting logic:
 *      - If current element is one of the candidates, increment its count.
 *      - Else if any candidate count is zero, assign current element as that candidate.
 *      - Else decrement both counts.
 * 3. After first pass, verify actual counts for both candidates (because they may not be valid).
 * 4. Return candidates that occur more than n/3 times.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) extra space
 */

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0, cnt2 = 0;
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;
        int n = nums.length;

        // First pass: Find potential candidates
        for (int i = 0; i < n; i++) {
            if (nums[i] == el1) {
                cnt1++;
            } else if (nums[i] == el2) {
                cnt2++;
            } else if (cnt1 == 0) {
                el1 = nums[i];
                cnt1 = 1;
            } else if (cnt2 == 0) {
                el2 = nums[i];
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // Second pass: Verify candidates
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == el1) cnt1++;
            if (nums[i] == el2) cnt2++;
        }

        List<Integer> res = new ArrayList<>();
        int mini = (int)(n / 3) + 1;
        if (cnt1 >= mini) res.add(el1);
        if (cnt2 >= mini) res.add(el2);

        return res;
    }

    // Main method for local testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {3, 2, 3};
        int[] nums2 = {1, 1, 1, 3, 3, 2, 2, 2};
        int[] nums3 = {1};

        System.out.println("Test 1: " + sol.majorityElement(nums1)); // Output: [3]
        System.out.println("Test 2: " + sol.majorityElement(nums2)); // Output: [1, 2]
        System.out.println("Test 3: " + sol.majorityElement(nums3)); // Output: [1]
    }
}
