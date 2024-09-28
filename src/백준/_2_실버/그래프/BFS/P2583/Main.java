package 백준._2_실버.그래프.BFS.P2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int K;
    static boolean[][] arr;
    static int count = 0;
    static int[] _x = {1, -1, 0, 0};
    static int[] _y = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new boolean[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    arr[y][x] = true;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!arr[i][j]) {
                    int rs = bfs(j, i);
                    list.add(rs);
                }
            }
        }
        System.out.println(count);
        list.sort(Comparator.comparingInt(x -> x));
        list.forEach(x -> System.out.printf("%d ", x));
    }

    private static int bfs(int x, int y) {
        count++;
        int size = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (arr[current.y][current.x]) {
                continue;
            }
            size++;
            arr[current.y][current.x] = true;
            for (int i = 0; i < 4; i++) {
                int x1 = current.x + _x[i];
                int y1 = current.y + _y[i];
                if (
                        N > x1 &&
                                M > y1 &&
                                x1 > -1 &&
                                y1 > -1 &&
                                !arr[y1][x1]
                ) {
                    queue.offer(new Node(x1, y1));
                }
            }
        }

        return size;
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
