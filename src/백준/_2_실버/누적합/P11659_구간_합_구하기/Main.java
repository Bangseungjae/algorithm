package 백준._2_실버.누적합.P11659_구간_합_구하기;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] s = new long[N + 1];
        s[0] = 0;
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            int src = Integer.parseInt(st.nextToken());
            s[i] = src + s[i - 1];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            System.out.println(s[y] - s[x - 1]);
        }
    }
}
