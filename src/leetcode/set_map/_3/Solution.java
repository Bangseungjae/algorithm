package leetcode.set_map._3;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxLength = 0;

        for (char c : s.toCharArray()) {
            if (map.containsKey(c) && left <= map.get(c)) {
                left = map.get(c) + 1;
            } else {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            map.put(c, right);
            right++;
        }
        return maxLength;
    }
}