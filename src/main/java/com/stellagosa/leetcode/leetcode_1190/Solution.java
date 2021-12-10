package com.stellagosa.leetcode.leetcode_1190;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 22:02
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "(u(love)i)";
        String reverse = solution.reverseParentheses(s);
        System.out.println(reverse);
    }

    public String reverseParentheses(String s) {
        int n = s.length();
        Deque<Integer> deque = new LinkedList<>();
        int[] loc = new int[n];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                deque.push(i);
            } else if (s.charAt(i) == ')') {
                int temp = deque.pop();
                loc[temp] = i;
                loc[i] = temp;
            }
        }

        StringBuilder builder = new StringBuilder();
        int index = 0;
        int step = 1;
        while (index < n) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                index = loc[index];
                step = -step;
            } else {
                builder.append(s.charAt(index));
            }
            index += step;
        }
        return builder.toString();
    }

    // public String reverseParentheses(String s) {
    //     int n = s.length();
    //     char[] res = new char[n];
    //     char[] source = s.toCharArray();
    //
    //     char[] temp = new char[n];
    //     int len = 0; // temp长度
    //
    //     int i = 0; // s下标
    //     int j = 0; // res下标
    //     int k = 0;
    //     while(i < n) {
    //         if(source[i] != ')') {
    //             res[j] = source[i];
    //             i++;
    //             j++;
    //         } else {
    //             k = j - 1;
    //             while(k >= 0 && res[k] != '(') {
    //                 temp[len] = res[k];
    //                 len++;
    //                 k--;
    //             }
    //             int index = 0;
    //             while(index < len) {
    //                 res[k] = temp[index];
    //                 k++;
    //                 index++;
    //             }
    //             len = 0;
    //             i++;
    //             j--;
    //         }
    //     }
    //     return new String(res, 0, j);
    // }
}
