package 백준.P1546_평균;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int src = sc.nextInt();
            if (max < src) max = src;
            sum += src;
        }
        System.out.println(sum * 100.0 / max / n);
    }
}
