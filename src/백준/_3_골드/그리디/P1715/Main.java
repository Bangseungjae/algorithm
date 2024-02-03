package 백준._3_골드.그리디.P1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(bf.readLine()));
        }

        int sum = 0;
        while (queue.size() > 1) {
            Integer n1 = queue.poll();
            Integer n2 = queue.poll();
            int x = n1 + n2;
            sum += x;
            queue.add(x);
        }
        System.out.println(sum);
    }
}
