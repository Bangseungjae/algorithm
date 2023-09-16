package 프로그래머스.재귀.모음사전;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 */
public class Main {

    public static void main(String[] args) {
        int index = new Solution().solution("I");
        System.out.println(index);
    }
}

class Solution {
    private static final char[] CHARS = "AEIOU".toCharArray();
    public int solution(String word) {
        List<String> words = new ArrayList<>();
        generate("", words);
        return words.indexOf(word);
    }

    private List<String> generate(String word, List<String> words) {
        // 종료 조건, 점화식 구현

        // 종료식
        words.add(word);
        if (word.length() == 5) return words;

        // 점화식 구현
        for (char c : CHARS) {
            generate(word + c, words);
        }
        return words;
    }
}
