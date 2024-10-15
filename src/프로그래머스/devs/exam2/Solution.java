package 프로그래머스.devs.exam2;

import java.util.*;

class Solution {
    public boolean solution(int capacity, int[][] routes) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] route : routes) {
            Integer plus = map.getOrDefault(route[1], 0) + route[0];
            map.put(route[1], plus);
            Integer minus = map.getOrDefault(route[2], 0) - route[0];
            map.put(route[2], minus);
        }

        int current = 0;
        for (int value : map.values()) {
            current += value;
            if (current > capacity) {
                return false;
            }
        }
        return true;
    }
}
