package com.stellagosa.leetcode.leetcode1_99.leetcode_20;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * @author Stellagosa
 * @description 20.有效的括号
 * @date 10/1/2026 8:01 PM Thursday
 */
public class Solution1 {

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character,Character> map = Map.of(')','(',']','[','}','{');
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                if (stack.pop() != map.get(ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
