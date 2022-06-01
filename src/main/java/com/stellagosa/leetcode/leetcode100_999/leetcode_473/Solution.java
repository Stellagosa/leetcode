package com.stellagosa.leetcode.leetcode100_999.leetcode_473;

import java.util.*;

/**
 * @Author: Stellagosa
 * @Date: 2022/6/1 6:22
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] matchsticks = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 102};
        System.out.println(solution.makesquare(matchsticks));
    }

    public boolean makesquare(int[] matchsticks) {
        int count = 0;
        for (int matchstick : matchsticks) {
            count += matchstick;
        }
        if (count % 4 != 0) return false;
        int sideLength = count / 4;
        Arrays.sort(matchsticks);
        if (matchsticks[matchsticks.length - 1] > sideLength) return false;
        return dfs(matchsticks, new int[4], sideLength, matchsticks.length - 1);
    }

    private boolean dfs(int[] matchsticks, int[] arr, int target, int index) {
        if (index == -1) return true;
        for (int i = 0; i < 4; i++) {
            if (arr[i] + matchsticks[index] > target) continue;
            arr[i] += matchsticks[index];
            if (dfs(matchsticks, arr, target, index - 1)) return true;
            arr[i] -= matchsticks[index];
        }
        return false;
    }
}
