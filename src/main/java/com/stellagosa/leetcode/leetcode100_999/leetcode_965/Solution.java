package com.stellagosa.leetcode.leetcode100_999.leetcode_965;

/**
 * @Author: Stellagosa
 * @Date: 2022/5/24 21:39
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {

    }

    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTree(root, root.val);
    }

    private boolean isUnivalTree(TreeNode root, int val) {
        if (root == null) return true;
        return root.val == val && isUnivalTree(root.left, val) && isUnivalTree(root.right, val);
    }
}

class TreeNode {
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

