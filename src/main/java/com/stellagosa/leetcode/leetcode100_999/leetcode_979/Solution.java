package com.stellagosa.leetcode.leetcode100_999.leetcode_979;

/**
 * @Author: Stellagosa
 * @Date: 2023/7/14 9:41
 * @Description: 在二叉树中分配硬币
 */
public class Solution {

    private int result;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return result;
    }

    // 优化
    // nodes - coins = nodesLeft + nodesRight + 1 - (coinsLeft + coinsRight + root.val)
    // = (nodesLeft - coinsLeft) + (nodesRight - coinsRight) + (1 - root.val)
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int temp = dfs(root.left) + dfs(root.right) + 1 - root.val;
        result += Math.abs(temp);
        return temp;
    }

    // 后续遍历
    // 返回节点数和硬币数
    // private int[] dfs(TreeNode root) {
    //     if (root == null) return new int[]{0, 0};
    //     int[] left = dfs(root.left);
    //     int[] right = dfs(root.right);
    //     // 当前节点数
    //     int nodes = left[0] + right[0] + 1;
    //     // 当前硬币数
    //     int coins = left[1] + right[1] + root.val;
    //     // 需要移动的硬币数
    //     result += Math.abs(nodes - coins);
    //     return new int[]{nodes, coins};
    // }
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
