package leetcode.graph._39;

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(results, candidates, target, 0, new LinkedList<>());
        return results;
    }

    private void dfs(List<List<Integer>> results, int[] candidates, int target, int index, Deque<Integer> deque) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            results.add(new ArrayList<>(deque));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            deque.addLast(candidates[i]);
            dfs(results, candidates, target - candidates[i], i, deque);
            deque.removeLast();
        }
    }
}