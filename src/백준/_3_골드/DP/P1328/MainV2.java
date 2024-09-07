package 백준._3_골드.DP.P1328;

import java.io.*;
import java.util.StringTokenizer;

public class MainV2 {
    private static final int MOD = 1000000007;
    private static long[][][] cache;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        cache = new long[N + 1][L + 1][R + 1];
        System.out.println(dp(N, L, R));
    }

    private static long dp(int N, int L, int R) {
        if (L + R > N + 1 || N == 0 || L == 0 || R == 0) {
            return 0;
        }
        if (N == L || N == R) {
            return 1;
        }
        if (cache[N][L][R] != 0) {
            return cache[N][L][R];
        }
        return cache[N][L][R] =
                (
                        dp(N - 1, L - 1, R) +
                        dp(N - 1, L, R - 1) +
                        dp(N - 1, L, R) * (N - 2)
                ) % MOD;
    }
}
