package 백준._3_골드.DP.P1915;

import java.io.*;

public class MainV2 {
    private static final int FILLED = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] grid = new int[rows][cols];
        int maxSquareSize = 0;

        for (int i = 0; i < rows; i++) {
            String row = br.readLine();
                for (int j = 0; j < cols; j++) {
                grid[i][j] = row.charAt(j) - '0';
                if (grid[i][j] == FILLED) {
                    if (i > 0 && j > 0) {
                        grid[i][j] = Math.min(Math.min(grid[i-1][j], grid[i][j-1]), grid[i-1][j-1]) + 1;
                    }
                    maxSquareSize = Math.max(maxSquareSize, grid[i][j]);
                }
            }
        }

        System.out.println(maxSquareSize * maxSquareSize);
    }
}
