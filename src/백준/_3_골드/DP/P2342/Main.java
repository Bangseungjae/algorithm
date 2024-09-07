package 백준._3_골드.DP.P2342;

import java.io.*;
import java.util.*;

public class Main {
    private static final int[][] mp = {
            {0, 2, 2, 2, 2},
            {2, 1, 3, 4, 3},
            {2, 3, 1, 3, 4},
            {2, 4, 3, 1, 3},
            {2, 3, 4, 3, 1},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> arr = new ArrayList<>();

        while (true) {
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            arr.add(n);
        }

        int[][][] dp = new int[arr.size() + 1][5][5];
        for (int i = 0; i <= arr.size(); i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE / 2);
            }
        }
        dp[0][0][0] = 0;

        for (int i = 1; i <= arr.size(); i++) {
            int cur = arr.get(i - 1);
            for (int left = 0; left < 5; left++) {
                for (int right = 0; right < 5; right++) {
                    // 왼발 이동
                    dp[i][cur][right] = Math.min(dp[i][cur][right], dp[i-1][left][right] + mp[left][cur]);
                    // 오른발 이동
                    dp[i][left][cur] = Math.min(dp[i][left][cur], dp[i-1][left][right] + mp[right][cur]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int left = 0; left < 5; left++) {
            for (int right = 0; right < 5; right++) {
                min = Math.min(min, dp[arr.size()][left][right]);
            }
        }
        System.out.println(min);
    }
}
