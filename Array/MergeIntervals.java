import java.util.*;

/**
 * ✅ Approach to Solve "Merge Intervals"

Sort the intervals by starting point

This ensures we can process intervals in order and easily detect overlaps.

Iterate through each interval

Maintain a list (merged) to store merged intervals.

Check for overlap

If the list is empty OR the current interval starts after the last merged interval ends, add the interval as is.

Otherwise, there is an overlap, so merge them by updating the end time of the last interval in the list to max(end times).

Convert the list to an array

Finally, convert the List<int[]> to an int[][] and return it.

Time Complexity:

Sorting: O(n log n)

Merging: O(n)

Total: O(n log n)

Space Complexity:

O(n) for storing merged intervals.
 */


public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        // Step 1: Sort intervals by starting point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        // Step 2: Iterate and merge intervals
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                // No overlap, add interval
                merged.add(interval);
            } else {
                // Overlap, merge with the last interval
                merged.get(merged.size() - 1)[1] = Math.max(
                    merged.get(merged.size() - 1)[1],
                    interval[1]
                );
            }
        }

        // Step 3: Convert List<int[]> to int[][]
        return merged.toArray(new int[merged.size()][]);
    }

    // Main method to test
    public static void main(String[] args) {
        int[][] intervals = { {1, 3}, {2, 6}, {8, 10}, {15, 18} };

        int[][] result = merge(intervals);

        // Print merged intervals
        System.out.println("Merged Intervals:");
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
