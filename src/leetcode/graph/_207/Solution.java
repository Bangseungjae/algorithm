package leetcode.graph._207;

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>(); // <과목, 의존성>
        for (int[] p : prerequisites) {
            map.putIfAbsent(p[0], new ArrayList<>());
            map.get(p[0]).add(p[1]);
        }

        Set<Integer> taken = new HashSet<>();
        for (Integer key : map.keySet()) {
            if (!dfs(map, key, new HashSet<>(), taken))
                return false;
        }
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> map, Integer finish, Set<Integer> takes, Set<Integer> taken) {
        if (takes.contains(finish)) {
//            takes.forEach(System.out::println);
            return false;
        }
        if (taken.contains(finish)) {
            return true;
        }
        if (!map.containsKey(finish)) {
            return true;
        }

        takes.add(finish);
        for (Integer take : map.get(finish)) {
            if (!dfs(map, take, takes, taken))
                return false;
        }
        takes.remove(finish);
        taken.add(finish);

        return true;
    }
}


class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = new int[][]{{1, 0}};
        boolean rs = solution.canFinish(arr.length, arr);
        System.out.println(rs);
    }
}