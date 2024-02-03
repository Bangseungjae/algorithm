package 백준._3_골드.그리디.P1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Queue<Integer> negative = new PriorityQueue<>(Comparator.naturalOrder());
        Queue<Integer> positive = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> zero = new PriorityQueue<>();
        int one = 0;

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(bf.readLine());

            if (x > 1) {
                positive.add(x);
            } else if (x < 0) {
                negative.add(x);
            } else if (x == 0) {
                zero.add(x);
            } else {
                one++;
            }
        }

        int sum = 0;

        while (positive.size() > 1) {
            Integer x = positive.poll();
            Integer y = positive.poll();
            sum += x * y;
        }
        while (!positive.isEmpty()) {
            sum += positive.poll();
        }

        while (negative.size() > 1) {
            Integer x = negative.poll();
            Integer y = negative.poll();
            sum += x * y;
        }
        if (!negative.isEmpty()) {
            Integer x = negative.poll();
            if (zero.isEmpty()) {
                sum += x;
            } else {
                Integer z = zero.poll();
                sum += x * z;
            }
        }

        sum += one;
        System.out.println(sum);
    }
}
