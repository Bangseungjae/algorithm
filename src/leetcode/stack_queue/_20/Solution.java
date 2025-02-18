package leetcode.stack_queue._20;

/*
(, {, [
 */

import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>(){{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty() || map.get(s.charAt(i)) != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
