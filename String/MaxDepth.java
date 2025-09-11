public class MaxDepth {
    public int maxDepth(String s) {
        int cnt = 0;        // Tracks the current depth
        int maxDepth = 0;   // Stores the maximum depth encountered

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++; // Going deeper into a nested parenthesis
                maxDepth = Math.max(maxDepth, cnt); // Update max depth if needed
            } else if (c == ')') {
                cnt--; // Closing a parenthesis reduces depth
            }
        }
        return maxDepth; // The highest depth recorded
    }

    // Main method for testing
    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        
        String s1 = "(1+(2*3)+((8)/4))+1";
        System.out.println("Max Depth for \"" + s1 + "\": " + solution.maxDepth(s1));
        // Expected Output: 3

        String s2 = "(1)+((2))+(((3)))";
        System.out.println("Max Depth for \"" + s2 + "\": " + solution.maxDepth(s2));
        // Expected Output: 3

        String s3 = "()(())((()()))";
        System.out.println("Max Depth for \"" + s3 + "\": " + solution.maxDepth(s3));
        // Expected Output: 3
    }
}
