package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2739;

/**
 * @author Stellagosa
 * @description 总行驶距离
 * @date 2024/4/25 8:04 星期四
 */
public class Solution {

    public int distanceTraveled(int mainTank, int additionalTank) {
        return 10 * (mainTank + Math.min((mainTank - 1) / 4, additionalTank));
    }


    // public int distanceTraveled(int mainTank, int additionalTank) {
    //     int distance = 0;
    //     while (mainTank > 0) {
    //         int mod = mainTank % 5;
    //         int div = mainTank / 5;
    //         if (div == 0) break;
    //         distance += 50 * div;
    //         int temp = Math.min(additionalTank, div);
    //         additionalTank -= temp;
    //         mainTank = mod + temp;
    //     }
    //     distance += mainTank * 10;
    //     return distance;
    // }


}
