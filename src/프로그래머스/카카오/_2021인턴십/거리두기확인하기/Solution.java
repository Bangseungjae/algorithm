package 프로그래머스.카카오._2021인턴십.거리두기확인하기;

class Solution {
    int[] caseX1 = {0,0,-1,1};
    int[] caseY1 = {-1,1,0,0};
    int[] caseX2 = {0,0,-2,2}; // partition 확인
    int[] caseY2 = {-2,2,0,0};
    int[] caseX3 = {-1,-1,1,1};
    int[] caseY3 = {-1,1,-1,1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            char[][] chars = new char[5][5];
            int rs = 1;
            for (int j = 0; j < 5; j++) {
                char[] charArray = places[i][j].toCharArray();
                for (int k = 0; k < 5; k++) {
                    chars[j][k] = charArray[k];
                }
            }

            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 5; y++) {
                    for (int j = 0; j < 4; j++) {
                        if (x + caseX1[j] >= 0 && x + caseX1[j] < 5 &&
                                y + caseY1[j] >= 0 && y + caseY1[j] < 5 &&
                                chars[x][y] == 'P' && chars[x + caseX1[j]][y + caseY1[j]] == 'P') {
                            rs = 0;
                        }
                        if (x + caseX2[j] >= 0 && x + caseX2[j] < 5 &&
                                y + caseY2[j] >= 0 && y + caseY2[j] < 5 &&
                                chars[x][y] == 'P' &&
                                chars[x + caseX2[j]][y + caseY2[j]] == 'P' &&
                                chars[x + caseX1[j]][y + caseY1[j]] != 'X') {
                            rs = 0;
                        }
                        if (x + caseX3[j] >= 0 && x + caseX3[j] < 5 &&
                                y + caseY3[j] >= 0 && y + caseY3[j] < 5 &&
                                chars[x][y] == 'P' && chars[x + caseX3[j]][y + caseY3[j]] == 'P' &&
                                !(chars[x + caseX3[j]][y] == 'X' && chars[x][y + caseY3[j]] == 'X')) {
                            rs = 0;
                        }
                    }
                }
                if (rs == 0) {
                    break;
                }
            }
            answer[i] = rs;
        }
        return answer;
    }
}

