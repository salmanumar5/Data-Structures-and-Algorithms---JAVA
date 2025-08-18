public class NextPermutation {

    /**
     * Intuition:
     * The problem is to find the next lexicographical permutation of the given array.
     * If we think of permutations as "numbers," the next permutation is just the next bigger number.
     * 
     * Example:
     * nums = [1,2,3] → next is [1,3,2]
     * nums = [3,2,1] → next is [1,2,3] (since it's the highest, we wrap around to lowest)
     * 
     * Approach:
     * 1. Traverse from right to left and find the first index `ind` where nums[ind] < nums[ind+1].
     *    - This marks the "breakpoint" where the order can still increase.
     * 2. If no such index exists (array is strictly decreasing), reverse the whole array and return.
     *    - Example: [3,2,1] → [1,2,3]
     * 3. Otherwise, again traverse from the right, and find the first element greater than nums[ind].
     *    Swap them.
     *    - Example: [1,2,3,6,5,4], ind=2 (nums[2]=3). Next bigger from right side is 4. Swap → [1,2,4,6,5,3]
     * 4. Finally, reverse the suffix (ind+1 ... n-1) to make it the smallest possible sequence.
     *    - Continuing above example → [1,2,4,3,5,6]
     * 
     * Time Complexity: O(n)  (linear scan + reverse)
     * Space Complexity: O(1) (in-place operations)
     */

    // Reverse helper
    public static void reverseArray(int[] arr, int str, int lst) {
        int start = str;
        int end = lst;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Swap helper
    public static void swapElements(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    // Main function: computes next permutation
    public void nextPermutation(int[] nums) {
        int ind = -1;
        int n = nums.length;

        // Step 1: Find breakpoint
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }

        // Step 2: If no breakpoint → reverse whole array
        if (ind == -1) {
            reverseArray(nums, 0, n - 1);
            return;
        }

        // Step 3: Find element just larger than nums[ind] from right side
        for (int i = n - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                swapElements(nums, i, ind);
                break;
            }
        }

        // Step 4: Reverse suffix
        reverseArray(nums, ind + 1, n - 1);
    }

    // Main function to test locally
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {1, 2, 3};
        sol.nextPermutation(nums);
        System.out.print("Next permutation: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] nums2 = {3, 2, 1};
        sol.nextPermutation(nums2);
        System.out.print("Next permutation: ");
        for (int num : nums2) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] nums3 = {1, 1, 5};
        sol.nextPermutation(nums3);
        System.out.print("Next permutation: ");
        for (int num : nums3) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
