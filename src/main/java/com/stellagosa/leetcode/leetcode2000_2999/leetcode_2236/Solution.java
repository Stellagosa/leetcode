package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2236;

/**
 * @Author: Stellagosa
 * @Date: 2023/8/20 9:26
 * @Description: 判断根节点是否等于子节点之和
 */
public class Solution {

    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
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
