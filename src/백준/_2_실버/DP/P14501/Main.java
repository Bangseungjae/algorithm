package 백준._2_실버.DP.P14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] T;
    static int[] P;
    static int[] D;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        T = new int[N + 6];
        P = new int[N + 6];
        D = new int[N + 6];
        StringTokenizer st;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            T[i] = t;
            P[i] = p;
        }

        for (int i = N; i > 0; i--) {
            if (T[i] + i > N + 1) { // 오늘 시작되는 상담을 했을 때 퇴사일 까지 끝나지 않는 경우
                D[i] = D[i + 1];
            } else { // 오늘 시작되는 상담을 했을 때 퇴사일 까지 끝나는 경우
                D[i] = Math.max(D[i + 1], D[i + T[i]] + P[i]);
            }
        }
        System.out.println(D[1]);
    }
}
