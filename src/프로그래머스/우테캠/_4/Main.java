package 프로그래머스.우테캠._4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] network = {
                {1, 2},
                {3, 5},
                {4, 2},
                {5, 6}
        };
        int[][] repair = {
                {3, 2, 10},
                {5, 4, 15}
        };
        int solution1 = solution.solution(6, network, repair);
        System.out.println(solution1);
    }
}


class Solution {
    public int solution(int n, int[][] network, int[][] repair) {
        // 인접 리스트로 그래프 생성
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : network) {
            graph.get(edge[0]).add(new int[] {edge[1], edge[2]});
            graph.get(edge[1]).add(new int[] {edge[0], edge[2]});
        }

        // 초기화: 모든 PC가 연결되어 있는지 확인
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int[] neighbor : graph.get(curr)) {
                if (!visited[neighbor[0]]) {
                    visited[neighbor[0]] = true;
                    queue.offer(neighbor[0]);
                }
            }
        }
        for (boolean v : visited) {
            if (!v) {
                return -1; // 모든 PC가 연결되어 있지 않으면 -1 반환
            }
        }

        // Kruskal 알고리즘을 이용하여 최소 비용 신장 트리 구하기
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int[] edge : network) {
            pq.offer(new int[] {edge[0], edge[1], edge[2]});
        }
        int minCost = 0;
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int u = edge[0], v = edge[1], cost = edge[2];
            if (!visited[u] || !visited[v]) {
                // 끊어진 연결일 경우
                if (Arrays.binarySearch(repair, edge, (a, b) -> {
                    if (a[2] != b[2]) {
                        return a[2] - b[2];
                    } else if (a[0] != b[0]) {
                        return a[0] - b[0];
                    } else {
                        return a[1] - b[1];
                    }
                }) >= 0) {
                    // repair 배열에 포함되어 있을 경우 복구 비용 추가
                    minCost += cost;
                } else {
                    // 아닐 경우 -1 반환
                    return -1;
                }
            } else {
                // 유효한 연결일 경우 비용 추가
                minCost += cost;
            }
        }
        return minCost;
    }
}
