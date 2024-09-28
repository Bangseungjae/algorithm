package 백준._2_실버.그래프.BFS.P2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[][] D;
    static int N;
    static int max = 0;
    static final int INF = 100000;
    static final int[] X = {1, -1, 0, 0};
    static final int[] Y = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        D = new int[N + 1][N + 1];
        StringTokenizer st;

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                int num = Integer.parseInt(st.nextToken());
                max = Math.max(max, num);
                arr[i][j] = num;
            }
        }
        int rs = 0;
        for (int i = 1; i < max + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                for (int k = 1; k < N + 1; k++) {
                    D[j][k] = arr[j][k] < i ? INF : arr[j][k];
                }
            }
            int count = 0;
            for (int j = 1; j < N + 1; j++) {
                for (int k = 1; k < N + 1; k++) {
                    if (D[j][k] != INF) {
                        count++;
                        dfs(j, k);
                    }
                }
            }
            rs = Math.max(rs, count);
        }
        System.out.println(rs);
    }

    static void dfs(int x, int y) {
        if (D[x][y] == INF) {
            return;
        }
        D[x][y] = INF;
        for (int i = 0; i < 4; i++) {
            if (
                    x + X[i] < N + 1 &&
                    x + X[i] > 0 &&
                    y + Y[i] < N + 1 &&
                    y + Y[i] > 0 &&
                    D[x + X[i]][y + Y[i]] != INF
            ) {
                dfs(x + X[i], y + Y[i]);
            }
        }
    }
}
