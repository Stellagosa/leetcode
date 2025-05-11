package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2094;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stellagosa
 * @description 找出3位偶数
 * @date 2025/5/12 7:31 星期一
 */
public class Solution {

    public int[] findEvenNumbers(int[] digits) {
        int[] counter = new int[10];
        for (int digit : digits) {
            counter[digit]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 100; i < 1000; i += 2) {
            int[] target = new int[10];
            int num = i;
            while (num > 0) {
                target[num % 10]++;
                num /= 10;
            }
            boolean flag = false;
            for (int j = 0; j < counter.length; j++) {
                if (target[j] > counter[j]) {
                    flag = true;
                    break;
                }

            }
            if (!flag) {
                res.add(i);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

}
