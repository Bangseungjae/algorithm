package 백준._3_골드.DFS_BFS.P1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] distance;
    static List<Node>[] nodes;

    static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(bf.readLine());
        nodes = new ArrayList[V + 1];
        isVisit = new boolean[V + 1];
        distance = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            nodes[i] = new ArrayList<>();
            distance[i] = 0;
        }
        for (int i = 1; i < V + 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int key = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int index = Integer.parseInt(st.nextToken());
                if (index != -1) {
                    int x = Integer.parseInt(st.nextToken());
                    nodes[key].add(new Node(index, x));
                }
            }

        }
        bfs(1);
        int Max = 1;
        for (int i = 2; i <= V; i++) {
            if (distance[Max] < distance[i]) {
                Max = i;
            }
        }
        isVisit = new boolean[V + 1];
        distance = new int[V + 1];
        bfs(Max);
        Arrays.sort(distance);
        System.out.println(distance[V]);
    }

    static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        isVisit[index] = true;
        queue.add(index);

        while (!queue.isEmpty()) {
            Integer nowNode = queue.poll();
            List<Node> node = nodes[nowNode];

            for (Node p : node) {
                if (!isVisit[p.to]) {
                    isVisit[p.to] = true;
                    queue.add(p.to);
                    distance[p.to] = distance[nowNode] + p.weight;
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.weight, this.weight);
        }
    }
}
