// LeetCode: 20. Valid Parentheses
// Problem:
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
// determine if the input string is valid.
// An input string is valid if:
// 1. Open brackets are closed by the same type of brackets.
// 2. Open brackets are closed in the correct order.

import java.util.*;

class BalancedParanthesis {

    /**
     * This method checks if the input string has valid parentheses.
     * 
     * @param s The input string containing only '(', ')', '{', '}', '[' and ']'
     * @return true if the string has valid parentheses; false otherwise
     */
    public boolean isValid(String s) {
        // Stack to hold opening brackets
        Stack<Character> st = new Stack<>();

        // Traverse each character in the input string
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            // If current char is an opening bracket, push to stack
            if (current == '(' || current == '{' || current == '[') {
                st.push(current);
            } else {
                // If stack is empty, there's no matching opening bracket
                if (st.isEmpty()) return false;

                // Peek the top element from stack
                char top = st.peek();
                st.pop();

                // Check if the popped opening bracket matches the current closing bracket
                if ((current == ')' && top != '(') ||
                    (current == '}' && top != '{') ||
                    (current == ']' && top != '[')) {
                    return false; // Mismatch
                }
            }
        }

        // If stack is empty, all brackets matched; otherwise some brackets are unmatched
        return st.isEmpty();
    }

    // Main method for local testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        String s1 = "()[]{}";
        String s2 = "(]";
        String s3 = "({[]})";
        String s4 = "(((";
        String s5 = "";

        System.out.println("Is \"" + s1 + "\" valid? " + sol.isValid(s1)); // true
        System.out.println("Is \"" + s2 + "\" valid? " + sol.isValid(s2)); // false
        System.out.println("Is \"" + s3 + "\" valid? " + sol.isValid(s3)); // true
        System.out.println("Is \"" + s4 + "\" valid? " + sol.isValid(s4)); // false
        System.out.println("Is \"" + s5 + "\" valid? " + sol.isValid(s5)); // true (empty is valid)
    }
}
