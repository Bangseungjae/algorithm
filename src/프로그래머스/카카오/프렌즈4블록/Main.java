package 프로그래머스.카카오.프렌즈4블록;

public class Main {
    public static void main(String[] args) {
        String[] strings = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        int solution = new Solution().solution(4, 5, strings);
        System.out.println(solution);
    }
}

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            int cnt = checkBlock(m, n, map);
            if (cnt == 0) break;
            answer += cnt;

            dropBlock(m, n, map);
        }
        return answer;
    }

    private void dropBlock(int m, int n, char[][] map) {
        for (int c = 0; c < n; c++) {
            for (int r = m - 1; r >= 0; r--) {
                if (map[r][c] == '.') {
                    for (int nr = r - 1; nr >= 0; nr--) {
                        if (map[nr][c] != '.') {
                            map[r][c] = map[nr][c];
                            map[nr][c] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    private int checkBlock(int m, int n, char[][] map) {
        int cnt = 0;
        boolean[][] isCheck = new boolean[m][n];

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (map[i][j] == '.') continue;
                checkFour(map, isCheck, i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isCheck[i][j]) {
                    cnt++;
                    map[i][j] = '.';
                }
            }
        }
        return cnt;
    }

    private void checkFour(char[][] map, boolean[][] isCheck, int i, int j) {
        char block = map[i][j];
        for (int r = i; r < i + 2; r++) {
            for (int c = j; c < j + 2; c++) {
                if (map[r][c] != block) return;
            }
        }
        for (int r = i; r < i + 2; r++) {
            for (int c = j; c < j + 2; c++) {
                isCheck[r][c] = true;
            }
        }
    }
}
