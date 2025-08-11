public class LongestSubarraySumK {

    // Function to find the length of the longest subarray with sum K
    public static int longestSubarrayWithSumK(int[] arr, int k) {
        int start = 0;        // Left boundary of the sliding window
        int sum = 0;          // Sum of the current window
        int maxLen = 0;       // Maximum length of valid subarray found

        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];  // Expand the window to the right

            // Shrink the window from the left if sum exceeds k
            while (sum > k) {
                sum -= arr[start];
                start++;
            }

            // Check if current window's sum equals k
            if (sum == k) {
                maxLen = Math.max(maxLen, end - start + 1);
            }
        }

        return maxLen;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 1, 1};
        int k = 5;

        int maxLength = longestSubarrayWithSumK(nums, k);
        System.out.println("Length of longest subarray with sum " + k + " is: " + maxLength);
    }
}
