package hundae.독립점;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리: BufferedReader와 StringTokenizer를 이용합니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수

        // 1부터 N까지의 인접 리스트 생성
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력: 양방향 그래프로 저장합니다.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited = new boolean[N + 1];
        long result = 0; // 최대 선택 가능한 정점 개수를 저장할 변수

        // 모든 정점을 순회하며 연결 성분별로 탐색
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                int countVertices = 0;
                int countEdges = 0; // 해당 성분에서의 간선 수 (각 간선을 두 번 세게 됨)
                Queue<Integer> queue = new ArrayDeque<>();
                visited[i] = true;
                queue.offer(i);

                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    countVertices++;
                    // 현재 정점의 모든 간선을 더합니다. (나중에 2로 나눠 실제 간선 수로 만듭니다.)
                    countEdges += graph[cur].size();
                    for (int neighbor : graph[cur]) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            queue.offer(neighbor);
                        }
                    }
                }
                countEdges /= 2; // 각 간선을 두 번 세었으므로 실제 간선 수로 변환

                // 연결 성분의 유형에 따라 최대 독립 집합 크기를 구합니다.
                System.out.println("count Edges = " + countEdges + ",  countVertices = " + countVertices);
                if (countEdges == countVertices) {
                    // 사이클: 모든 정점의 degree가 2인 사이클인 경우
                    // 사이클의 경우 최대 독립 집합은 정점 수가 짝수면 n/2, 홀수면 floor(n/2)가 됩니다.
                    System.out.println("countVertices / 2 = " + (countVertices / 2));
                    result += countVertices / 2;
                } else {
                    // 경로(또는 고립 정점): 트리 구조로 간선 수가 (정점 수 - 1)
                    // 경로의 최대 독립 집합은 ceil(n/2)입니다.
                    System.out.println("(countVertices + 1) / 2 = " + (countVertices + 1) / 2);
                    result += (countVertices + 1) / 2;
                }
                System.out.println("result = " + result);
            }
        }

        System.out.println(result);
    }
}

/*
6 4
1 2
2 3
3 4
4 5
-> 4


7 6
1 2
2 3
1 3
4 5
5 6
6 7
-> 3
 */