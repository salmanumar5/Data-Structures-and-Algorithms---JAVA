import java.util.*;

public class SortCharFreq {
    public String frequencySort(String s) {
       Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        List<Character> chars = new ArrayList<>(freq.keySet());
        chars.sort((a, b) -> freq.get(b) - freq.get(a)); 

        StringBuilder res = new StringBuilder(s.length());
        for (char c : chars) {
            int count = freq.get(c);
            for (int i = 0; i < count; i++) {
                res.append(c);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        SortCharFreq sol = new SortCharFreq();
        String s = "tree";
        System.out.println("Input: " + s);
        System.out.println("Output: " + sol.frequencySort(s)); // eert or eetr
    }
}
