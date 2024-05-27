package 백준._2_실버.그래프.BFS.P2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// silver 1
public class Main {
    static int[][] arr;
    static boolean[][] isVisit;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        isVisit = new boolean[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            String line = bf.readLine();
            for (int j = 1; j < M + 1; j++) {
                arr[i][j] = Integer.parseInt(line.substring(j - 1, j));
            }
        }
        bfs(1, 1);
        System.out.println(arr[N][M]);
    }

    static void bfs(int dx, int dy) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(dx, dy));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            isVisit[node.x][node.y] = true;

            if (node.x == N && node.y == M) {
                break;
            }

            if (node.x > 1 && arr[node.x - 1][node.y] > 0) {
                if (!isVisit[node.x - 1][node.y]) {
                    isVisit[node.x - 1][node.y] = true;
                    queue.add(new Node(node.x - 1, node.y));
                    arr[node.x - 1][node.y] = arr[node.x][node.y] + 1;
                }
            }
            if (node.x < N && arr[node.x + 1][node.y] > 0) {
                if (!isVisit[node.x + 1][node.y]) {
                    isVisit[node.x + 1][node.y] = true;
                    queue.add(new Node(node.x + 1, node.y));
                    arr[node.x + 1][node.y] = arr[node.x][node.y] + 1;

                }
            }
            if (node.y > 1 && arr[node.x][node.y - 1] > 0) {
                if (!isVisit[node.x][node.y - 1]) {
                    isVisit[node.x][node.y - 1] = true;
                    queue.add(new Node(node.x, node.y - 1));
                    arr[node.x][node.y - 1] = arr[node.x][node.y] + 1;
                }
            }

            if (node.y < M && arr[node.x][node.y + 1] > 0) {
                if (!isVisit[node.x][node.y + 1]) {
                    isVisit[node.x][node.y + 1] = true;
                    queue.add(new Node(node.x, node.y + 1));
                    arr[node.x][node.y + 1] = arr[node.x][node.y] + 1;
                }
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
