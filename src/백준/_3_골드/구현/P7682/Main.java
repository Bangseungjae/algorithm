package 백준._3_골드.구현.P7682;

import java.io.*;

public class Main {
    static String INVALID = "invalid\n";
    static String VALID = "valid\n";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        while (!str.equals("end")) {
            char[] board = str.toCharArray();

            int xCount = 0;
            int oCount = 0;
            boolean oWin = false;
            boolean xWin = false;
            for (int i = 0; i < 9; i++) {
                if (board[i] == 'O') {
                    oCount++;
                } else if(board[i] == 'X') {
                    xCount++;
                }
            }

            // X와 O 유효성 검사
            if (xCount != oCount && xCount != oCount + 1) {
                str = br.readLine();
                sb.append(INVALID);
                continue;
            }

            // 가로로 맞는지 check
            for (int i = 0; i < 3; i++) {
                if (board[i * 3] == board[(i * 3) + 1] &&
                        board[(i * 3) + 1] == board[(i * 3) + 2] &&
                        board[i * 3] != '.') {
                    if (board[i * 3] == 'O') oWin = true;
                    if (board[i * 3] == 'X') xWin = true;
                }
            }

            // 세로로 check
            for (int i = 0; i < 3; i++) {
                if (board[i] == board[i + 3] &&
                        board[i] == board[i + 6] &&
                        board[i] != '.') {
                    if (board[i] == 'O') oWin = true;
                    if (board[i] == 'X') xWin = true;
                }
            }

            if (board[0] == board[4] && board[4] == board[8]) {
                if (board[0] == 'O') oWin = true;
                if (board[0] == 'X') xWin = true;
            }

            if (board[2] == board[4] && board[4] == board[6]) {
                if (board[2] == 'O') oWin = true;
                if (board[2] == 'X') xWin = true;
            }

            // 둘다 이긴경우
            // x가 이긴 경우
            // o가 이긴 경우
            // 둘다 못이긴 경우
            if (xWin && oWin) {
                sb.append(INVALID);
            } else if (xWin && xCount != oCount + 1) {
                sb.append(INVALID);
            } else if (oWin && xCount != oCount) {
                sb.append(INVALID);
            } else if (!oWin && !xWin && xCount + oCount != 9) {
                sb.append(INVALID);
            } else {
                sb.append(VALID);
            }

            str = br.readLine();
        }
        System.out.println(sb);
    }
}
