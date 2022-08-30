package com.stellagosa.leetcode.leetcode100_999.leetcode_998;

/**
 * @Author: Stellagosa
 * @Date: 2022/8/30 18:58
 * @Description: 最大二叉树Ⅱ
 */
public class Solution {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null || root.val < val) return new TreeNode(val, root, null);
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}