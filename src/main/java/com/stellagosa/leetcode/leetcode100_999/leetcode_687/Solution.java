package com.stellagosa.leetcode.leetcode100_999.leetcode_687;

/**
 * @Author: Stellagosa
 * @Date: 2022/9/2 10:32
 * @Description: 最长同值路径
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(5);

        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;

        System.out.println(solution.longestUnivaluePath(node1));
    }

    int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftValue = dfs(root.left);
        int rightValue = dfs(root.right);

        int left = 0, right = 0;
        if (root.left != null && root.left.val == root.val) {
            left = leftValue + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            right = rightValue + 1;
        }
        res = Math.max(res, left + right);
        return Math.max(left, right);
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
