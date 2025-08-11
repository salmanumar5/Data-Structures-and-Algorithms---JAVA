public class FloorAndCeil {

    // Function to find the floor of 'k'
    public static int findFloor(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1; // Default: no valid floor

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= k) {
                ans = arr[mid];     // Potential floor found
                low = mid + 1;      // Try to find a bigger one
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    // Function to find the ceil of 'k'
    public static int findCeil(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1; // Default: no valid ceil

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= k) {
                ans = arr[mid];     // Potential ceil found
                high = mid - 1;     // Try to find a smaller one
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    // Main method to test both functions
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6, 8, 10}; // Sorted array

        int k1 = 5;
        System.out.println("Floor of " + k1 + " is: " + findFloor(nums, k1)); // Output: 4
        System.out.println("Ceil of " + k1 + " is: " + findCeil(nums, k1));   // Output: 6

        int k2 = 0;
        System.out.println("Floor of " + k2 + " is: " + findFloor(nums, k2)); // Output: -1
        System.out.println("Ceil of " + k2 + " is: " + findCeil(nums, k2));   // Output: 1

        int k3 = 10;
        System.out.println("Floor of " + k3 + " is: " + findFloor(nums, k3)); // Output: 10
        System.out.println("Ceil of " + k3 + " is: " + findCeil(nums, k3));   // Output: 10
    }
}
