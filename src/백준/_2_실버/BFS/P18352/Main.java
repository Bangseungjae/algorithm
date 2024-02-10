package 백준._2_실버.BFS.P18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static boolean[] isVisit;
    static int[] weight;
    static List<Integer> rs = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        weight = new int[N + 1];
        isVisit = new boolean[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine() );
            list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        bfs(K, X);
        if (rs.isEmpty()) {
            System.out.println("-1");
        } else {
            rs.sort(Comparator.naturalOrder());
            for (Integer r : rs) {
                System.out.println(r);
            }
        }
    }

    private static void bfs(int K, int X) {
        weight[X] = 0;
        isVisit[X] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (weight[poll] == K) {
                rs.add(poll);
            }
            for (Integer integer : list[poll]) {
                if (!isVisit[integer]) {
                    weight[integer] = weight[poll] + 1;
                    isVisit[integer] = true;
                    queue.add(integer);
                }
            }
        }
    }
}
