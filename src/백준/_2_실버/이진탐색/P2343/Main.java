package 백준._2_실버.이진탐색.P2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        st = new StringTokenizer(bf.readLine());
        int endIndex = 0;
        int startIndex = 0;
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            endIndex += x;
            if (startIndex < x) startIndex = x;
        }

        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;
            int count = 0;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (sum + arr[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += arr[i];
            }
            if (sum != 0) {
                count++;
            }
            if (count > M)
                startIndex = mid + 1;
            else
                endIndex = mid - 1;
        }
        System.out.println(startIndex);
    }
}
