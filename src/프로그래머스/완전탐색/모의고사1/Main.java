package 프로그래머스.완전탐색.모의고사1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 2};
        Solution solution = new Solution();
        Arrays.stream(solution.solution(arr)).forEach(System.out::println);
    }
}

class Solution {

    private static final int[][] RULES = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5},
    };
    public int[] solution(int[] answers) {
        int[] corrects = new int[3];
        int max = 0;

        for (int problem = 0; problem < answers.length; problem++) {
            int answer = answers[problem];

            for (int person = 0; person < 3; person++) {
                int picked = getPicked(person, problem);
                if (answer == picked) {
                    if (++corrects[person] > max) {
                        max = corrects[person];
                    }
                }
            }
        }
        int finalMax = max;
        return IntStream.range(0, 3)
                .filter(i -> corrects[i] == finalMax)
                .map(i -> i + 1)
                .toArray();
    }

    private int getPicked(int person, int problem) {
        int[] rule = RULES[person];
        int index = problem % rule.length;
        return rule[index];
    }
}
