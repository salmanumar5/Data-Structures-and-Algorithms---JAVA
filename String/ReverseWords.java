// LeetCode: Reverse Words in a String
// Optimal approach using two pointers from the end
// This solution handles leading, trailing, and multiple intermediate spaces
// Time Complexity: O(n) where n is the length of the string
// Space Complexity: O(n) for storing the result

public class ReverseWords {

    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;

        // Traverse the string from end to start
        while (i >= 0) {
            // Skip trailing spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            // Break if reached start of string
            if (i < 0) break;

            // Mark end of the word
            int j = i;

            // Move to the beginning of the word
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // Append the word to result
            // i+1 is the starting index, j+1 is the exclusive end index
            result.append(s.substring(i + 1, j + 1)).append(" ");
        }

        // Remove trailing space from result if any
        return result.toString().trim();
    }

    public static void main(String[] args) {
        String input1 = "the sky is blue";
        String input2 = "  hello world  ";
        String input3 = "a good   example";

        System.out.println("Input: \"" + input1 + "\"");
        System.out.println("Output: \"" + reverseWords(input1) + "\"");

        System.out.println("Input: \"" + input2 + "\"");
        System.out.println("Output: \"" + reverseWords(input2) + "\"");

        System.out.println("Input: \"" + input3 + "\"");
        System.out.println("Output: \"" + reverseWords(input3) + "\"");
    }
}
