package com.stellagosa.leetcode.leetcode100_999.leetcode_654;

/**
 * @Author: Stellagosa
 * @Date: 2022/8/20 9:44
 * @Description: 最大二叉树
 */
public class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        int index = -1;
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        int[] left = new int[index];
        int[] right = new int[nums.length - index - 1];
        System.arraycopy(nums, 0, left, 0, left.length);
        for (int i = 0; i < right.length; i++) {
            right[i] = nums[index + i + 1];
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = constructMaximumBinaryTree(left);
        root.right = constructMaximumBinaryTree(right);
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
