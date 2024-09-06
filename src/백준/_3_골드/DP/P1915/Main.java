package 백준._3_골드.DP.P1915;

import java.io.*;

public class Main {
    private static int n;
    private static int m;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[n][m];
        int rs = 0;

        for (int i = 0; i < n; i++) {
            String[] nums = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                int binary = Integer.parseInt(nums[j]);
                if (binary == 1 && i > 0 && j > 0) {
                    // 왼쪽과 위쪽
                    int min = Math.min(arr[i][j - 1], arr[i - 1][j]);
                    // 위 결과와 대각선 왼쪽
                    min = Math.min(min, arr[i - 1][j - 1]);
                    arr[i][j] = min + 1;
                    rs = Math.max(min + 1, rs);
                } else if (binary == 1) {
                    arr[i][j] = binary;
                    if (rs < 1) {
                        rs = 1;
                    }
                }
            }
        }
        System.out.println(rs * rs);
    }
}
