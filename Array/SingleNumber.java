public class SingleNumber {

    // Function to find the element that appears only once
    public static int singleNumber(int[] nums) {
        int result = 0;

        // XOR all the elements
        for (int num : nums) {
            result ^= num; // cancels out duplicates
        }

        return result;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2}; // Example input

        int unique = singleNumber(nums);
        System.out.println("The single number is: " + unique);
    }
}
