package 백준._3_골드.DFS_BFS.P1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean isOk;
    static boolean[] isVisit;
    static int[] color;
    static ArrayList<Integer>[] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(bf.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            isVisit = new boolean[V + 1];
            color = new int[V + 1];
            lists = new ArrayList[V + 1];
            for (int j = 0; j < V + 1; j++) {
                isVisit[j] = false;
                lists[j] = new ArrayList();
                color[j] = 1;
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                lists[x].add(y);
                lists[y].add(x);
            }
            isOk = true;
            for (int j = 1; j < V + 1; j++) {
                if (isOk) {
                    dfs(j);
                } else {
                    break;
                }
            }
            printResult();
        }
    }

    private static void dfs(int index) {
        isVisit[index] = true;

        for (Integer i : lists[index]) {
            if (!isVisit[i]) {
                color[i] = - color[index];
                dfs(i);
            } else if (color[i] == color[index]){
                isOk = false;
            }
        }
    }

    private static void printResult() {
        if (isOk) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
