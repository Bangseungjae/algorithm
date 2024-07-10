package 백준._3_골드.트리.P1068;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] tree;
    static int answer = 0;
    static boolean[] visited;
    static int deleteNode = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        tree = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<Integer>();
        }
        int root = 0;
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x == -1) {
                root = i;
            } else {
                tree[i].add(x);
                tree[x].add(i);
            }
        }
        deleteNode = sc.nextInt();
        if (deleteNode == 0) {
            System.out.println(0);
        } else {
            DFS(root);
            System.out.println(answer);
        }
    }

    static void DFS(int num) {
        visited[num] = true;

        int cNode = 0;
        for (int i : tree[num]) {
            if (!visited[i] && i != deleteNode) {
                cNode++;
                DFS(i);
            }
        }
        if (cNode == 0) {
            answer++;
        }
    }
}
