
// Intuition:
// To generate the specific row in Pascal's Triangle without constructing the entire triangle,
// we use the formula for binomial coefficients.
// Each element in row `rowIndex` can be computed as:
// C(rowIndex, i) = C(rowIndex, i-1) * (rowIndex - i + 1) / i
// We start with the first element as 1, then use this formula iteratively.

import java.util.*;

public class PascalTrianglell {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        long ans = 1; // Use long to avoid overflow
        result.add(1); // First element is always 1

        // Compute each element using the previous one
        for (int i = 1; i <= rowIndex; i++) {
            ans = ans * (rowIndex - i + 1) / i; // Update using binomial coefficient
            result.add((int) ans); // Cast back to int and add to list
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int rowIndex = 4; // Example
        System.out.println(sol.getRow(rowIndex)); // Output: [1, 4, 6, 4, 1]
    }
}
