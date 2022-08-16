package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1302;

/**
 * @Author: Stellagosa
 * @Date: 2022/8/17 5:58
 * @Description: 层数最深叶子节点的和
 */
public class Solution {

    int maxLeave = 0;
    int sum;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 1);
        return sum;
    }

    private void dfs(TreeNode root, int leave) {
        if (root == null) return;
        if (leave == this.maxLeave) {
            sum+=root.val;
        } else if (leave > this.maxLeave) {
            this.maxLeave = leave;
            sum = root.val;
        }
        dfs(root.left, leave + 1);
        dfs(root.right, leave + 1);
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
