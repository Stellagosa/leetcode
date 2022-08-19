package com.stellagosa.leetcode.leetcode100_999.leetcode_118;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2022/8/19 8:12
 * @Description: 杨辉三角
 */
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);
        if (numRows == 1) return res;

        list = new ArrayList<>();
        list.add(1);
        list.add(1);
        res.add(list);
        if (numRows == 2) return res;
        int num = 3;

        while (num <= numRows) {
            list = new ArrayList<>(num);
            list.add(1);
            List<Integer> preRow = res.get(num - 2);
            for (int i = 0; i < preRow.size() - 1; i++) {
                list.add(preRow.get(i) + preRow.get(i + 1));
            }
            list.add(1);
            res.add(list);
            num++;
        }
        return res;
    }

}
