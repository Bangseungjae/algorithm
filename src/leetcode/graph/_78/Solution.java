package leetcode.graph._78;

import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        dfs(results, nums, new HashSet<>(), 0);
        return results;
    }

    private void dfs(List<List<Integer>> results, int[] nums, Set<Integer> elements, int index) {
        results.add(new ArrayList<>(elements));

        for (int i = index; i < nums.length; i++) {
            elements.add(nums[i]);
            dfs(results, nums, elements, i + 1);
            elements.remove(nums[i]);
        }
    }
}