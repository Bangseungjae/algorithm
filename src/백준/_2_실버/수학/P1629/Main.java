package 백준._2_실버.수학.P1629;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        long[] arr = new long[101];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        for (int i = 4; i < 101; i++) {
            arr[i] = arr[i-3] + arr[i-2];
        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            System.out.println(arr[x]);
        }
    }
}
