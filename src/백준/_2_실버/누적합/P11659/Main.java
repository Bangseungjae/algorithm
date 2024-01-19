package 백준._2_실버.누적합.P11659;

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

        long[] sumArr = new long[N + 1];
        sumArr[0] = 0;
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            sumArr[i] = sumArr[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int x = 0; x < M; x++) {
            st = new StringTokenizer(bf.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(sumArr[j] - sumArr[i - 1]);
        }
    }
}
