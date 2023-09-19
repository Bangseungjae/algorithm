package 프로그래머스.완전탐색.카펫;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42842
 */

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(int brown, int yellow) {
        for (int width = 3; width <= 5000; width++) {
            for (int height = 3; height <= width; height++) {
                // 조건 검사
                int boundary = (width + height - 2) * 2;
                int center = width * height - boundary;
                if (brown == boundary && yellow == center) {
                    return new int[]{width, height};
                }
            }
        }
        return null;
    }
}
/**
 * 갈색 격자 수 = (width + height - 2) x 2
 * 카펫의 총 개수 = width x height
 * width x height - (width + height - 2) x 2 = 노란색 격자 수
 */
