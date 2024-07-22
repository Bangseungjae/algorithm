package 백준._3_골드.트리.LCA.P11437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] parent;
    static int[] depth;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        depth = new int[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];
        tree = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }
        depth[1] = 0;
        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        bfs(1);

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(bf.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            int lca = lca(i1, i2);
            sb.append(lca).append("\n");
        }
        System.out.println(sb);
    }

    private static int lca(int i1, int i2) {
        if (depth[i1] < depth[i2]) {
            int temp = i1;
            i1 = i2;
            i2 = temp;
        }
        while (depth[i1] != depth[i2]) {
            i1 = parent[i1];
        }

        while (i1 != i2) {
            i1 = parent[i1];
            i2 = parent[i2];
        }

        return i1;
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        int level = 1;
        int now_size = 1;
        int count = 0;
        while (!queue.isEmpty()) {
            Integer nowNode = queue.poll();
            for (int next : tree[nowNode]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    parent[next] = nowNode;
                    depth[next] = level;
                }
            }
            count++;
            if (count == now_size) {
                count = 0;
                now_size = queue.size();
                level++;
            }
        }
    }
}
