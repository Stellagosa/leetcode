package com.stellagosa.leetcode.leetcode100_999.leetcode_646;

import java.util.Arrays;

/**
 * @Author: Stellagosa
 * @Date: 2022/9/3 8:42
 * @Description: 最长数对链
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(solution.findLongestChain(pairs));
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2) -> o1[1] - o2[1]);
        int pre = 0;
        int len = 1;
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[pre][1] < pairs[i][0]) {
                len++;
                pre = i;
            }
        }
        return len;
    }

}
