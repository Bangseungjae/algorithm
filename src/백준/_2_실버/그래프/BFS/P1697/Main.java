package 백준._2_실버.그래프.BFS.P1697;

/*
문제
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        System.out.println(bfs(N, K));
    }

    private static int bfs(int N, int K) {
        boolean[] visited = new boolean[100_0001];
        visited[N] = true;
        Node node = new Node(N, 0);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.v == K) {
                return current.count;
            }

            int[] nextPositions = {current.v * 2, current.v + 1, current.v - 1};

            for (int next : nextPositions) {
                if (next > -1 && next < 100_001 && !visited[next]) {
                    visited[next] = true;
                    queue.offer(new Node(next, current.count + 1));
                }
            }
        }

        return -1;
    }

    static class Node {
        int v;
        int count;

        public Node(int v, int count) {
            this.v = v;
            this.count = count;
        }
    }
}
