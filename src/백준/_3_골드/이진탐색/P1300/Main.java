package 백준._3_골드.이진탐색.P1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * B 배열(N = 3)
 * 1 2 3 4 5 6 7 8 9
 * 1 2 2 3 3 4 6 6 9
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int K = Integer.parseInt(bf.readLine());

        int start = 1;
        int end = K;
        int rs = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 0;
            for (int i = 1; i < N + 1; i++) {
                cnt += Math.min(N, mid / i);
            }

            if (cnt < K) {
                start = mid + 1;
            } else {
                end = mid - 1;
                rs = mid;
            }
        }
        System.out.println(rs);
    }
}

