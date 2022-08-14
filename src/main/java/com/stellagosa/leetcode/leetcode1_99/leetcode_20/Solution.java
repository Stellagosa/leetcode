package com.stellagosa.leetcode.leetcode1_99.leetcode_20;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Stellagosa
 * @Date: 2022/8/14 7:59
 * @Description: 有效的括号
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
    }

    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                deque.push(ch);
            } else if (!deque.isEmpty() &&
                    ((ch == ')' && deque.peek() == '(') ||
                            (ch == ']' && deque.peek() == '[') ||
                            (ch == '}' && deque.peek() == '{'))) {
                deque.pop();
            } else {
                return false;
            }
        }
        return deque.isEmpty();
    }

}
