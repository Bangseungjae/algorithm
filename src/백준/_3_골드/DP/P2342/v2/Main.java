package 백준._3_골드.DP.P2342.v2;

import java.io.*;
import java.util.*;

public class Main {
    private static final int[][] move = {
            {0, 2, 2, 2, 2},
            {0, 1, 3, 4, 3},
            {0, 3, 1, 3, 4},
            {0, 4, 3, 1, 3},
            {0, 3, 4, 3, 1}
    };

    private static final int big = (1 << 30) - 1;

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] dp = new int[5][5];
        int[][] ndp = new int[5][5];
        for (int i = 0; i < 5; i++) {
            Arrays.fill(dp[i], big);
            Arrays.fill(ndp[i], big);
        }
        dp[0][0] = 0;

        while (true) {
            int x = scanInt();
            if (x == 0) break;

            for (int i = 0; i <= 4; i++) {
                if (i != x) {
                    for (int j = 0; j <= 4; j++) {
                        ndp[x][i] = Math.min(ndp[x][i], dp[j][i] + move[j][x]);
                        ndp[i][x] = Math.min(ndp[i][x], dp[i][j] + move[j][x]);
                    }
                }
            }

            for (int i = 0; i <= 4; i++) {
                for (int j = 0; j <= 4; j++) {
                    dp[i][j] = ndp[i][j];
                    ndp[i][j] = big;
                }
            }
        }

        int m = big;
        for (int[] row : dp) {
            for (int value : row) {
                m = Math.min(m, value);
            }
        }

        bw.write(String.valueOf(m));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int scanInt() throws IOException {
        if (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }
}
