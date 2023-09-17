package 백준.DP._2xN타일링;

import java.util.Scanner;

public class Main {
    private static final int mod = 10_007;
    private static final int[] arr = new int[1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        int i;

        for (i = 0; i < n; i++) {
            if (i == 0) {
                arr[i] = 1;
            } else if (i == 1) {
                arr[i] = arr[i - 1] + 1;
            } else {
                arr[i] = arr[i - 2] + arr[i - 1] % mod;
            }
        }
        System.out.println(arr[i - 1] % mod);
    }
}
