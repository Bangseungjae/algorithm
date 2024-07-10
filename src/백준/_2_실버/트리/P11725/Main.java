package 백준._2_실버.트리.P11725;

import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer>[] tree;
    private static boolean[] visited;
    private static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        visited = new boolean[N + 1];
        tree = new ArrayList[N + 1];
        answer = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            tree[x1].add(x2);
            tree[x2].add(x1);
        }
        DFS(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < N + 1; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }
    static void DFS(int number) {
        visited[number] = true;
        for (int i : tree[number]) {
            if (!visited[i]) {
                answer[i] = number;
                DFS(i);
            }
        }
    }
}
