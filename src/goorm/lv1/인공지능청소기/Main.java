package goorm.lv1.인공지능청소기;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            x = Math.abs(x);
            y = Math.abs(y);
            boolean b = true;
            if ((x + y) > t) b = false;
            if (x + y < t) {
                int p = t - (x + y);
                if (p != 0 && p % 2 != 0) {
                    b = false;
                }
            }
            print(b);
        }

    }

    public static void print(boolean b) {
        if (b) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
