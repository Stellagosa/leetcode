package com.stellagosa.leetcode.leetcode100_999.leetcode_735;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Stellagosa
 * @Date: 2022/7/13 6:14
 * @Description: 行星碰撞
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] asteroids = {10, 2, -5, -15, 5};
        int[] res = solution.asteroidCollision(asteroids);
        for (int item : res) {
            System.out.println(item);
        }
    }

    // deque 比 stack 快的多
    public int[] asteroidCollision(int[] asteroids) {

        Deque<Integer> deque = new LinkedList<>();

        for (int asteroid : asteroids) {
            boolean flag = false;
            while (!deque.isEmpty() && deque.peek() > 0 && asteroid < 0) {
                if (deque.peek() > -asteroid) {
                    flag = true;
                    break;
                } else if (deque.peek() == -asteroid){
                    flag = true;
                    deque.pop();
                    break;
                } else {
                    deque.pop();
                }
            }
            if (!flag) {
                deque.push(asteroid);
            }
        }

        int[] res = new int[deque.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = deque.pop();
        }
        return res;
    }
}
