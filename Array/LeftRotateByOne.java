public class LeftRotateByOne {

    // Function to rotate the array left by one position
    public static int[] leftRotate(int[] arr) {
        int n = arr.length;

        // Edge case: array with 0 or 1 elements doesn't need rotation
        if (n <= 1) return arr;

        int temp = arr[0]; // Store the first element

        // Shift elements to the left
        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }

        // Put the first element at the end
        arr[n - 1] = temp;

        return arr;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {1, 5, 7, 3, 8, 4};

        System.out.println("Original array:");
        printArray(nums);

        // Perform left rotation
        leftRotate(nums);

        System.out.println("Array after left rotation by one:");
        printArray(nums);
    }

    // Utility method to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
