package 백준._3_골드.트리.LCA.P11438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] tree;
    static int kmax;
    static boolean[] visited;
    static int[][] parent;
    static int[] depth;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        depth = new int[N + 1];
        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }
        kmax = 0;
        int temp = 2;
        while (temp < N) {
            temp <<= 1;
            kmax++;
        }
        parent = new int[kmax + 1][N + 1];

        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }

        bfs(1);

        for (int k = 1; k <= kmax; k++) {
            for (int n = 1; n <= N; n++) {
                parent[k][n] = parent[k - 1][parent[k - 1][n]];
            }
        }
        int M = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int rs = executeLCA(a, b);
            sb.append(rs).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        int nowSize = 1;
        int count = 0;
        int level = 1;
        while (!queue.isEmpty()) {
            Integer nowNode = queue.poll();
            for (int next : tree[nowNode]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    depth[next] = level;
                    parent[0][next] = nowNode;
                }
            }
            count++;
            if (count == nowSize) {
                count = 0;
                nowSize = queue.size();
                level++;
            }
        }
    }

    private static int executeLCA(int a, int b) {
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        for (int k = kmax; k >= 0; k--) {
            if (Math.pow(2, k) <= depth[b] - depth[a]) {
                if (depth[a] <= depth[parent[k][b]]) {
                    b = parent[k][b];
                }
            }
        }
        for (int k = kmax; k >= 0; k--) {
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }
        if (a != b) {
            return parent[0][a];
        }
        return a;
    }
}
