package 백준._3_골드.그래프.최단경로.P1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(bf.readLine());

        int[] distance = new int[V + 1];
        List<List<Node>> nodes = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            nodes.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            nodes.get(u).add(new Node(v, w));
        }
        distance[K] = 0;
        boolean[] visited = new boolean[V + 1];
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(K, 0));
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (visited[current.vertex]) continue;
            visited[current.vertex] = true;

            for (Node node : nodes.get(current.vertex)) {
                int next = node.vertex;
                if (distance[current.vertex] + node.weight < distance[next]) {
                    distance[next] = distance[current.vertex] + node.weight;
                    queue.add(new Node(node.vertex, distance[next]));
                }
            }
        }

        for (int i = 1; i < V + 1; i++) {
            if (visited[i]) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }
    }
}

class Node implements Comparable<Node>{
    int vertex;
    int weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight > o.weight ? 1 : -1;
    }
}
