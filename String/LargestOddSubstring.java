// Problem: Given a numeric string, return the largest-valued odd number that is a non-empty substring of the input.
// A substring is contiguous. Return an empty string if no odd number exists.

// Example:
// Input: "35427" -> Output: "35427" (Already odd)
// Input: "4206"  -> Output: ""      (No odd digits)
// Input: "52"    -> Output: "5"     (Only "5" is odd)

public class LargestOddSubstring {

    // Function to find the largest odd-numbered substring
    public static String largestOddNumber(String num) {
        // Traverse from the last digit towards the start
        for (int i = num.length() - 1; i >= 0; i--) {
            char ch = num.charAt(i);
            // Check if the digit is odd
            if ((ch - '0') % 2 != 0) {
                // Return the substring from 0 to i (inclusive)
                return num.substring(0, i + 1);
            }
        }
        // If no odd digit is found, return empty string
        return "";
    }

    // Main method for local testing
    public static void main(String[] args) {
        String input1 = "52";
        String input2 = "4206";
        String input3 = "35427";
        String input4 = "13579";
        String input5 = "8642";

        System.out.println("Input: " + input1 + " -> Output: " + largestOddNumber(input1)); // 5
        System.out.println("Input: " + input2 + " -> Output: " + largestOddNumber(input2)); // ""
        System.out.println("Input: " + input3 + " -> Output: " + largestOddNumber(input3)); // 35427
        System.out.println("Input: " + input4 + " -> Output: " + largestOddNumber(input4)); // 13579
        System.out.println("Input: " + input5 + " -> Output: " + largestOddNumber(input5)); // ""
    }
}
