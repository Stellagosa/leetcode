package com.stellagosa.leetcode.leetcode101_1000.leetcode_108;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:40
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode treeNode = solution.sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return bst(nums, 0, nums.length - 1);
    }

    private TreeNode bst(int[] nums, int left, int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(nums[left]);
        int mid = (left + right) >> 1;
        TreeNode node = new TreeNode(nums[mid]);
        TreeNode leftNode = bst(nums, left, mid - 1);
        TreeNode rightNode = bst(nums, mid + 1, right);
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

