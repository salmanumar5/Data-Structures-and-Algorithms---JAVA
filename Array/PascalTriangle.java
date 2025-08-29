import java.util.*;

/**
 * Program to generate Pascal's Triangle and get a specific row.
 * 
 * Features:
 * - generate(numRows): Generates Pascal's Triangle up to numRows.
 * - getRow(rowIndex): Returns the specific row of Pascal's Triangle.
 * 
 * Example:
 * For numRows = 5, the output will be:
 * [
 *   [1],
 *   [1, 1],
 *   [1, 2, 1],
 *   [1, 3, 3, 1],
 *   [1, 4, 6, 4, 1]
 * ]
 */
public class PascalTriangle {

    /**
     * Returns the specific row (0-indexed) of Pascal's Triangle.
     * 
     * @param rowIndex The index of the row to return.
     * @return A list representing the row of Pascal's Triangle.
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        long ans = 1;
        res.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            ans = ans * (rowIndex - i + 1) / i;
            res.add((int) ans);
        }
        return res;
    }

    /**
     * Generates Pascal's Triangle up to the given number of rows.
     * 
     * @param numRows The number of rows to generate.
     * @return A list of lists representing Pascal's Triangle.
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            res.add(getRow(i));
        }

        return res;
    }

    /**
     * Main method for local testing.
     */
    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
        int numRows = 5;

        // Generate and print Pascal's Triangle
        System.out.println("Pascal's Triangle for " + numRows + " rows:");
        List<List<Integer>> triangle = pt.generate(numRows);
        for (List<Integer> row : triangle) {
            System.out.println(row);
        }

        // Example of getting a specific row
        int rowIndex = 4;
        System.out.println("\nRow " + rowIndex + " of Pascal's Triangle:");
        System.out.println(pt.getRow(rowIndex));
    }
}
