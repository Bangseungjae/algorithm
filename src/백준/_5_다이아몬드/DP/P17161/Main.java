package 백준._5_다이아몬드.DP.P17161;

import java.io.*;
import java.util.*;

public class Main {
    static String S, T;
    static StringBuilder ans = new StringBuilder();
    static int[] prev;
    static int[] upper;
    static int[] lower;
    static int[][] dp;
    static int maxN;

    public static void ED(String S, String T) {
        int nS = S.length();
        int nT = T.length();

        // 인덱스를 1부터 시작하기 위해 문자열 앞에 공백 추가
        S = " " + S;
        T = " " + T;

        if (nS == 1) {
            // 전역 dp 배열 사용
            Arrays.fill(dp[0], 0, nT + 1, 0);
            Arrays.fill(dp[1], 0, nT + 1, 0);

            for (int i = 0; i <= nT; i++) dp[0][i] = i;
            dp[1][0] = 1;
            for (int i = 1; i <= nT; i++) {
                if (S.charAt(1) == T.charAt(i)) dp[1][i] = dp[0][i - 1];
                else dp[1][i] = Math.min(dp[1][i - 1], Math.min(dp[0][i - 1], dp[0][i])) + 1;
            }

            int x = nS, y = nT;
            ArrayList<Pair<Character, Character>> rst = new ArrayList<>();
            while (x != 0 || y != 0) {
                if (x == 0 && y != 0) { // ADD ONLY
                    rst.add(new Pair<>('a', T.charAt(y)));
                    y--;
                    continue;
                } else if (x != 0 && y == 0) { // DELETE ONLY
                    rst.add(new Pair<>('d', S.charAt(x)));
                    x--;
                    continue;
                }

                int mnv = Math.min(dp[x - 1][y], Math.min(dp[x - 1][y - 1], dp[x][y - 1]));
                if (dp[x - 1][y - 1] == mnv) {
                    if (dp[x][y] == mnv) { // COPY
                        rst.add(new Pair<>('c', S.charAt(x)));
                    } else { // MODIFY
                        rst.add(new Pair<>('m', T.charAt(y)));
                    }
                    x--;
                    y--;
                } else if (dp[x - 1][y] == mnv) { // DELETE
                    rst.add(new Pair<>('d', S.charAt(x)));
                    x--;
                } else { // ADD
                    rst.add(new Pair<>('a', T.charAt(y)));
                    y--;
                }
            }

            Collections.reverse(rst);
            for (Pair<Character, Character> p : rst) {
                ans.append(p.first).append(' ').append(p.second).append('\n');
            }
            return;
        }

        int nSize = nT + 2;

        // 배열 초기화
        Arrays.fill(prev, 0, nSize, 0);
        Arrays.fill(upper, 0, nSize, 0);
        Arrays.fill(lower, 0, nSize, 0);

        int mid = nS / 2;

        // Forward DP
        for (int i = 0; i <= nT; i++) prev[i] = i;
        for (int i = 1; i <= mid; i++) {
            upper[0] = i;
            for (int j = 1; j <= nT; j++) {
                if (S.charAt(i) == T.charAt(j)) upper[j] = prev[j - 1];
                else upper[j] = Math.min(upper[j - 1], Math.min(prev[j], prev[j - 1])) + 1;
            }
            System.arraycopy(upper, 0, prev, 0, nT + 1);
        }

        // Reverse DP
        for (int i = nT + 1; i >= 1; i--) prev[i] = nT + 1 - i;
        for (int i = nS; i >= mid + 1; i--) {
            lower[nT + 1] = nS - i + 1;
            for (int j = nT; j >= 1; j--) {
                if (S.charAt(i) == T.charAt(j)) lower[j] = prev[j + 1];
                else lower[j] = Math.min(lower[j + 1], Math.min(prev[j], prev[j + 1])) + 1;
            }
            System.arraycopy(lower, 0, prev, 0, nT + 2);
        }

        // 최소 비용과 분할 지점 찾기
        int mnv = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 0; i <= nT; i++) {
            int cost = upper[i] + lower[i + 1];
            if (cost < mnv) {
                mnv = cost;
                idx = i;
            }
        }

        String LT = T.substring(1, idx + 1);
        String RT = T.substring(idx + 1);
        String US = S.substring(1, mid + 1);
        String DS = S.substring(mid + 1);

        ED(US, LT);
        ED(DS, RT);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        maxN = Math.max(S.length(), T.length()) + 2;
        prev = new int[maxN];
        upper = new int[maxN];
        lower = new int[maxN];
        dp = new int[2][maxN];

        ED(S, T);

        System.out.print(ans.toString());
    }

    static class Pair<F, S> {
        F first;
        S second;

        public Pair(F f, S s) {
            first = f;
            second = s;
        }
    }
}
