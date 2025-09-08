import java.util.*;

/**
 * ✅ Explanation of the Approach:
Goal: Remove k digits from num so that the resulting number is the smallest possible.
Use a stack:
Iterate over digits.
For each digit:
While the stack top is greater than the current digit and k > 0, pop from stack (this ensures the number stays as small as possible).
Push the current digit onto the stack.
Remove remaining digits:
If k > 0 after iteration, remove from the end (pop from stack).
Build result:
Pop from stack and reverse (because popping gives digits in reverse order).
Handle leading zeros:
Skip all leading zeros.
Edge case:
If all digits are removed, return "0".
✅ Time Complexity:
O(n) where n = number of digits (each digit is pushed and popped at most once).
Extra work: reverse() and substring() → O(n).
✅ Space Complexity:
O(n) for the stack and StringBuilder.
 */


public class RemoveKDigits {
    
    // Method to remove k digits to make the smallest possible number
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        // Step 1: Process each digit
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);

            // Remove larger digits from stack if we can still remove (k > 0)
            while (!st.isEmpty() && k > 0 && st.peek() > c) {
                st.pop();
                k--;
            }
            st.push(c);
        }

        // Step 2: If k > 0, remove remaining digits from the end
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        // If stack is empty, return "0"
        if (st.isEmpty()) return "0";

        // Step 3: Build result from stack (in reverse order)
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        // Reverse to get correct order
        res.reverse();

        // Step 4: Remove leading zeros
        int idx = 0;
        while (idx < res.length() && res.charAt(idx) == '0') {
            idx++;
        }

        // Take substring after removing leading zeros
        res = new StringBuilder(res.substring(idx));

        // If empty after removing zeros, return "0"
        if (res.length() == 0) return "0";

        return res.toString();
    }

    // Main method to test the solution
    public static void main(String[] args) {
        RemoveKDigits solution = new RemoveKDigits();

        // Test cases
        String num1 = "1432219";
        int k1 = 3;
        System.out.println("Input: " + num1 + ", k = " + k1);
        System.out.println("Output: " + solution.removeKdigits(num1, k1)); // Expected: "1219"

        String num2 = "10200";
        int k2 = 1;
        System.out.println("\nInput: " + num2 + ", k = " + k2);
        System.out.println("Output: " + solution.removeKdigits(num2, k2)); // Expected: "200"

        String num3 = "10";
        int k3 = 2;
        System.out.println("\nInput: " + num3 + ", k = " + k3);
        System.out.println("Output: " + solution.removeKdigits(num3, k3)); // Expected: "0"
    }
}
