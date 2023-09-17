package 백준.DP.계단오르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n + 1];
        int[] dpArr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        dpArr[1] = arr[1];
        if (n >= 2) {
            dpArr[2] = arr[1] + arr[2];
        }
        for (int i = 3; i <= n; i++) {
            dpArr[i] = Math.max(dpArr[i - 2], dpArr[i - 3] + arr[i - 1]) + arr[i];
        }
        System.out.println(dpArr[n]);
    }
}
