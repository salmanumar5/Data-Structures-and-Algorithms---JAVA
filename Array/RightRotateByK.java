public class RightRotateByK {

    // Function to rotate array right by k positions
    public static void rightRotate(int[] arr, int k) {
        int n = arr.length;

        // Normalize k in case it's larger than array length
        k = k % n;

        // Step 1: Reverse the last k elements
        reverse(arr, n - k, n - 1);

        // Step 2: Reverse the first n - k elements
        reverse(arr, 0, n - k - 1);

        // Step 3: Reverse the whole array
        reverse(arr, 0, n - 1);
    }

    // Helper method to reverse part of array
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    // Utility to print array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.println("Original array:");
        printArray(nums);

        rightRotate(nums, k);

        System.out.println("Array after right rotation by " + k + ":");
        printArray(nums);
    }
}
