public class CheckSortedArray {

    // Function to check if the array is sorted in non-decreasing order
    public static boolean isSorted(int[] arr) {
        // Edge case: 0 or 1 element is always sorted
        if (arr.length <= 1) return true;

        // Traverse the array from index 1 to n-1
        for (int i = 1; i < arr.length; i++) {
            // If current element is smaller than the previous, it's unsorted
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }

        // If no such case found, array is sorted
        return true;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 5};   // Change values to test

        boolean result = isSorted(nums);
        System.out.println("Is the array sorted? " + result);
    }
}
