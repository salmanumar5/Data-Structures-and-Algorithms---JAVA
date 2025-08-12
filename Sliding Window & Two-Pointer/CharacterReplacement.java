/**
 * LeetCode 424 - Longest Repeating Character Replacement
 *
 * Problem:
 * You are given a string s and an integer k. You may change at most k characters
 * in s to any uppercase English letter. Return the length of the longest substring
 * that contains the same letter after performing at most k changes.
 *
 * Approach:
 * We use a sliding window (two pointers) and a frequency array to keep counts of
 * letters in the current window. Let window = [l, r]. Let maxFreq be the maximum
 * frequency of any single character inside the current window (we keep it as an
 * integer that we update when we expand the window).
 *
 * The key invariant:
 *    (window length) - maxFreq = number of letters we need to change to make the
 *    whole window contain the same letter.
 *
 * So the window is valid iff:
 *    (r - l + 1) - maxFreq <= k
 *
 * We expand the window by moving r. After incrementing the count of s[r], we
 * update maxFreq = max(maxFreq, count[s[r]]). If the window becomes invalid
 * (i.e., needs more than k replacements), we shrink the window from the left:
 * decrement count[s[l]] and l++.
 *
 * A subtle (but important) optimization:
 * - We do NOT decrease maxFreq when we shrink the window. maxFreq is allowed
 *   to be a historical maximum for the counts seen while expanding. This keeps
 *   updates O(1). Even though maxFreq might be slightly higher than the true
 *   maximum frequency inside the current window, this does not break correctness.
 *
 * Why not decreasing maxFreq is safe (intuitive explanation):
 * - maxFreq only increases over time. If a stale (too large) maxFreq artificially
 *   permits a larger window momentarily, that window must have included the
 *   character that produced that historical maxFreq at some earlier position.
 *   The algorithm still only records maxLen when the window satisfies the
 *   inequality (r - l + 1 - maxFreq <= k). Because maxFreq is never decreased,
 *   the condition may be looser, but any window that passes it has a valid
 *   configuration achievable with <= k replacements (this is a standard,
 *   accepted optimization — it allows O(n) time without recomputing maxFreq).
 *
 * Complexity:
 *   Time: O(n) — each index is visited at most twice (r moves right once; l moves right at most n times).
 *   Space: O(1) — constant 26-size frequency array for uppercase letters.
 *
 * The code below follows this approach and includes detailed comments explaining each step.
 */

public class CharacterReplacement {

    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;

        int[] freq = new int[26];      // frequency array for 'A'..'Z'
        int l = 0;                     // left pointer of sliding window
        int maxFreq = 0;               // maximum frequency of a single char in the window (historical non-decreasing)
        int maxLen = 0;                // answer

        // Expand window with r as the right pointer
        for (int r = 0; r < s.length(); r++) {
            int idxR = s.charAt(r) - 'A';
            freq[idxR]++;                     // include s[r] in the window
            maxFreq = Math.max(maxFreq, freq[idxR]); // update historical max freq

            // If we need more than k changes to make all chars in window same, shrink from left
            // (window size) - (most frequent char count) = number of replacements needed
            if ((r - l + 1) - maxFreq > k) {
                // remove s[l] from window and move left
                int idxL = s.charAt(l) - 'A';
                freq[idxL]--;
                l++;
                // NOTE: we do NOT update maxFreq downward here (we keep it as historical max)
            }

            // After ensuring window is valid, update maxLen
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }

    // Simple main for local testing with the examples and a few extra cases
    public static void main(String[] args) {
        CharacterReplacement sol = new CharacterReplacement();

        String s1 = "ABAB";
        int k1 = 2;
        System.out.println("Input: " + s1 + ", k=" + k1 + " -> Output: " + sol.characterReplacement(s1, k1));
        // Expected: 4

        String s2 = "AABABBA";
        int k2 = 1;
        System.out.println("Input: " + s2 + ", k=" + k2 + " -> Output: " + sol.characterReplacement(s2, k2));
        // Expected: 4

        // Additional tests
        String s3 = "AAAA";
        int k3 = 2;
        System.out.println("Input: " + s3 + ", k=" + k3 + " -> Output: " + sol.characterReplacement(s3, k3));
        // Expected: 4

        String s4 = "ABCDE";
        int k4 = 2;
        System.out.println("Input: " + s4 + ", k=" + k4 + " -> Output: " + sol.characterReplacement(s4, k4));
        // With 2 changes, best you can get is 3 (e.g., change B and C to A -> "AAADE" pick substring "AAA")
    }
}
