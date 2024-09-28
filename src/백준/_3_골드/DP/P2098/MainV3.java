package 백준._3_골드.DP.P2098;

import java.io.*;
import java.util.*;


// 오히려 더 느림
public class MainV3 {
    private static int[][] dp;
    private static int[][] dist;
    private static int n, fullMask;
    private static final int INF = 1_000_000 * 16 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        fullMask = (1 << n) - 1;
        dist = new int[n][n];
        dp = new int[n][1 << n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(tsp(0, 1));
    }

    static int tsp(int cur, int visited) {
        if (visited == fullMask) {
            return dist[cur][0] != 0 ? dist[cur][0] : INF;
        }

        if (dp[cur][visited] != -1) {
            return dp[cur][visited];
        }

        dp[cur][visited] = INF;
        for (int next = 0; next < n; next++) {
            if ((visited & (1 << next)) != 0 || dist[cur][next] == 0) continue;
            dp[cur][visited] = Math.min(dp[cur][visited], tsp(next, visited | (1 << next)) + dist[cur][next]);
        }

        return dp[cur][visited];
    }
}
