package 백준._3_골드.백트래킹.P9663;

import java.util.Scanner;

public class Main {
    static int n, score;
    static int[] queen;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        queen = new int[n];

        backTracking(0);
        System.out.println(score);
    }

    static void backTracking(int row) {
        if (row == n) {
            score++;
            return;
        }
        for (int i = 0; i < n; i++) {
            queen[row] = i;
            if (promising(row)) {
                backTracking(row + 1);
            }
        }
    }

    static boolean promising(int row) {
        for (int i = 0; i < row; i++) {
            if (queen[row] == queen[i])
                return false;

            if (Math.abs(row - i) == Math.abs(queen[row] - queen[i]))
                return false;
        }
        return true;
    }
}
