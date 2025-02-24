package leetcode.graph._46;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        List<Integer> elements = Arrays.stream(nums).boxed().collect(Collectors.toList());
        dfs(results, prev, elements);

        return results;
    }

    private void dfs(List<List<Integer>> results, List<Integer> prevElements, List<Integer> elements) {
        if (elements.isEmpty()) {
            results.add(new ArrayList<>(prevElements));
        }

        for (Integer e : elements) {
            List<Integer> nextElements = new ArrayList<>(elements);
            nextElements.remove(e);

            prevElements.add(e);
            dfs(results, prevElements, nextElements);
            prevElements.remove(e);
        }
    }
}
