package 프로그래머스.시저_암호;

/**
 * 문자열 문제
 * https://school.programmers.co.kr/learn/courses/30/lessons/12926
 */
class Solution {
    private char push(char c, int n) {
        if (!Character.isAlphabetic(c)) return c;

        // c를 n만큼 밀어서 반환
        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;
        position = (position + n) % ('Z' - 'A' + 1);
        return (char) (offset + position);
    }

    public String solution(String s, int n) {
        String answer = "";

        StringBuilder builder = new StringBuilder();
        for(char c : s.toCharArray()) {
            builder.append(push(c, n));
        }
        answer = builder.toString();
        return answer;
    }
}
