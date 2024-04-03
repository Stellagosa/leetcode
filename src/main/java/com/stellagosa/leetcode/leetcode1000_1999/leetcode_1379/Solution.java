package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1379;

/**
 * @author Stellagosa
 * @description 找出克隆二叉树中的相同节点
 * @date 2024/4/3 14:45 星期三
 */
public class Solution {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) return null;
        if (original.equals(target)) return cloned;
        TreeNode result = getTargetCopy(original.left, cloned.left, target);
        if (result != null) return result;
        else return getTargetCopy(original.right, cloned.right, target);
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
