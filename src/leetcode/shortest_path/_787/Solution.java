package leetcode.shortest_path._787;

import java.util.*;

// 19ms
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>(); // value -> <도착지, 소요시간>
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new HashMap<>());
            graph.get(flight[0]).put(flight[1], flight[2]);
        }

        Queue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(1)));

        pq.add(List.of(src, 0, -1));

        Map<Integer, Integer> visited = new HashMap<>(); // 타임 아웃 방지
        while (!pq.isEmpty()) {
            List<Integer> cur = pq.poll();
            if (cur.get(0) == dst) {
                return cur.get(1);
            }


            Integer u = cur.get(0);
            Integer price = cur.get(1);
            Integer distance = cur.get(2);
            distance += 1;
            visited.put(u, distance);

            if (graph.get(u) == null) {
                continue;
            }

            if (distance > k) {
                continue;
            }

            for (Map.Entry<Integer, Integer> flight : graph.get(u).entrySet()) {
                if (visited.containsKey(flight.getKey()) && distance >= visited.get(flight.getKey())) {
                    continue;
                }

                pq.add(List.of(flight.getKey(), price + flight.getValue(), distance));
            }
        }

        return -1;
    }
}
