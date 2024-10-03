package 백준._3_골드.DFS_BFS.P16928;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] ladder = new int[101];
    static int[] snake = new int[101];
    static int[] D = new int[101];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            ladder[scanner.nextInt()] = scanner.nextInt();
        }
        for (int i = 0; i < M; i++) {
            snake[scanner.nextInt()] = scanner.nextInt();
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Node node = new Node(1, 0);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.index == 100) {
                return current.count;
            }
            for (int i = 1; i < 7; i++) {
                // 뱀이 아님
                // 간적이 없어야함
                // 사다리인지 체크할 것.
                int next = current.index + i;
                if (next > 100 || (D[next] != 0 && D[next] < current.count + 1)) {
                    continue;
                }

                if (snake[next] != 0) {
                    D[next] = current.count + 1;
                    next = snake[next];
                    D[next] = current.count + 1;
                    queue.offer(new Node(next, current.count + 1));
                } else if (ladder[next] != 0) {
                    D[next] = current.count + 1;
                    next = ladder[next];
                    D[next] = current.count + 1;
                    queue.offer(new Node(next, current.count + 1));
                } else {
                    D[next] = current.count + 1;
                    queue.offer(new Node(next, current.count + 1));
                }
            }
        }
        return -1;
    }

    static class Node {
        int index;
        int count;

        public Node(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}
