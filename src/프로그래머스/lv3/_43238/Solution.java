package 프로그래머스.lv3._43238;

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        long left = 0;
        long right = (long) Arrays.stream(times).max().getAsInt() * n;
        long mid = right;

        while (left <= right) {
            long calcN = 0;
            for (long time : times) {
                calcN += mid / time;
            }
            if (calcN >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
        }
        return answer;
    }
}
