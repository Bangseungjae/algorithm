package 프로그래머스.우테캠._1;

public class Main {
    public static void main(String[] args) {
        int[] boxes = {1000, 800, 900};
        int m = 1_000_000;
        int k = 3;

        Solution solution = new Solution();
        int solution1 = solution.solution(boxes, m, k);
        System.out.println(solution1);

    }
}

class Solution {
    public int solution(int[] boxes, int m, int k) {
        int answer = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            for (int box : boxes) {
                int x = m / 10_000;
                int plus = box * x;
                if (plus <= 100_000 && max < plus) {
                    max = plus;
                }
            }
            m += max;
            max = 0;
        }
        answer = m;
        return answer;
    }
}
