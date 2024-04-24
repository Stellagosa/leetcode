package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2385;

import java.util.*;

/**
 * @author Stellagosa
 * @description 感染二叉树需要的总时间
 * @date 2024/4/24 14:43 星期三
 */
public class Solution {

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        // 建图
        dfs(map, root);

        // 广度优先搜索
        int time = 0;
        List<Integer> list = map.get(start);
        if (list == null) return time;
        Set<Integer> set = new HashSet<>();
        set.add(start);
        while (!list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Integer node = list.removeFirst();
                set.add(node);
                List<Integer> temp = map.get(node);
                for (Integer num : temp) {
                    if (!set.contains(num)) {
                        list.add(num);
                    }
                }
            }
            time++;
        }
        return time;
    }

    private void dfs(Map<Integer, List<Integer>> map, TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            map.computeIfAbsent(root.val, k -> new ArrayList<>());
            map.get(root.val).add(root.left.val);
            map.computeIfAbsent(root.left.val, k -> new ArrayList<>());
            map.get(root.left.val).add(root.val);
            dfs(map, root.left);
        }
        if (root.right != null) {
            map.computeIfAbsent(root.val, k -> new ArrayList<>());
            map.get(root.val).add(root.right.val);
            map.computeIfAbsent(root.right.val, k -> new ArrayList<>());
            map.get(root.right.val).add(root.val);
            dfs(map, root.right);
        }
    }


    public static class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

}
