package 백준._3_골드.DP.P2098;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] D;
    private static final int INF = 1_000_000 * 16 + 1;
    private static int[][] W;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        D = new int[N][1 << 16];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(tsp(0, 1));
    }

    static int tsp(int c, int v) {
        if (v == (1 << N) - 1) { // 모든 도시를 방문할 때
            return W[c][0] == 0 ? INF : W[c][0];
        }
        if (D[c][v] != 0) { // 이미 방문한 노드일 때 -> 바로 리턴(메모이제이션)
            return D[c][v];
        }
        int minValue = INF;
        for (int i = 0; i < N; i++) {
            if ((v & (1 << i)) == 0 && W[c][i] != 0) { // 방문한 적이 없고, 갈 수 있는 도시일 때
                minValue = Math.min(minValue, tsp(i, (v | (1 << i))) + W[c][i]);
            }
        }
        D[c][v] = minValue;
        return D[c][v];
    }
}
