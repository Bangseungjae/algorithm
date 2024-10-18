package 프로그래머스.lv2.혼자서하는틱텍토;

class Solution {
    static final char first = 'O';
    static final char second = 'X';
    public int solution(String[] board) {
        int answer = 1;

        boolean isFirstWin = isWin(board, first);
        boolean isSecondWin = isWin(board, second);
        int firstCnt = 0;
        int secondCnt = 0;
        for (String b : board) {
            for (char ch : b.toCharArray()) {
                if (ch == first) {
                    firstCnt++;
                } else if (ch == second) {
                    secondCnt++;
                }
            }
        }

        if (isFirstWin && !isSecondWin) {
            if (firstCnt - secondCnt != 1) {
                return 0;
            }
        }else if (!isFirstWin && isSecondWin) {
            if (firstCnt - secondCnt != 0) {
                return 0;
            }
        } else if (isFirstWin && isSecondWin) {
            return 0;
        } else { // 아무도 안이김
            int cnt = firstCnt - secondCnt;
            if (cnt !=0 && cnt != 1) {
                return 0;
            }
        }


        return answer;
    }

    private boolean isWin(String[] board, char ch) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == ch && board[i].charAt(1) == ch && board[i].charAt(2) == ch) {
                return true;
            }
            if (board[0].charAt(i) == ch && board[1].charAt(i) == ch && board[2].charAt(i) == ch) {
                return true;
            }
        }

        if (board[0].charAt(0) == ch && board[1].charAt(1) == ch && board[2].charAt(2) == ch) {
            return true;
        }
        return board[0].charAt(2) == ch && board[1].charAt(1) == ch && board[2].charAt(0) == ch;
    }
}

/*
선공의 성공 조건인데 선공이 후공보다 하나 더 많은개 아니라면 -> 0
아무도 성공 못했는데 X.length == O.length or X.length == O.lengt-1 이 아니라면 -> 0
후공이 성공 조건인데 후공의 개수 == 선공의 개수가 아니라면 -> 0
둘다 이긴경우 -> 0
*/
