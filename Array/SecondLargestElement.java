public class SecondLargestElement {

    // Function to find the second largest element in an array
    public static int findSecondLargest(int[] arr) {
        // Edge case: if array has less than 2 elements, no second largest
        if (arr.length < 2) {
            System.out.println("Array should have at least two elements.");
            return -1;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Traverse the array to find the largest and second largest
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                // If new largest found, update secondLargest first
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] != largest && arr[i] > secondLargest) {
                // Update secondLargest only if it's less than current element
                secondLargest = arr[i];
            }
        }

        // Handle case when there's no second largest (e.g. all elements same)
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No distinct second largest element found.");
            return -1;
        }

        return secondLargest;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {10, 25, 3, 25, 5, 99, 99};

        int secondLargest = findSecondLargest(nums);
        System.out.println("The second largest element is: " + secondLargest);
    }
}
