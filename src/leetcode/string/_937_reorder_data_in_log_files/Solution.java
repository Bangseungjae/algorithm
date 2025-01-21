package leetcode.string._937_reorder_data_in_log_files;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterList =  new ArrayList<>();
        List<String> digitList = new ArrayList<>();

        for (String log : logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                digitList.add(log);
            }else {
                letterList.add(log);
            }
        }

        letterList.sort((s1, s2) -> {
            String[] s1x = s1.split(" ", 2);
            String[] s2x = s2.split(" ", 2);

            // 문자 로그 사전순 비교
            int compared = s1x[1].compareTo(s2x[1]);
            if (compared == 0) {
                return s1x[0].compareTo(s2x[0]);
            } else {
                return compared;
            }
        });

        // 문자 리스트 뒤로 숫자 리스트를 이어 붙인다.
        // 숫자 로그는 '입력 순서대로' 라는 제약 조건이 있으므로 따로 정렬하지 않는다.
        letterList.addAll(digitList);
        return letterList.toArray(new String[letterList.size()]);
    }
}