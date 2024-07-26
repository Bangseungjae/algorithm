package 백준._1_브론즈.수학.조합.P1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[][] D;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        D = new long[31][31];
        for (int i = 0; i < 31; i++) {
            D[i][1] = i;
            D[i][0] = 1;
            D[i][i] = 1;
        }

        for (int i = 2; i < 31; i++) {
            for (int j = 1 ; j < i; j++) {
                D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
            }
        }

        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            String[] s = bf.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            System.out.println(D[M][N]);
        }
    }
}
