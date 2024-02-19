package 백준._3_골드.DFS_BFS.P10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;
    static boolean[][] isVisit;
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        map = new char[N][N];
        isVisit = new boolean[N][N];
        count = 0;

        for (int i = 0; i < N; i++) {
            String line = bf.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisit[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        System.out.print(count + " ");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                isVisit[i][j] = false;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'R') {
                    map[i][j] = 'G';
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                isVisit[i][j] = false;
            }
        }
        count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisit[i][j]) {
                    count++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(count);
    }

    static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= map.length || y >= map.length) {
            return;
        }
        if (isVisit[x][y]) {
            return;
        }
        isVisit[x][y] = true;

        if (x < N - 1 && map[x][y] == map[x + 1][y]) {
            if (!isVisit[x + 1][y]) {
                dfs(x + 1, y);
            }
        }
        if (x > 0 && map[x][y] == map[x - 1][y]) {
            if (!isVisit[x - 1][y]) {
                dfs(x - 1, y);
            }
        }
        if (y < N - 1 && map[x][y] == map[x][y + 1]) {
            if (!isVisit[x][y + 1]) {
                dfs(x, y + 1);
            }
        }

        if (y > 0 && map[x][y] == map[x][y - 1]) {
            if (!isVisit[x][y - 1]) {
                dfs(x, y - 1);
            }
        }
    }
}
