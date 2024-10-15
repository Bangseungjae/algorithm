package 프로그래머스.devs.exam1;

public class Main {
    public static void main(String[] args) {

    }
}
// 7 분
class Solution {
    private static final int[] SCORE = {100, 50, 5, 1}; // 0 ~ 3
    public int solution(int score) {
        int answer = 0;
        for (int i = 0; i < SCORE.length; i++) {
            answer += score / SCORE[i];
            score = score % SCORE[i];
        }
        return answer;
    }
}
