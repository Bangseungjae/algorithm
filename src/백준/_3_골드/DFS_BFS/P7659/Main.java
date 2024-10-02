package 백준._3_골드.DFS_BFS.P7659;

import java.io.IOException;
import java.util.*;

public class Main {
    static int[][][] box;
    static boolean[][][] visited;
    static int[][][] days;
    static int H;
    static int N;
    static int M;
    static final int RIPE = 1;
    static final int NOT_RIPE = 0;
    static final int[] D_M = {0, 0, 0, 0, -1, 1};
    static final int[] D_N = {1, -1, 0, 0, 0, 0};
    static final int[] D_H = {0, 0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        M = scanner.nextInt(); // 가로
        N = scanner.nextInt(); // 세로
        H = scanner.nextInt(); // 높이

        box = new int[H][N][M];
        days = new int[H][N][M]; // 각 위치의 토마토가 익은 날짜를 저장

        Queue<Tomato> queue = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = scanner.nextInt();
                    if (box[h][n][m] == 1) {
                        queue.offer(new Tomato(h, n, m));
                    }
                }
            }
        }
        bfs(queue);
        int result = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == NOT_RIPE) {
                        System.out.println(-1); // 익지 않은 토마토가 남아 있음
                        return;
                    }
                    result = Math.max(result, days[h][n][m]);
                }
            }
        }

        System.out.println(result);
    }

    private static void bfs(Queue<Tomato> queue) {
        while (!queue.isEmpty()) {
            Tomato current = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nh = current.h + D_H[i];
                int nn = current.n + D_N[i];
                int nm = current.m + D_M[i];

                if (
                        nh > -1 && nh < H
                                && nn > -1 && nn < N
                                && nm > -1 && nm < M
                ) {
                    if (box[nh][nn][nm] == NOT_RIPE) {
                        box[nh][nn][nm] = RIPE;
                        days[nh][nn][nm] = days[current.h][current.n][current.m] + 1; // 날짜 증가
                        queue.offer(new Tomato(nh, nn, nm));
                    }
                }
            }
        }
    }
}

class Tomato {
    int h, n, m;

    public Tomato(int h, int n, int m) {
        this.h = h;
        this.n = n;
        this.m = m;
    }
}
/*
M N H
 1: 익은 토마토
 0: 익지 않은 토마토
-1: 토마토 아님

output:
- 최소 며칠이 걸리는지 출력
- 저장될 때부터 익어있으면 0
- 토마토가 모두 익지 못하면 -1
*/
