package leetcode.string._344_reverse_string;

class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        char temp;
        while (start < end) {
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
        return;
    }
}
