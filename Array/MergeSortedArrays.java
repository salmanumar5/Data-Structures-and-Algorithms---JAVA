import java.util.*;

public class MergeSortedArrays {

    /**
     * Approach:
     * - Use three pointers:
     *   i -> last valid element in nums1 (m-1)
     *   j -> last element in nums2 (n-1)
     *   k -> last index in nums1 (m+n-1)
     * - Start from the back and place the larger element at position k.
     * - Decrement pointers accordingly.
     * - If nums2 still has remaining elements, copy them to nums1.
     * 
     * Time Complexity: O(m+n)
     * Space Complexity: O(1) (in-place)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // pointer for nums1
        int j = n - 1; // pointer for nums2
        int k = m + n - 1; // pointer for merged array (nums1)

        // Merge from the back
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If nums2 still has elements, copy them
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        MergeSortedArrays msa = new MergeSortedArrays();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        msa.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1)); // [1, 2, 2, 3, 5, 6]
    }
}
