package 백준._2_실버.그래프.플로이드와샬.P1058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainV2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] friends = new boolean[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            String str = br.readLine();
            for (int j = 1; j < n + 1; j++) {
                if (str.charAt(j - 1) == 'Y') {
                    friends[i][j] = true;
                }
            }
        }

        int max = 0;
        boolean[] visited;
        int count;
        for (int i = 1; i < n + 1; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            count = 0;
            for (int j = 1; j < n + 1; j++) { // f-1
                if (!visited[j] && friends[i][j]) {
                    visited[j] = true;
                    count++;
                }
            }
            for (int j = 1; j < n + 1; j++) { // f-2
                if (friends[i][j]) {
                    for (int k = 1; k < n + 1; k++) {
                        if (!visited[k] && friends[j][k]) {
                            visited[k] = true;
                            count++;
                        }
                    }
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}
