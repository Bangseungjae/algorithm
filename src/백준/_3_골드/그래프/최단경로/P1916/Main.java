package 백준._3_골드.그래프.최단경로.P1916;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 도시의 개수
        int M = Integer.parseInt(bf.readLine()); // 버스의 개수

        List<List<Node>> nodes = new ArrayList<>();
        int[] values = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            nodes.add(new ArrayList<>());
            values[i] = Integer.MAX_VALUE;
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            nodes.get(from).add(new Node(to, value));
        }

        st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N + 1];
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        values[start] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (visited[current.end]) continue;
            visited[current.end] = true;

            for (Node node : nodes.get(current.end)) {
                int next = node.end;
                if (values[current.end] + node.value < values[next]) {
                    values[next] = values[current.end] + node.value;
                    queue.offer(new Node(next, values[next]));
                }
            }
        }
        System.out.println(values[end]);
    }
}

class Node implements Comparable<Node>{
    int end;
    int value;

    public Node(int end, int value) {
        this.end = end;
        this.value = value;
    }

    public int compareTo(Node o) {
        return this.value > o.value ? 1 : -1;
    }
}
