package 백준._3_골드.DP.P1328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        long[][][] D = new long[101][101][101];
        D[1][1][1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < l + 1; j++) {
                for (int k = 1; k < r + 1; k++) {
                    D[i][j][k] = (D[i - 1][j - 1][k] + D[i - 1][j][k - 1] + (D[i - 1][j][k] * (i - 2))) % MOD;
                }
            }
        }
        System.out.println(D[n][l][r]);
    }
}
