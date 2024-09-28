package 백준._3_골드.DFS_BFS.P1939;

import java.io.*;
import java.util.*;

public class Main {
    private static List<Edge>[] edges;
    private static int N;
    private static int M;
    private static int start;
    private static int end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int maxWeight = 0;
        edges = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            maxWeight = Math.max(maxWeight, c);
            edges[a].add(new Edge(b, c));
            edges[b].add(new Edge(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int left = 1;
        int right = maxWeight;
        int result = 0;

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        while (left <= right) {
            int mid = (left + right) / 2;
            if (bfs(mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }

    private static boolean bfs(int limit) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) return true;

            for (Edge edge : edges[current]) {
                if (!visited[edge.to] && edge.weight >= limit) {
                    visited[edge.to] = true;
                    queue.offer(edge.to);
                }
            }
        }
        return false;
    }
}

class Edge {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}
