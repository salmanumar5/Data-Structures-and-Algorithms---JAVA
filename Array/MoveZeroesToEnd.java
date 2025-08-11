public class MoveZeroesToEnd {

    // Function to move all zeroes to the end of the array
    // while maintaining the order of non-zero elements
    public static void moveZeroes(int[] nums) {
        int j = -1;

        // Step 1: Find the index of the first 0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        // If there's no zero, no need to proceed
        if (j == -1) return;

        // Step 2: Traverse the rest of the array
        for (int i = j + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap the non-zero element with the element at index j
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++; // Move j to the next zero position
            }
        }
    }

    // Utility method to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};

        System.out.println("Original array:");
        printArray(nums);

        moveZeroes(nums);

        System.out.println("Array after moving zeroes to the end:");
        printArray(nums);
    }
}
