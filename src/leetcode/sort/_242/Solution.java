package leetcode.sort._242;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return sArr.toString().equals(tArr.toString());
    }
}
