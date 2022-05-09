package com.stellagosa.leetcode.leetcode100_999.leetcode_942;

import java.util.Arrays;

/**
 * @Author: Stellagosa
 * @Date: 2022/5/9 8:54
 * @Description: 增减字符串
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "IDID";
        System.out.println(Arrays.toString(solution.diStringMatch(str)));
    }

    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] arr = new int[n + 1];
        int p = n;
        int q = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                arr[i] = q;
                q++;
            } else {
                arr[i] = p;
                p--;
            }
        }
        arr[n] = p;
        return arr;
    }

}
