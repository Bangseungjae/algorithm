package 백준._1_브론즈.조합.P11051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] A;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        A = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            A[i][0] = 1;
            A[i][i] = 1;
            A[i][1] = i;
        }
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                A[i][j] = (A[i - 1][j] + A[i - 1][j - 1]) % 10007;
            }
        }
        System.out.println(A[N][K]);
    }
}
