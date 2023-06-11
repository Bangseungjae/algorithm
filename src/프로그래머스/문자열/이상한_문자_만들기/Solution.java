package 프로그래머스.문자열.이상한_문자_만들기;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        String try_hello_world = solution.solution("try hello world");
        System.out.println("=====================");
        System.out.println(try_hello_world);
    }

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean toUpper = true;

        for (char c : s.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                sb.append(c);
                toUpper = true;
            } else {
                if (toUpper) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                toUpper = !toUpper;
            }
        }
        return sb.toString();
    }
}
