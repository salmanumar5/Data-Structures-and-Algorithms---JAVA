// LeetCode 1021: Remove Outermost Parentheses
// Given a valid parentheses string, this code removes the outermost parentheses 
// from each primitive valid parentheses substring.

public class RemoveOutermostParentheses {

    public static String removeOuterParentheses(String s) {
        // Use StringBuilder for efficient string manipulation
        StringBuilder result = new StringBuilder();
        
        // Track the current balance of open and close parentheses
        int balance = 0;

        // Traverse each character in the input string
        for(char c : s.toCharArray()){
            // If current character is ')', decrease balance first
            if(c == ')'){
                balance--;
                // Append to result only if it's not the outermost ')'
                if(balance != 0){
                    result.append(c);
                }
            } else {
                // For '(', append only if it's not the outermost '('
                if(balance != 0){
                    result.append(c);
                }
                balance++; // Increase balance for '('
            }
        }

        // Return the final result as string
        return result.toString();
    }

    // Driver code to test the function locally
    public static void main(String[] args) {
        String s1 = "(()())(())";
        String s2 = "(()())(())(()(()))";
        String s3 = "()()";

        System.out.println("Original: " + s1);
        System.out.println("Processed: " + removeOuterParentheses(s1));

        System.out.println("Original: " + s2);
        System.out.println("Processed: " + removeOuterParentheses(s2));

        System.out.println("Original: " + s3);
        System.out.println("Processed: " + removeOuterParentheses(s3));
    }
}
