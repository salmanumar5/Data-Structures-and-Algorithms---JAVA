// LeetCode 242: Valid Anagram
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
// An anagram is a word or phrase formed by rearranging the letters of a different word or phrase.

import java.util.Scanner;

public class IsAnagram {

    // Function to check if two strings are anagrams
    public boolean isAnagram(String s, String t) {
        // If lengths are different, they can't be anagrams
        if (s.length() != t.length()) return false;

        // Create frequency array for 26 lowercase letters
        int[] freq = new int[26];

        // Count frequency of each character in s
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;  // increment the count of character c
        }

        // Subtract frequency based on characters in t
        for (char c : t.toCharArray()) {
            freq[c - 'a']--;  // decrement the count of character c
        }

        // If all counts return to 0, it's an anagram
        for (int cnt : freq) {
            if (cnt != 0) return false;  // if any count is not zero, not an anagram
        }

        return true; // All frequencies matched
    }

    // Main method to run and test the function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter first string: ");
        String s = sc.nextLine();

        System.out.print("Enter second string: ");
        String t = sc.nextLine();

        boolean result = sol.isAnagram(s, t);
        System.out.println("Are the two strings anagrams? " + result);
    }
}
