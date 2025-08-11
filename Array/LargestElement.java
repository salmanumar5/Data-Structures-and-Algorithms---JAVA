public class LargestElement {

    // Function to find the largest element in an array
    public static int findLargest(int[] arr) {
        // Initialize with the smallest possible value
        int largest = Integer.MIN_VALUE;

        // Loop through all elements of the array
        for (int i = 0; i < arr.length; i++) {
            // If current element is greater than the current largest, update it
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        // Return the largest value found
        return largest;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {10, 25, 3, 45, 5, 99, 2};

        // Call the function and print the result
        int largestElement = findLargest(nums);
        System.out.println("The largest element in the array is: " + largestElement);
    }
}
