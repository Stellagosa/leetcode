package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1217;

/**
 * @Author: Stellagosa
 * @Date: 2022/7/8 6:21
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] position = {2, 2, 2, 3, 3};
        System.out.println(solution.minCostToMoveChips(position));
    }

    // 假设目标位置为k，则全部筹码都可以通过每次移动两步到k或者k-1的位置，花费为0
    // k和k-1位置最少的就是移动总花费
    // 再换句话说就是，偶数位置或奇数位置的总筹码，较少的就是总花费
    public int minCostToMoveChips(int[] position) {
        int sum = 0;
        for (int pos : position) {
            sum += pos % 2 == 0 ? 0 : 1;
        }
        return Math.min(sum, position.length - sum);
    }
}
