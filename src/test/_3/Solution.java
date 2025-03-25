package test._3;

class Solution {
    private final int BOARD_SIZE = 19;
    public int[] solution(int[][] B, int[][] W) {
        boolean[][] black = new boolean[BOARD_SIZE + 1][BOARD_SIZE + 1];
        boolean[][] white = new boolean[BOARD_SIZE + 1][BOARD_SIZE + 1];

        for (int[] b : B) {
            black[b[0]][b[1]] = true;
        }
        for (int[] w : W) {
            white[w[0]][w[1]] = true;
        }

        for (int x = 1; x <= BOARD_SIZE; x++) {
            for (int y = 1; y <= BOARD_SIZE; y++) {
                if (!black[x][y] && white[x][y]) {
                    black[x][y] = true;
                    if (checkWin(black)) {
                        return new int[]{x, y};
                    }
                    black[x][y] = false;
                }
            }
        }

        return new int[]{-1, -1};
    }

    private boolean checkWin(boolean[][] board) {
        int[] dx = {0, 1, 1, 1};
        int[] dy = {1, 0, 1, -1};

        for (int x = 1; x <= BOARD_SIZE; x++) {
            for (int y = 1; y <= BOARD_SIZE; y++) {
                if (!board[x][y]) {
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int count = 1;
                    count += countStones(board, x, y, dx[i], dy[i]);
                    count += countStones(board, x, y, -dx[i], -dy[i]);

                    if (count == 5) {
                        int[] end1 = getEndPoint(board, x, y, dx[i], dy[i]);
                        int end1NextX = end1[0] + dx[i];
                        int end1NextY = end1[1] + dy[i];

                        int[] end2 = getEndPoint(board, x, y, -dx[i], -dy[i]);
                        int end2NextX = end2[0] - dx[i];
                        int end2NextY = end2[1] - dy[i];

                        if (isValid(end1NextX, end1NextY) && board[end1NextX][end1NextY]) {
                            continue;
                        }
                        if (isValid(end2NextX, end2NextY) && board[end2NextX][end2NextY]) {
                            continue;
                        }
                        return true;
                    }
                }
            }
        }
        return false;

    }

    private int countStones(boolean[][] board, int x, int y, int dx, int dy) {
        int nx = x + dx;
        int ny = y + dy;
        int count = 0;

        while (isValid(nx, ny) && board[nx][ny]) {
            count++;
            nx += dx;
            ny += dy;
        }
        return count;
    }

    private int[] getEndPoint(boolean[][] board, int x, int y, int dx, int dy) {
        int nx = x;
        int ny = y;

        while (isValid(nx + dx, ny + dy) && board[nx + dx][ny + dy]) {
            nx += dx;
            ny += dy;
        }
        return new int[]{nx, ny};
    }

    private boolean isValid(int x, int y) {
        return x >= 1 && x <= BOARD_SIZE && y >= 1 && y <= BOARD_SIZE;
    }
}