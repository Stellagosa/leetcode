package com.stellagosa.leetcode.leetcode100_999.leetcode_374;

/**
 * @Author: Stellagosa
 * @Date: 2022/5/20 15:40
 * @Description:
 */
public class Solution {

    private int pick;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.pick = 1702766719;
        System.out.println(solution.guessNumber(2126753390));
    }

    public int guessNumber(int n) {
        int left = 0, right = n;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (guess(mid) == 0) return mid;
            else if (guess(mid) == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int guess(int num) {
        return this.pick < num ? -1 : this.pick > num ? 1 : 0;
    }
}
