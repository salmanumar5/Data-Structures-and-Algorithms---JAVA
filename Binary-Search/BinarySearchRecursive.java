public class BinarySearchRecursive {

    // Function to perform binary search using recursion
    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1; // Base case: not found
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid; // Target found
        } else if (arr[mid] < target) {
            return binarySearch(arr, mid + 1, right, target); // Search right half
        } else {
            return binarySearch(arr, left, mid - 1, target); // Search left half
        }
    }

    // Main method to test the recursive binary search
    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8, 10, 12, 14};
        int target = 10;

        int result = binarySearch(nums, 0, nums.length - 1, target);
        System.out.println("Index of target " + target + " is: " + result);
    }
}
