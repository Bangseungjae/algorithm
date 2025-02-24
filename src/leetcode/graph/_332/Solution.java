package leetcode.graph._332;

import java.util.*;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> results = new LinkedList<>();

        // 반복을 돌며 map에 순서대로 저장 O(n)
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (int i = 0; i < tickets.size(); i++) {
            List<String> ticket = tickets.get(i);
            map.putIfAbsent(ticket.getFirst(), new PriorityQueue<>());
            map.get(ticket.getFirst()).add(ticket.get(1));
        }

        // O(n) results에 추가
        String from = "JFK";
        dfs(results, from, map);

        return results;
    }

    public void dfs(List<String> results, String from, Map<String, PriorityQueue<String>> map) {
        while (map.containsKey(from) && !map.get(from).isEmpty()) {
            dfs(results, map.get(from).poll(), map);
        }

        results.addFirst(from);
    }
}