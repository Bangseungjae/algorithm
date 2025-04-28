package leetcode.sort._56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int[] i : intervals) {
            if (!merged.isEmpty() && merged.getLast()[1] >= i[0]) {
                merged.getLast()[1] = Math.max(merged.getLast()[1], i[1]);
            } else {
                merged.add(i);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}