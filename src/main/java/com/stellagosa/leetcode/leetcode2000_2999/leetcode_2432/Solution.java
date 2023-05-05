package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2432;

/**
 * @Author: Stellagosa
 * @Date: 2023/5/5 8:18
 * @Description: 处理用时最长的那个任务的员工
 */
public class Solution {

    public int hardestWorker(int n, int[][] logs) {
        int longestTask = logs[0][1];
        int longestTaskWorkerId = logs[0][0];

        for (int i = 1; i < logs.length; i++) {
            if (logs[i][1] - logs[i - 1][1] > longestTask) {
                longestTaskWorkerId = logs[i][0];
                longestTask = logs[i][1] - logs[i - 1][1];
            }
            if (logs[i][1] - logs[i - 1][1] == longestTask) {
                longestTaskWorkerId = Math.min(longestTaskWorkerId, logs[i][0]);
            }
        }
        return longestTaskWorkerId;
    }

}
