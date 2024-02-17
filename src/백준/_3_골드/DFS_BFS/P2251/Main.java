package 백준._3_골드.DFS_BFS.P2251;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] Sender = {0, 0, 1, 1, 2, 2};
    static int[] Receiver = {1, 2, 0, 2, 0, 1};
    static boolean visited[][];
    static int now[];
    static boolean answer[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        now = new int[3];
        for (int i = 0; i < 3; i++) {
            now[i] = sc.nextInt();
        }
        visited = new boolean[201][201];
        answer = new boolean[201];
        BFS();
        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static void BFS() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;
        while (!queue.isEmpty()) {
            AB p = queue.poll();
            int A = p.a;
            int B = p.b;
            int C = now[2] - A - B;
            for (int k = 0; k < 6; k++) {
                int[] next = {A, B, C};
                next[Receiver[k]] += next[Sender[k]];
                next[Sender[k]] = 0;
                if (next[Receiver[k]] >= now[Receiver[k]]) {
                    next[Sender[k]] = next[Receiver[k]] - now[Receiver[k]];
                    next[Receiver[k]] = now[Receiver[k]];
                }
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
        visited[now[0]][now[1]] = true;
    }
}

class AB {
    int a;
    int b;
    public AB(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
