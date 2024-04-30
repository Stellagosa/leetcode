package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2798;

/**
 * @author Stellagosa
 * @description 满足目标工作时长的员工数目
 * @date 2024/4/30 13:40 星期二
 */
public class Solution {

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        // return Arrays.stream(hours).filter(hour -> hour >= target).toArray().length;
        int res = 0;
        for (int hour : hours) {
            res += hour >= target ? 1 : 0;
        }
        return res;
    }

}
