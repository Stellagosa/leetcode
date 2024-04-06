package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1026;

/**
 * @author Stellagosa
 * @description 节点与其祖先之间的最大差值
 * @date 2024/4/5 18:55 星期五
 */
public class Solution {

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int min, int max) {
        if (root == null) return 0;
        int result = Math.max(Math.abs(root.val - min), Math.abs(root.val - max));
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        result = Math.max(result, dfs(root.left, min, max));
        result = Math.max(result, dfs(root.right, min, max));
        return result;
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
