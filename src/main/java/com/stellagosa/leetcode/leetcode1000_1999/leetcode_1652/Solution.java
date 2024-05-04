package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1652;

/**
 * @author Stellagosa
 * @description 拆炸弹
 * @date 2024/5/5 7:17 星期日
 */
public class Solution {

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if (k == 0) return res;

        int sum = 0;
        if (k > 0) {
            for (int i = 0; i < k; i++) {
                sum += code[i];
            }
            for (int i = 0; i < n; i++) {
                sum -= code[i];
                sum += code[(i + k) % n];
                res[i] = sum;
            }
        } else {
            for (int i = n + k; i < n; i++) {
                sum += code[i];
            }
            for (int i = 0; i < n; i++) {
                res[i] = sum;
                sum += code[i];
                sum -= code[(n + k + i) % n];
            }
        }
        return res;
    }

}
