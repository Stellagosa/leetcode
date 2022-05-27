package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1021;

import javax.swing.plaf.DesktopIconUI;
import java.util.Deque;
import java.util.IdentityHashMap;
import java.util.LinkedList;

/**
 * @Author: Stellagosa
 * @Date: 2022/5/28 6:50
 * @Description: 删除最外层的括号
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeOuterParentheses("(()())(())"));
    }

    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                count--;
            }
            if (count != 0) {
                builder.append(ch);
            }
            if (ch == '(') {
                count++;
            }
        }
        return builder.toString();
    }


    // public String removeOuterParentheses(String s) {
    //     Deque<Character> deque = new LinkedList<>();
    //     StringBuilder builder = new StringBuilder();
    //     for (int i = 0; i < s.length(); i++) {
    //         char ch = s.charAt(i);
    //         if (ch == ')') {
    //             deque.pop();
    //         }
    //         if (!deque.isEmpty()) {
    //             builder.append(ch);
    //         }
    //         if (ch == '(') {
    //             deque.push(ch);
    //         }
    //     }
    //     return builder.toString();
    // }

    // public String removeOuterParentheses(String s) {
    //     Deque<Character> deque = new LinkedList<>();
    //     StringBuilder builder = new StringBuilder();
    //     int pre = 0;
    //     for (int i = 0; i < s.length(); i++) {
    //         if (s.charAt(i) == '(') {
    //             deque.push('(');
    //         } else {
    //             deque.pop();
    //         }
    //         if (deque.isEmpty()) {
    //             builder.append(s.substring(pre + 1, i));
    //             pre = i + 1;
    //         }
    //     }
    //     return builder.toString();
    // }
}
