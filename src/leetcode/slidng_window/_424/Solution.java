package leetcode.slidng_window._424;

import java.util.*;

class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        Map<Character, Integer> counts = new HashMap<>();
        for (int right = 1; right <= s.length(); right++) {
            counts.put(s.charAt(right - 1), counts.getOrDefault(s.charAt(right - 1), 0) + 1);
            int maxCount = Collections.max(counts.values());

            if (right - left - maxCount > k) {
                counts.put(s.charAt(left), counts.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
        }
        return s.length() - left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.characterReplacement("AABCBAA", 2));
    }
}

