import java.util.*;

public class SumOfSubarrayMinimums {

    // Function to find Next Smaller Element (NSE) index for every element in the array
    // For arr[i], nse[i] will hold the index of the next smaller element on the right
    public int[] findNSE(int[] arr){
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        // Traverse from right to left
        for(int i = n - 1; i >= 0; i--){
            // Pop elements from stack until a smaller element is found
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            // If stack is empty, there is no smaller element to the right
            nse[i] = st.isEmpty() ? n : st.peek();
            // Push current index onto stack
            st.push(i);
        }

        return nse;
    }

    // Function to find Previous Smaller Element (PSE) index for every element in the array
    // For arr[i], pse[i] will hold the index of the previous smaller element on the left
    public int[] findPSE(int[] arr){
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        // Traverse from left to right
        for(int i = 0; i < n; i++){
            // Pop elements from stack until a smaller element is found
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            // If stack is empty, there is no smaller element to the left
            pse[i] = st.isEmpty() ? -1 : st.peek();
            // Push current index onto stack
            st.push(i);
        }

        return pse;
    }

    // Main function to calculate the sum of minimums of all subarrays
    public int sumSubarrayMins(int[] arr) {
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);
        long total = 0;
        int mod = (int)(1e9 + 7);

        // Each element arr[i] contributes:
        // (i - PSE[i]) * (NSE[i] - i) * arr[i] to the total sum
        for(int i = 0; i < arr.length; i++){
            long left = i - pse[i];
            long right = nse[i] - i;
            long contribution = (left * right % mod * arr[i]) % mod;
            total = (total + contribution) % mod;
        }

        return (int)total;
    }

    // Main method to test the logic
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Sample input array
        int[] arr = {3, 1, 2, 4};

        // Expected output: 17
        // Explanation:
        // Subarrays: [3], [3,1], [3,1,2], [3,1,2,4], [1], [1,2], [1,2,4], [2], [2,4], [4]
        // Their minimums: 3 + 1 + 1 + 1 + 1 + 1 + 1 + 2 + 2 + 4 = 17

        int result = sol.sumSubarrayMins(arr);
        System.out.println("Sum of Subarray Minimums: " + result);
    }
}
