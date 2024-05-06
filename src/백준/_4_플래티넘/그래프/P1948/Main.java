package 백준._4_플래티넘.그래프.P1948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 도시의 개수
        int M = Integer.parseInt(bf.readLine()); // 도로의 개수


        List<List<Node>> A = new ArrayList<>();
        List<List<Node>> reverseA = new ArrayList<>();
        int[] inDegree = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
            reverseA.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            A.get(S).add(new Node(E, weight));
            reverseA.get(E).add(new Node(S, weight));
            inDegree[E]++;
        }
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 위상 정렬
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int[] result = new int[N + 1];

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            for (Node next : A.get(now)) {
                inDegree[next.targetNode]--;
                result[next.targetNode] = Math.max(result[next.targetNode], result[now] + next.weight);
                if (inDegree[next.targetNode] == 0) {
                    queue.offer(next.targetNode);
                }
            }
        }

        // 위상 정렬 reverse
        int resultCount = 0;
        boolean[] visited = new boolean[N + 1];
        queue = new LinkedList<>();
        queue.offer(end);
        visited[end] = true;
        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            for (Node next : reverseA.get(now)) {
                // 1분도 쉬지 않는 도로 체크하기
                if (result[now] == result[next.targetNode] + next.weight) {
                    resultCount++;
                    if (!visited[next.targetNode]) {
                        visited[next.targetNode] = true;
                        queue.offer(next.targetNode);
                    }
                }
            }
        }
        System.out.println(result[end]);
        System.out.println(resultCount);
    }

}

class Node {
    int targetNode;
    int weight;

    public Node(int targetNode, int weight) {
        this.targetNode = targetNode;
        this.weight = weight;
    }
}
