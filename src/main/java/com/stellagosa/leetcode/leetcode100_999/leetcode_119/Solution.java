package com.stellagosa.leetcode.leetcode100_999.leetcode_119;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2022/8/19 8:28
 * @Description: 杨辉三角Ⅱ
 */
public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        if (rowIndex == 0) return pre;

        pre.add(1);
        if (rowIndex == 1) return pre;

        int num = 2;
        while (num <= rowIndex) {
            List<Integer> next = new ArrayList<>(num + 1);
            next.add(1);
            for (int i = 0; i < pre.size() - 1; i++) {
                next.add(pre.get(i) + pre.get(i + 1));
            }
            next.add(1);
            pre = next;
            num++;
        }
        return pre;
    }

}
