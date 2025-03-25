package leetcode.shortest_path._743;

import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }

        // 우선순위 큐 생성 <도착지, 소요 시간>
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        pq.add(new AbstractMap.SimpleEntry<>(k, 0));
        // <도착지, 소요 시간> 결과 선언
        Map<Integer, Integer> dist = new HashMap<>();
        while (!pq.isEmpty()) {
            // 소요 시간이 가장 빠른 값 추출
            Map.Entry<Integer, Integer> cur = pq.poll();
            Integer u = cur.getKey(); // 목적지
            Integer distU = cur.getValue(); // 목적지 까지의 가중치

            if (!dist.containsKey(u)) {
                dist.put(u, distU);
                if (!graph.containsKey(u)) {
                    continue;
                }
                for (Map.Entry<Integer, Integer> v : graph.get(u).entrySet()) {
                    int alt = distU + v.getValue();
                    pq.add(new AbstractMap.SimpleEntry<>(v.getKey(), alt));
                }
            }
        }

        if (dist.size() == n) {
            return Collections.max(dist.values());
        }

        return -1;
    }
}