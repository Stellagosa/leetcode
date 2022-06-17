package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1089;

/**
 * @Author: Stellagosa
 * @Date: 2022/6/17 6:49
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {8, 4, 5, 0, 0, 0, 0, 7};
        // int[] arr = {0, 1, 7, 6, 0, 2, 0, 7};
        solution.duplicateZeros(arr);
        for (int item : arr) {
            System.out.println(item);
        }
    }

    public void duplicateZeros(int[] arr) {
        int zeroCount = 0;
        for (int item : arr) {
            zeroCount += item == 0 ? 1 : 0;
        }
        if (zeroCount == 0) return;

        int pre = arr.length - 1, cur = arr.length - 1;

        while (pre >= 0 && cur >= 0) {
            if (arr[pre] == 0) {
                if (zeroCount > 0) {
                    zeroCount -= 2;
                    if (zeroCount == -1) {
                        arr[cur] = arr[pre];
                        cur--;
                    }
                    pre--;
                } else {
                    arr[cur] = arr[pre];
                    arr[cur - 1] = arr[pre];
                    cur -= 2;
                    pre--;
                }
            } else {
                if (zeroCount <= 0) {
                    arr[cur] = arr[pre];
                    cur--;
                    pre--;
                } else {
                    pre--;
                    zeroCount--;
                }
            }
            if (cur == pre) break;
        }
    }
}

// 8,4,5,0,0,  0,0,  0, 0,  0,0, 7