package 프로그래머스.문자열._3진법_뒤집기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/68935?language=java
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(45);
    }

    public int solution(int n) {
        int answer = 0;
        String str = Integer.toString(n, 3);
        StringBuffer bf = new StringBuffer(str).reverse();
        answer = Integer.parseInt(bf.toString(), 3);
        return answer;
    }
}
