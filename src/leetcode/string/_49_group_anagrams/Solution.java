package leetcode.string._49_group_anagrams;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/group-anagrams/description">...</a>
 *
 * 6 ms
 * Beats 98.02%
 * 47.87 MB
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> results = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            String sorted = String.valueOf(chars);
            if (!results.containsKey(sorted)) {
                results.put(sorted, new ArrayList<>());
            }
            results.get(sorted).add(s);
        }
        return new ArrayList<>(results.values());
    }
}