import java.util.*;

public class TrapRainwater {

    /**
     * This method calculates the total amount of rainwater that can be trapped between the bars.
     * It uses the two-pointer approach to optimize space and time.
     *
     * @param height An array representing the elevation map (bar heights)
     * @return Total units of water that can be trapped
     */
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1; // Two pointers from both ends
        int total = 0; // Total water trapped
        int lMax = 0, rMax = 0; // Left max and right max heights seen so far

        // Move pointers towards each other
        while (left < right) {
            if (height[left] <= height[right]) {
                // If left bar is shorter or equal, calculate water from the left
                if (lMax > height[left]) {
                    total += lMax - height[left]; // Water trapped at current left
                } else {
                    lMax = height[left]; // Update max height from the left
                }
                left++; // Move left pointer
            } else {
                // Else, calculate water from the right
                if (rMax > height[right]) {
                    total += rMax - height[right]; // Water trapped at current right
                } else {
                    rMax = height[right]; // Update max height from the right
                }
                right--; // Move right pointer
            }
        }
        return total;
    }

    // Sample main method to test the code locally
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height2 = {4,2,0,3,2,5};

        System.out.println("Trapped water for height1: " + sol.trap(height1)); // Expected: 6
        System.out.println("Trapped water for height2: " + sol.trap(height2)); // Expected: 9
    }
}
