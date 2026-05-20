package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2657;

/**
 * @author Stellagosa
 * @description 找到两个数组的前缀公共数组
 * @date 5/20/2026 8:27 AM Wednesday
 */
public class Solution {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        boolean[] flag_A = new boolean[n + 1];
        boolean[] flag_B = new boolean[n + 1];
        int[] res = new int[n];
        if (A[0] == B[0]) res[0] = 1;
        flag_A[A[0]] = true;
        flag_B[B[0]] = true;
        for (int i = 1; i < n; i++) {
            flag_A[A[i]] = true;
            flag_B[B[i]] = true;
            res[i] = res[i - 1];
            if (A[i] == B[i]) {
                res[i]++;
            } else {
                if (flag_A[B[i]]) res[i]++;
                if (flag_B[A[i]]) res[i]++;
            }
        }
        return res;
    }

}
