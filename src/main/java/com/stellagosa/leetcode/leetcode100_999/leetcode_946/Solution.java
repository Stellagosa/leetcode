package com.stellagosa.leetcode.leetcode100_999.leetcode_946;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Stellagosa
 * @Date: 2022/8/31 8:57
 * @Description: 验证栈序列
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        System.out.println(solution.validateStackSequences(pushed, popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque = new LinkedList<>();
        int push_i = 0, pop_i = 0;
        while (true) {
            if (deque.isEmpty()) {
                if (push_i == pushed.length) return true;
                deque.push(pushed[push_i]);
                push_i++;
            } else if (popped[pop_i] == deque.peek()) {
                deque.poll();
                pop_i++;
            } else {
                if (push_i == pushed.length) return false;
                deque.push(pushed[push_i]);
                push_i++;
            }
        }
    }
}
