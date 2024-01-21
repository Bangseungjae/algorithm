package 백준._2_실버.스택and큐.P11286;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) -> {
            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);
            if (firstAbs == secondAbs) {
                return o1 > o2 ? 1 : -1;
            } else {
                return firstAbs - secondAbs;
            }
        });
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x == 0) {
                if (!myQueue.isEmpty()) {
                    sb.append(myQueue.poll()).append("\n");
                } else {
                    sb.append("0\n");
                }
            } else {
                myQueue.add(x);
            }
        }
        System.out.println(sb);
    }
}
