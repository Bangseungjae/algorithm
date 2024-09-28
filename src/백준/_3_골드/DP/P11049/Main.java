package 백준._3_골드.DP.P11049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[][] arr;
    private static int[][] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        D = new int[N][N];
        for (int[] d : D) {
            Arrays.fill(d, -1);
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int result = execute(0, N - 1);
        System.out.println(result);
    }

    private static int execute(int s, int e) {
        if (D[s][e] != -1) {
            return D[s][e];
        }
        if (s == e) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        for (int i = s; i < e; i++) {
            int cost = execute(s, i) + execute(i + 1, e) + (arr[s][0] * arr[i][1] * arr[e][1]);
            result = Math.min(result, cost);
        }

        return D[s][e] = result;
    }
}
