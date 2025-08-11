public class SortColors {

    /**
     * Problem: Sort an array containing only 0s, 1s, and 2s in-place 
     * so that all 0s come first, followed by 1s, then 2s.
     * 
     * This is also known as the Dutch National Flag algorithm.
     * 
     * Approach:
     * - Use three pointers: low, mid, and high.
     * - Traverse the array using mid pointer.
     *     - If the element at mid is 0 → swap with low, move both low and mid forward.
     *     - If the element at mid is 1 → move mid forward.
     *     - If the element at mid is 2 → swap with high, move high backward.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    // Utility function to swap two elements in an array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main function to sort colors using Dutch National Flag algorithm
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap with low pointer and move both pointers forward
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // No action needed, just move mid forward
                mid++;
            } else {
                // nums[mid] == 2 → swap with high pointer and move high backward
                swap(nums, mid, high);
                high--;
            }
        }
    }

    // Optional: Add a main method for testing locally
    public static void main(String[] args) {
        SortColors sorter = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        sorter.sortColors(nums);

        // Print the sorted array
        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Output: 0 0 1 1 2 2
    }
}
