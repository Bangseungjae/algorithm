package goorm.소프티어코테_모의테스트;

import java.io.*;
import java.util.*;
class Main {
    static int N;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        N = Integer.parseInt(input);
        matrix = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                matrix[i][j] = x;
            }
        }
        List<Integer> regionSizes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    int size = dfs(i, j);
                    regionSizes.add(size);
                }
            }
        }
        Collections.sort(regionSizes);
        System.out.println(regionSizes.size());
        for (int size: regionSizes) {
            System.out.print(size + " ");
        }
    }

    static int dfs(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N || visited[row][col] || matrix[row][col] == 0) {
            return 0;
        }

        visited[row][col] = true;
        int size = 1;
        for (int i = 0; i < 4; i++) {
            size += dfs(row + dRow[i], col + dCol[i]);
        }
        return size;
    }
}
