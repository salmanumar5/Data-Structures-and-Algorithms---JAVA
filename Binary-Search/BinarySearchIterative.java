public class BinarySearchIterative {

    // Function to perform binary search using iteration
    public static int binarySearch(int[] arr, int target) {
        int left = 0;                  // Starting index
        int right = arr.length - 1;    // Ending index

        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevents integer overflow

            if (arr[mid] == target) {
                return mid; // Target found at mid index
            } else if (arr[mid] < target) {
                left = mid + 1; // Search in right half
            } else {
                right = mid - 1; // Search in left half
            }
        }

        return -1; // Target not found
    }

    // Main method to test the iterative binary search
    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8, 10, 12, 14};
        int target = 10;

        int result = binarySearch(nums, target);
        System.out.println("Index of target " + target + " is: " + result);
    }
}
