package 백준._2_실버.그래프.플로이드와샬.P1058;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        boolean[][] friends = new boolean[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            String str = br.readLine();
            for (int j = 1; j < n + 1; j++) {
                if (str.charAt(j - 1) == 'Y') {
                    friends[i][j] = true;
                }
            }
        }

        List<Integer> yList = new ArrayList<>();
        List<Integer> xList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) continue;
                if (friends[i][j]) {
                    set.add(j);
                    yList.add(j);
                } else {
                    xList.add(j);
                }
                for (int x : xList) {
                    for (int y : yList) {
                        if (x == y) continue;
                        if (friends[y][x]) set.add(x);
                    }
                }
            }
            yList.clear();
            xList.clear();
            max = Math.max(max, set.size());
            set.clear();
        }
        System.out.println(max);
    }
}
