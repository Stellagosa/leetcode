package com.stellagosa.leetcode.leetcode100_999.leetcode_337;

/**
 * @author Stellagosa
 * @description 打家劫舍Ⅲ
 * @date 2023/9/19 7:20 星期二
 */
public class Solution {


    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    // [0] 包含当前节点的收益
    // [1] 不包含当前节点的收益
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        return new int[]{root.val + left[1] + right[1],
                Math.max(left[0], left[1]) + Math.max(right[0], right[1])};
    }


    // private final Map<TreeNode, Integer> map1 = new HashMap<>(); // 打劫包含当前节点的最大数
    // private final Map<TreeNode, Integer> map2 = new HashMap<>(); // 打劫不包含当前节点的最大数
    //
    // public int rob(TreeNode root) {
    //     dfs(root);
    //     return Math.max(map1.getOrDefault(root, 0), map2.getOrDefault(root, 0));
    // }
    //
    // // 后续遍历
    // private void dfs(TreeNode root) {
    //     if (root == null) return;
    //     dfs(root.right);
    //     dfs(root.left);
    //     // 包含当前节点的最大数
    //     int num1 = root.val + map2.getOrDefault(root.left, 0) + map2.getOrDefault(root.right, 0);
    //
    //     // 不包含当前节点的最大数
    //     int num2 = Math.max(map1.getOrDefault(root.left, 0), map2.getOrDefault(root.left, 0)) +
    //             Math.max(map1.getOrDefault(root.right, 0), map2.getOrDefault(root.right, 0));
    //     map1.put(root, num1);
    //     map2.put(root, num2);
    // }


    // 超时
    // public int rob(TreeNode root) {
    //     if (root == null) return 0;
    //     int num1 = rob(root.left) + rob(root.right);
    //     int num2 = root.val;
    //     if (root.left != null) {
    //         num2 += rob(root.left.left) + rob(root.left.right);
    //     }
    //     if (root.right != null) {
    //         num2 += rob(root.right.left) + rob(root.right.right);
    //     }
    //     return Math.max(num1, num2);
    // }

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
