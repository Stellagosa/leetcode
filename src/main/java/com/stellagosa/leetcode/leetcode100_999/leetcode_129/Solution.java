package com.stellagosa.leetcode.leetcode100_999.leetcode_129;

/**
 * @Author: Stellagosa
 * @Date: 2022/7/18 7:11
 * @Description: 求根节点到叶节点数字之和
 */
public class Solution {

    private int sum;

    public int sumNumbers(TreeNode root) {
        sumNumber(root, 0);
        return sum;
    }

    private void sumNumber(TreeNode root, int preVal) {
        if (root == null) return;
        preVal = preVal * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += preVal;
            return;
        }
        sumNumber(root.left, preVal);
        sumNumber(root.right, preVal);
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
