package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1450;

/**
 * @Author: Stellagosa
 * @Date: 2022/8/19 8:03
 * @Description: 在既定时间做作业的学生人数
 */
public class Solution {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        int n = startTime.length;
        for (int i = 0; i < n; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                res++;
            }
        }
        return res;
    }

}
