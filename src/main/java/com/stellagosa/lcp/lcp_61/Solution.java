package com.stellagosa.lcp.lcp_61;

/**
 * @author Stellagosa
 * @description 气温变化趋势
 * @date 2024/6/21 8:33 星期五
 */
public class Solution {

    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int n = temperatureA.length;
        int len = 0, maxLen = 0;
        for (int i = 1; i < n; i++) {
            if ((temperatureA[i] - temperatureA[i - 1] > 0 && temperatureB[i] - temperatureB[i - 1] > 0) ||
                    (temperatureA[i] - temperatureA[i - 1] < 0 && temperatureB[i] - temperatureB[i - 1] < 0) ||
                    (temperatureA[i] - temperatureA[i - 1] == 0 && temperatureB[i] - temperatureB[i - 1] == 0)) {
                len++;
                maxLen = Math.max(maxLen, len);
            } else {
                len = 0;
            }
        }
        return maxLen;
    }

}
