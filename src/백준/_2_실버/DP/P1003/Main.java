package 백준._2_실버.DP.P1003;

import java.util.Scanner;

public class Main {
    static final int FIBONACCI_COUNT = 41;
    static int[] memoization = new int[FIBONACCI_COUNT];
    static int[] zero = new int[FIBONACCI_COUNT];
    static int[] one = new int[FIBONACCI_COUNT];


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        zero[0] = 1;
        one[1] = 1;

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            fibonacci(n);

            System.out.println(zero[n] + " " + one[n]);
        }
    }

    private static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if(memoization[n] != 0) {
            return memoization[n];
        } else {
            memoization[n] = fibonacci(n - 1) + fibonacci(n - 2);
            one[n] += one[n - 1] + one[n - 2];
            zero[n] += zero[n - 1] + zero[n - 2];
            return memoization[n];
        }
    }
}
