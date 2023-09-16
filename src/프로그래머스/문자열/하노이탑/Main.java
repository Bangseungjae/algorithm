package 프로그래머스.문자열.하노이탑;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12946
 * 재귀 정의
 * 1 상태
 * 2. 종료 조건
 * 3. 점화식
 */
public class Main {

    private static void hanoi(int n, int from, int to, List<int[]> process) {
        // 종료 조건, 점화식 구현
        if (n == 1) {
            process.add(new int[]{from, to});
            return;
        }

        int empty = 6 - from - to;

        hanoi(n - 1, from, empty, process);
        hanoi(1, from, to, process);
        hanoi(n - 1, empty, to, process);
    }
    public static void main(String[] args) {
        System.out.println(solution(3));
    }

    public static int[][] solution(int n) {
        List<int[]> process = new ArrayList<>();
        hanoi(n, 1, 3, process);
        return process.toArray(new int[0][]);
    }

}
