package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1840;

import java.util.Arrays;

/**
 * @author Stellagosa
 * @description 最高建筑高度
 * @date 6/20/2026 6:54 AM June
 */
public class Solution {

    public int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;
        if (m == 0) return n-1;
        Arrays.sort(restrictions, ((o1, o2) -> o1[0] - o2[0]));
        int[] h = new int[m];
        h[0] = Math.min(restrictions[0][0] - 1, restrictions[0][1]);
        for (int i = 1; i < m; i++) {
            h[i] = Math.min(restrictions[i][1], h[i - 1] + restrictions[i][0] - restrictions[i-1][0]);
        }

        for (int i = m - 2; i >= 0; i--) {
            h[i] = Math.min(h[i], h[i + 1] + restrictions[i + 1][0] - restrictions[i][0]);
        }

        // 0-1, (n-2)-(n-1)
        int max = Math.max((restrictions[0][0] - 1 + h[0]) / 2, h[m-1] + n - restrictions[m-1][0]);
        for (int i = 0; i < m - 1; i++) {
            max = Math.max(max, (h[i] + h[i+1] + restrictions[i+1][0] - restrictions[i][0]) / 2);
        }
        return max;
    }



    // public int maxBuilding(int n, int[][] restrictions) {
    //     if (restrictions.length == 0) return n - 1;
    //     Arrays.sort(restrictions, ((o1, o2) -> o1[0] - o2[0]));
    //     int pre = 0, loc = 0;
    //     for (int[] restriction : restrictions) {
    //         restriction[1] = Math.min(restriction[1], pre + restriction[0] - 1 - loc);
    //         pre = restriction[1];
    //         loc = restriction[0];
    //     }
    //     pre = n - 1;
    //     loc = n - 1;
    //     for (int i = restrictions.length - 1; i >= 0; i--) {
    //         restrictions[i][1] = Math.min(restrictions[i][1], pre + loc - (i - 1));
    //         pre = restrictions[i][1];
    //         loc = restrictions[i][0];
    //     }
    //
    //     int max = Integer.MIN_VALUE;
    //     pre = 0;
    //     loc = 0;
    //     for (int[] restriction : restrictions) {
    //         max = Math.max(max, restriction[0] + restriction[1] + pre - loc);
    //         pre = restriction[1];
    //         loc = restriction[0];
    //     }
    //     if (restrictions[restrictions.length - 1][0] != n) {
    //         max = Math.max(max, n - restrictions[restrictions.length - 1][0] + restrictions[restrictions.length - 1][1] + n - 1);
    //     }
    //     return  max;
    // }
}
