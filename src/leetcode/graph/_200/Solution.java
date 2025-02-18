package leetcode.graph._200;

class Solution {
    private static final int[] X = {1, -1, 0, 0};
    private static final int[] Y = {0, 0, 1, -1};
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }
    private void dfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int nX = x + X[i];
            int nY = y + Y[i];
            if (nX < 0 || nX >= grid.length || nY < 0 || nY >= grid[0].length || grid[nX][nY] == '0') {
                continue;
            }

            if (grid[nX][nY] == '1') {
                dfs(grid, nX, nY);
            }
        }
    }
}

