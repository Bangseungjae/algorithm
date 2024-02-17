package 백준._2_실버.BFS.P1325;

import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static int[] answer;
    static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        answer = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
        }
        for (int i = 1; i < N + 1; i++) {
            isVisit = new boolean[N + 1];
            bfs(i);
        }

        int max = 0;
        for (int i = 1; i < N + 1; i++) {
            max = Math.max(max, answer[i]);
        }
        for (int i = 1; i < N + 1; i++) {
            if (max == answer[i]) {
                bw.write(i + " ");
            }
        }
        bw.flush();
        bw.close();
    }

    static void bfs(int index) {
        isVisit[index] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (Integer i : list[poll]) {
                if (!isVisit[i]) {
                    isVisit[i] = true;
                    answer[i]++;
                    queue.add(i);
                }
            }
        }
    }
}
