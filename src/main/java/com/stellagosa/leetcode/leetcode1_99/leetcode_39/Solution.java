package com.stellagosa.leetcode.leetcode1_99.leetcode_39;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stellagosa
 * @description 组合总和
 * @date 2024/4/20 8:52 星期六
 */
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, 0, new ArrayList<>(), target, result);
        return result;
    }

    private void dfs(int[] candidates, int index, List<Integer> list, int target, List<List<Integer>> result) {
        if (index == candidates.length) return;
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (target - candidates[index] >= 0) {
            list.add(candidates[index]);
            dfs(candidates, index, list, target - candidates[index], result);
            list.remove(list.size() - 1);
        }
        dfs(candidates, index + 1, list, target, result);
    }
}
