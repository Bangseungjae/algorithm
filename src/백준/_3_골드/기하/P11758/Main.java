package 백준._3_골드.기하.P11758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [][] arr;
    static final int N = 3;
    public static void main(String[] args) throws IOException {
        arr = new int[N + 1][2];
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int left = arr[1][0] * arr[2][1] +
                arr[2][0] * arr[3][1] +
                arr[3][0] * arr[1][1];
        int right = arr[2][0] * arr[1][1] +
                arr[3][0] * arr[2][1] +
                arr[1][0] * arr[3][1];
        int rs = left - right;
        if (rs == 0) {
            System.out.println(0);
        } else if (rs < 0) {
            System.out.println(-1);
        } else {
            System.out.println(1);
        }
    }
}
