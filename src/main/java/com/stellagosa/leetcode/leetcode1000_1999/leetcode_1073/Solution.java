package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1073;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2023/5/18 10:19
 * @Description: 负二进制数相加
 * <p>
 * 0 -> 不进位
 * 1 -> 不进位
 * 2 -> 进 -1 余 0
 * 3 -> 进 -1 余 1
 * -1 -> 进  1 余 1
 */
public class Solution {

    public int[] addNegabinary(int[] arr1, int[] arr2) {
        List<Integer> res = new ArrayList<>();
        int temp = 0;
        int index1 = arr1.length - 1;
        int index2 = arr2.length - 1;
        while (index1 >= 0 || index2 >= 0) {
            int num1 = index1 >= 0 ? arr1[index1] : 0;
            int num2 = index2 >= 0 ? arr2[index2] : 0;
            int num = num1 + num2 + temp;
            if (num < 0) {
                temp = 1;
                res.add(1);
            } else if (num < 2) {
                temp = 0;
                res.add(num);
            } else {
                temp = -1;
                res.add(num - 2);
            }
            index1--;
            index2--;
        }
        if (temp == -1) {
            res.add(1);
            res.add(1);
        }

        // 输出结果，需要反转并去掉多余的 0
        int index = 0;
        for (int i = res.size() - 1; i > 0; i--) {
            if (res.get(i) != 0) {
                index = i;
                break;
            }
        }
        int[] ans = new int[index + 1];
        for (int i = 0; i <= index; i++) {
            ans[i] = res.get(index - i);
        }
        return ans;
    }
}
