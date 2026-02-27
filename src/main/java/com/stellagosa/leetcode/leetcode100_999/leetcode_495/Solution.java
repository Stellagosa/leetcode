package com.stellagosa.leetcode.leetcode100_999.leetcode_495;

/**
 * @author Stellagosa
 * @description 提莫攻击
 * @date 2026/2/27 18:53 星期五
 */
public class Solution {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            res += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
        }
        return res + duration;
    }


    // 在实际应用中并不好，实际中时间是流式的，你不能每次都从后往前推算
//    public int findPoisonedDuration(int[] timeSeries, int duration) {
//        int res = 0;
//        for (int i = timeSeries.length - 1; i >= 0; i--) {
//            // 最后一次肯定满时间
//            if (i == timeSeries.length - 1) {
//                res += duration;
//            } else {
//                res += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
//            }
//        }
//        return res;
//    }

}
