public class RearrangeArrayBySign {

    // Rearranges the array such that positives are at even indexes,
    // negatives at odd indexes, while maintaining relative order.
    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        // Result array to hold rearranged values
        int[] ans = new int[n];

        // posInd → for positive values (even indices)
        // negInd → for negative values (odd indices)
        int posInd = 0;
        int negInd = 1;

        // Traverse through original array and place values accordingly
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans[posInd] = nums[i];
                posInd += 2;
            } else {
                ans[negInd] = nums[i];
                negInd += 2;
            }
        }

        return ans;
    }

    // Main method to test the rearrangement
    public static void main(String[] args) {
        int[] nums = {3, 1, -2, -5, 2, -4};
        int[] result = rearrangeArray(nums);

        System.out.print("Rearranged Array: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        // Output: [3, -2, 1, -5, 2, -4]
    }
}
