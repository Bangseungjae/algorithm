package 백준._2_실버.정수론.P1929;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] A = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            A[i] = i;
        }

        for (int i = 2; i < N; i++) {
            if (A[i] == 0) {
                continue;
            }

            for (int j = i + i; j <= N; j = j + i) {
                A[j] = 0;
            }
        }

        for (int i = M; i <= N; i++) {
            if (A[i] != 0) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
