package 백준._3_골드.구현.P15686;

import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static final ArrayList<int[]> house = new ArrayList<>();
    private static final ArrayList<int[]> chicken = new ArrayList<>();
    private static final ArrayList<int[]> selected = new ArrayList<>();
    private static int result = Integer.MAX_VALUE;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int x;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                x = Integer.parseInt(st.nextToken());
                if (x == 2) {
                    chicken.add(new int[]{i, j});
                }
                if (x == 1) {
                    house.add(new int[]{i, j});
                }
            }
        }
        visited = new boolean[chicken.size()];
        back(0, 0);
        System.out.println(result);

    }

    private static void back(int depth, int start) {
        if (depth == M) {
            int sum = 0;
            for (int[] h : house) {
                int min = Integer.MAX_VALUE;
                for (int[] s : selected) {
                    int d = Math.abs(h[0] - s[0]) + Math.abs(h[1] - s[1]);
                    min = Math.min(min, d);
                }
                sum += min;
            }
            result = Math.min(result, sum);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected.add(chicken.get(i));
                back(depth + 1, i + 1);
                selected.remove(selected.size() - 1);
                visited[i] = false;
            }
        }
    }
}

