package goorm.이카운트.김이카의쇼핑;

import java.io.*;
import java.util.*;

public class MainV2 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        long L = Long.parseLong(st.nextToken());
        long R = Long.parseLong(st.nextToken());

        long[] prefixSum = new long[N + 1];

        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + Long.parseLong(st.nextToken());
        }

        int count = 0;

        // Use a sliding window technique
        for (int start = 0; start < N; start++) {
            for (int end = start + 1; end <= N; end++) {
                long sum = prefixSum[end] - prefixSum[start];
                if (sum >= L && sum <= R) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
