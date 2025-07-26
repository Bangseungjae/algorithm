package 백준._1_브론즈.P2675;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        StringTokenizer st;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            for (char c : str.toCharArray()) {
                stringBuilder.append(String.valueOf(c).repeat(Math.max(0, cnt)));
            }
            stringBuilder.append('\n');
        }
        System.out.println(stringBuilder);
    }
}
