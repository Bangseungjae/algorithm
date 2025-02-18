package leetcode.stack_queue._316;

import java.util.Set;
import java.util.TreeSet;

/*
bcabc
cbacdcbc - acdb
acdcbc -> 1
bc
cdcbc -> c
db

 */
class SolutionV1 {
    public String removeDuplicateLetters(String s) {
        // 정렬된 문자열 집합 순회
        for (char c : toSortedSet(s)) {
            //해당 문자가 포함된 위치부터 접미사로 지정
            String suffix = s.substring(s.indexOf(c));
            //전체 집합과 접미사 집합이 일치하면 해당 문자 정답에 추가하고 재귀 호출 진행
            if (toSortedSet(s).equals(toSortedSet(suffix))) {
                return c + removeDuplicateLetters(suffix.replace(String.valueOf(c), ""));
            }
        }
        return "";
    }

    private Set<Character> toSortedSet(String s) {
        // 문자열을 단위 집합으로 저장할 변수 선언
        Set<Character> set = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set;
    }
}
