package 백준._2_실버.정수론.P1850;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        long count = x > y ? gcd(x, y) : gcd(y, x);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sb.append("1");
        }
        System.out.println(sb);
    }

    private static long gcd(long x, long y) {
        while (y != 0) {
            long z = x % y;
            x = y;
            y = z;
        }
        return x;
    }
}
