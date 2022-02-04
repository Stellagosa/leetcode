package com.stellagosa.leetcode.leetcode100_999.leetcode_390;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/2 16:57
 * @Description: 消除游戏
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lastRemaining(9));
    }

    public int lastRemaining(int n) {
        // 消除一次，步长翻倍
        // 如果个数为奇数个，则不论从做到右还是从右到左，剩下的第一个数都会变
        // 如果是偶数个，只有从左到右会消除第一个数
        // 没消除一次，剩下 n/2 个数
        // 只记录第一个数的位置就可以了，剩下的数可以通过加步长确定
        int firstNumIndex = 0;
        int step = 1;
        boolean isLeftToRight = true;
        while (n > 1) {
            if (isLeftToRight || n % 2 == 1) {
                firstNumIndex = firstNumIndex + step;
            }
            n /= 2;
            step *= 2;
            isLeftToRight = !isLeftToRight;
        }
        return firstNumIndex + 1;
    }
}
