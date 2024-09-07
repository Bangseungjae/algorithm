package 백준._3_골드.DP.P1328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainV4 {
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        long[][][] dp = new long[N + 1][L + 1][R + 1];

        // 기본 케이스 초기화
        dp[1][1][1] = 1;

        // 상향식으로 dp 배열 채우기
        for (int n = 2; n <= N; n++) {
            for (int l = 1; l <= Math.min(n, L); l++) {
                for (int r = 1; r <= Math.min(n, R); r++) {
                    if (l + r <= n + 1) {  // 가능한 경우만 계산
                        long sum = 0;
                        if (l > 1) sum = (sum + dp[n - 1][l - 1][r]) % MOD;  // 왼쪽에 추가
                        if (r > 1) sum = (sum + dp[n - 1][l][r - 1]) % MOD;  // 오른쪽에 추가
                        if (n > 2) sum = (sum + dp[n - 1][l][r] * (n - 2)) % MOD;  // 중간에 추가
                        dp[n][l][r] = sum;
                    }
                }
            }
        }

        System.out.println(dp[N][L][R]);
    }
}
