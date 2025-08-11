import java.util.*;

/**
 * This class solves the problem of computing the sum of ranges of all subarrays.
 * A range of a subarray is defined as (maximum - minimum).
 * 
 * We use monotonic stacks to efficiently calculate:
 * - sum of all subarray maximums
 * - sum of all subarray minimums
 * 
 * Then we return: sumMax - sumMin.
 */
class SumOfSubArrayRanges {

    // Find Next Greater Element indices for each element
    public int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        // Iterate from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop until we find a greater element
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            // If no greater element to the right, use n
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nge;
    }

    // Find Previous Greater Element indices
    public int[] findPGE(int[] arr) {
        int n = arr.length;
        int[] pge = new int[n];
        Stack<Integer> st = new Stack<>();

        // Iterate from left to right
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pge;
    }

    // Compute sum of all subarray maximums using NGE and PGE
    public long sumSubarrayMax(int[] arr) {
        int[] nge = findNGE(arr);
        int[] pge = findPGE(arr);
        long total = 0;

        for (int i = 0; i < arr.length; i++) {
            long left = i - pge[i];     // number of subarrays to the left
            long right = nge[i] - i;    // number of subarrays to the right
            total += left * right * arr[i];
        }
        return total;
    }

    // Find Next Smaller Element indices
    public int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    // Find Previous Smaller Element indices
    public int[] findPSE(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }

    // Compute sum of all subarray minimums using NSE and PSE
    public long sumSubarrayMins(int[] arr) {
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);
        long total = 0;

        for (int i = 0; i < arr.length; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            total += left * right * arr[i];
        }
        return total;
    }

    // Final function to compute sum of all subarray ranges (max - min)
    public long subArrayRanges(int[] nums) {
        long sumMax = sumSubarrayMax(nums);
        long sumMin = sumSubarrayMins(nums);
        return sumMax - sumMin;
    }

    // Sample main method to run and test
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, -2, -1, 5};
        int[] nums3 = {-1, -2, -3, -4};

        System.out.println("Subarray Ranges Sum (nums1): " + sol.subArrayRanges(nums1)); // Expected: 4
        System.out.println("Subarray Ranges Sum (nums2): " + sol.subArrayRanges(nums2));
        System.out.println("Subarray Ranges Sum (nums3): " + sol.subArrayRanges(nums3));
    }
}
