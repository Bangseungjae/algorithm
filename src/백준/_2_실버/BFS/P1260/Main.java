package 백준._2_실버.BFS.P1260;

import java.io.*;
import java.util.*;

public class Main {

    static Stack<Integer>[] dfsStack;
    static boolean[] dfsIsVisit;
    static List<Integer> dfsResult;
    static List<Integer>[] bfsList;
    static boolean[] bfsIsVisit;
    static List<Integer> bfsResult;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dfsStack = new Stack[N + 1];
        dfsIsVisit = new boolean[N + 1];
        dfsResult = new ArrayList<>();
        bfsList = new ArrayList[N + 1];
        bfsIsVisit = new boolean[N + 1];
        bfsResult = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            dfsStack[i] = new Stack<>();
            bfsList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            dfsStack[from].add(to);
            dfsStack[to].add(from);
            bfsList[from].add(to);
            bfsList[to].add(from);
        }
        for (int i = 1; i < N + 1; i++) {
            dfsStack[i].sort(Comparator.reverseOrder());
            bfsList[i].sort(Comparator.naturalOrder());
        }

        dfs(V);
        bfs(V);

        for (Integer i : dfsResult) {
            bw.write(i + " ");
        }
        bw.write("\n");
        for (Integer i : bfsResult) {
            bw.write(i + " ");
        }
        bw.flush();
    }

    static void dfs(int index) {
        if (dfsIsVisit[index]) {
            return;
        }
        dfsIsVisit[index] = true;
        dfsResult.add(index);
        while (!dfsStack[index].isEmpty()) {
            dfs(dfsStack[index].pop());
        }
    }

    static void bfs(int index) {
        bfsIsVisit[index] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);

        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            bfsResult.add(v);
            for (Integer w : bfsList[v]) {
                if (!bfsIsVisit[w]) {
                    bfsIsVisit[w] = true;
                    queue.add(w);
                }
            }
        }
    }
}
