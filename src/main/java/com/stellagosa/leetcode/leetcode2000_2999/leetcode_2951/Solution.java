package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2951;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stellagosa
 * @description 找出峰值
 * @date 2024/5/28 8:27 星期二
 */
public class Solution {

    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                result.add(i);
            }
        }
        return result;
    }

}
