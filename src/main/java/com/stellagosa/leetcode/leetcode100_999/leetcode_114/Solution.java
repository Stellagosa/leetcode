package com.stellagosa.leetcode.leetcode100_999.leetcode_114;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:41
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        demo(root);
    }

    public TreeNode demo(TreeNode root) {
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;

        TreeNode left = demo(root.left);
        TreeNode right = demo(root.right);
        root.left = null;
        root.right = null;
        if(left != null) {
            root.right = left;
            while(left.right != null) {
                left = left.right;
            }
            left.right = right;
        } else {
            root.right = right;
        }
        return root;
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

