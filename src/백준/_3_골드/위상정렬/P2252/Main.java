package 백준._3_골드.위상정렬.P2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] D;
    static boolean[] isVisit;
    static ArrayList<Integer>[] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        D = new int[N + 1];
        isVisit = new boolean[N + 1];
        lists = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            lists[i] = new ArrayList();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lists[x].add(y);
            D[y]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (D[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            System.out.print(poll + " ");
            for (Integer i : lists[poll]) {
                D[i]--;
                if (D[i] == 0) {
                    queue.offer(i);
                }
            }
        }
    }
}
