package com.stellagosa.lcp.lcp_06;

/**
 * @author Stellagosa
 * @description 拿硬币
 * @date 2023/9/20 7:35 星期三
 */
public class Solution {

    public int minCount(int[] coins) {
        int count = 0;
        for (int coin : coins) {
            count += (coin + 1) >> 1;
        }
        return count;
    }


}
