package 백준._3_골드.DFS_BFS.P13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isVisit;
    static ArrayList<Integer>[] A;
    static boolean alive = false;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        isVisit = new boolean[N];
        A = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 1; i < M + 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            A[from].add(to);
            A[to].add(from);
        }
        for (int i = 0; i < N; i++) {
            dfs(i, 1);
        }
        if (alive)
            System.out.println(1);
        else
            System.out.println(0);
    }

    static void dfs(int index, int depth) {
        if (depth == 5 || alive) {
            alive = true;
            return;
        }
        if (isVisit[index]) {
            return;
        }
        isVisit[index] = true;

        for (int to : A[index]) {
            if (!isVisit[to]) {
                dfs(to, depth + 1);
            }
        }

        isVisit[index] = false;
    }
}
