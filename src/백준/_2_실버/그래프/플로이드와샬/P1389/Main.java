package 백준._2_실버.그래프.플로이드와샬.P1389;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] relations = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) {
                    relations[i][j] = 0;
                } else {
                    relations[i][j] = 1_000_000;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relations[a][b] = 1;
            relations[b][a] = 1;
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (relations[i][j] > relations[i][k] + relations[k][j]) {
                        relations[i][j] = relations[i][k] + relations[k][j];
                    }
                }
            }
        }

        int[] sumArr = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            int sum = 0;
            for (int j = 1; j < n + 1; j++) {
                sum += relations[i][j];
            }
            sumArr[i] = sum;
        }

        int min = Integer.MAX_VALUE;
        int sum = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            if (sum > sumArr[i]) {
                sum = sumArr[i];
                min = i;
            }
        }
        System.out.println(min);
    }
}
