package 백준._2_실버.정렬.P1940주몽;

import java.io.*;
import java.util.*;

/**
 * 투포인터 문제
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // N번 만큼 array값 받기
        Integer[] A = new Integer[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 자료 배열 정렬
        Arrays.sort(A);

        // count 구하기
        int count = 0;
        int i = 0;
        int j = N - 1;
        while (i < j) {
            int sum = A[i] + A[j];

            if (sum < M)i++;
            else if(sum > M)j--;
            else{
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);
    }
}
