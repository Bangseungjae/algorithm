package 백준._3_골드.DP.P2342;

import java.io.*;

public class Wrong {
    private static final int[][] mp = {
            {1, 2, 2, 2, 2}, // 0 -> x
            {2, 1, 3, 4, 3}, // 1 -> x
            {2, 3, 1, 3, 4}, // 2 -> x
            {2, 4, 3, 1, 3}, // 3 -> x
            {2, 3, 4, 3, 1}, // 4 -> x
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] arr = new int[input.length() / 2];

        for (int i = 0, j = 0; true; i += 2, j++) {
            if (input.charAt(i) == '0') {
                break;
            }
            arr[j] = input.charAt(i) - '0';
        }

        int[][][] dp = new int[arr.length + 1][5][5];
        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    dp[i][j][k] = 100000000;
                }
            }
        }
        dp[0][0][0] = 0;
        dp[1][0][arr[0]] = mp[0][arr[0]];
        dp[1][arr[0]][0] = mp[0][arr[0]];
        for (int x = 2; x < arr.length + 1; x++) {
            int n = arr[x - 1];
            for (int i = 0; i < 5; i++) { // 왼쪽
                dp[x][i][n] = Math.min(dp[x - 1][i][n] + mp[i][n], dp[x][i][n]);
            }
            for (int i = 0; i < 5; i++) { // 오른쪽
                dp[x][n][i] = Math.min(dp[x - 1][n][i] + mp[i][n], dp[x][n][i]);
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                min = Math.min(min, dp[arr.length][i][j]);
            }
        }
        System.out.println(min);
    }
}
