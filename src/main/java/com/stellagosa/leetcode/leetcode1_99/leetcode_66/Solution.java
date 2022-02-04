package com.stellagosa.leetcode.leetcode1_99.leetcode_66;

/**
 * @Author: Stellagosa
 * @Date: 2022/2/3 21:52
 * @Description: 加一
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0};
        int[] res = solution.plusOne(arr);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public int[] plusOne(int[] digits) {
        // 全是9，结果长度加1，否则还是原长度
        for (int num : digits) {
            if (num != 9) {
                return originalLenght(digits);
            }
        }
        return lengthPlusOne(digits);
    }

    private int[] originalLenght(int[] digits) {
        // 还是原长度
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                break;
            }
        }
        return digits;
    }

    private int[] lengthPlusOne(int[] digits) {
        // 全是9,1开头，全是0
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
