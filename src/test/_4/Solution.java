package test._4;

class Solution {
    private final int BOARD_SIZE = 19;

    public String[] solution(int[][] B, int[][] W) {
        // 1) 바둑판 초기화
        boolean[][] black = new boolean[BOARD_SIZE + 1][BOARD_SIZE + 1];
        boolean[][] white = new boolean[BOARD_SIZE + 1][BOARD_SIZE + 1];

        // 2) Black/White 돌을 시간 순서대로 둔다.
        //    - Black은 B 배열 순서대로
        //    - White는 W 배열 순서대로
        //    - White가 이기면 보드 리셋
        //    - Black이 이기면 그 시점의 보드 상태를 문자열 배열로 만들어 반환
        int maxMoves = Math.max(B.length, W.length);
        int iB = 0, iW = 0;

        for (int i = 0; i < maxMoves; i++) {
            // 흑돌 놓기
            if (iB < B.length) {
                int x = B[iB][0];
                int y = B[iB][1];
                black[x][y] = true;
                iB++;

                // 흑이 이겼으면 최종 보드 상태 반환
                if (checkWin(black)) {
                    return buildBoard(black, white);
                }
            }

            // 백돌 놓기
            if (iW < W.length) {
                int x = W[iW][0];
                int y = W[iW][1];
                white[x][y] = true;
                iW++;

                // 백이 이겼으면 보드 리셋
                if (checkWin(white)) {
                    black = new boolean[BOARD_SIZE + 1][BOARD_SIZE + 1];
                    white = new boolean[BOARD_SIZE + 1][BOARD_SIZE + 1];
                }
            }
        }

        // 여기까지 왔다면 결국 흑이 이기지 못함
        return new String[0];
    }

    private boolean checkWin(boolean[][] board) {
        int[] dx = {0, 1, 1, 1};
        int[] dy = {1, 0, 1, -1};

        for (int x = 1; x <= BOARD_SIZE; x++) {
            for (int y = 1; y <= BOARD_SIZE; y++) {
                if (!board[x][y]) continue;
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

    // 흑돌이 이겼을 때의 보드 상태를 문자열 배열로 만드는 메서드
    private String[] buildBoard(boolean[][] black, boolean[][] white) {
        String[] result = new String[BOARD_SIZE];
        for (int x = 1; x <= BOARD_SIZE; x++) {
            StringBuilder sb = new StringBuilder();
            for (int y = 1; y <= BOARD_SIZE; y++) {
                if (black[x][y]) {
                    sb.append('B');
                } else if (white[x][y]) {
                    sb.append('W');
                } else {
                    sb.append('E');
                }
            }
            result[x - 1] = sb.toString();
        }
        return result;
    }
}