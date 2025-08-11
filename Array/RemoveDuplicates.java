public class RemoveDuplicates {

    // Function to remove duplicates from a sorted array
    // and return the number of unique elements
    public static int removeDuplicates(int[] arr) {
        // Edge case: array with 0 or 1 elements is already unique
        if (arr.length == 0) return 0;

        int i = 0; // Pointer for the last unique element

        // Start from second element and scan through the array
        for (int j = 1; j < arr.length; j++) {
            // If a new unique element is found
            if (arr[j] != arr[i]) {
                i++;               // Move the unique pointer
                arr[i] = arr[j];   // Place the unique element at the correct position
            }
        }

        // i is the index of last unique element, so total unique = i + 1
        return i + 1;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};

        int uniqueCount = removeDuplicates(nums);
        System.out.println("Number of unique elements: " + uniqueCount);

        // Optional: print the unique elements
        System.out.print("Unique elements: ");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
