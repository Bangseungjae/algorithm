package leetcode.sort._179;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        int i = 1;
        while (i < nums.length) {
            int j = i;
            while (j > 0 && toSwap(nums[j - 1], nums[j])) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                j--;
            }
            i++;
        }
        return Arrays.toString(nums).replaceAll("\\[|\\]|,|\\s", "");
    }
    private boolean toSwap(int n1, int n2) {
        if (n1 > 10000000 && n2 > 10000000) {
            String n1Str = String.valueOf(n1);
            String n2Str = String.valueOf(n2);
            int len = Math.min(n1Str.length(), n2Str.length());
            for (int i = 0; i < len; i++) {
                if (n1Str.charAt(i) < n2Str.charAt(i)) {
                    return true;
                } else if (n1Str.charAt(i) > n2Str.charAt(i)) {
                    return false;
                }
            }
            return n1Str.length() < n2Str.length();
        }
        return Long.parseLong(String.valueOf(n1) + n2) < Long.parseLong(String.valueOf(n2) + n1);
    }

    public static void main(String[] args) {

    }
}
