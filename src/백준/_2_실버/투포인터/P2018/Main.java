package 백준._2_실버.투포인터.P2018;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int sum = 1;
        int startIndex = 1;
        int endIndex = 1;

        while (endIndex != N) {
            if (sum == N) {
                endIndex++;
                sum = sum + endIndex;
                count++;
            } else if (sum > N) {
                sum = sum - startIndex;
                startIndex++;
            } else if (sum < N) {
                endIndex++;
                sum = sum + endIndex;
            }
        }
        System.out.println(count);
    }
}
