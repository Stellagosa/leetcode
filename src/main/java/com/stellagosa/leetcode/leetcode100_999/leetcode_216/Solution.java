package com.stellagosa.leetcode.leetcode100_999.leetcode_216;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stellagosa
 * @description 组合总和Ⅲ
 * @date 2024/4/21 9:10 星期日
 */
public class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (k > 9 || k < 1) return result;
        int min = 0, max = 0;
        for (int i = 1; i <= k; i++) {
            min += i;
            max += 10 - i;
        }
        if (n < min || n > max) return result;
        dfs(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> list, int index, int n, int k) {
        if (n == 0 && k == 0) {
            result.add(new ArrayList<>(list));
        }
        if (n > 0 && k > 0) {
            if (index > 9) return;
            list.add(index);
            dfs(result, list, index + 1, n - index, k - 1);
            list.remove(list.size() - 1);
            dfs(result, list, index + 1, n, k);
        }
    }


}
