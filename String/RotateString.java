// LeetCode 796: Rotate String
// Problem: Check if a string `s` can be rotated some number of times to become `goal`
// A rotation moves the leftmost character to the rightmost position

public class RotateString {

    // Function to check if goal is a rotation of s
    public boolean rotateString(String s, String goal) {
        // Step 1: If lengths are not the same, no rotation is possible
        if (s.length() != goal.length()) return false;

        // Step 2: Concatenate s with itself. Any valid rotation of s will be a substring of (s + s)
        String doubled = s + s;

        // Step 3: Check if goal is a substring of the doubled string
        if (doubled.contains(goal)) {
            return true;
        } else {
            return false;
        }
    }

    // Main method for local testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1: Expected output -> true (abcde -> cdeab is a valid rotation)
        String s1 = "abcde";
        String goal1 = "cdeab";
        System.out.println("Test 1: " + sol.rotateString(s1, goal1)); // true

        // Test case 2: Expected output -> false (abced is not a rotation of abcde)
        String s2 = "abcde";
        String goal2 = "abced";
        System.out.println("Test 2: " + sol.rotateString(s2, goal2)); // false

        // Test case 3: Expected output -> true (same strings)
        String s3 = "aaaa";
        String goal3 = "aaaa";
        System.out.println("Test 3: " + sol.rotateString(s3, goal3)); // true

        // Test case 4: Expected output -> true (rotation)
        String s4 = "abc";
        String goal4 = "cab";
        System.out.println("Test 4: " + sol.rotateString(s4, goal4)); // true

        // Test case 5: Expected output -> false (different lengths)
        String s5 = "abc";
        String goal5 = "abcd";
        System.out.println("Test 5: " + sol.rotateString(s5, goal5)); // false
    }
}
