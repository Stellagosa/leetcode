package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2265;

/**
 * @author Stellagosa
 * @description 2265.统计值等于子树平均值的节点数
 * @date 9/10/2026 7:53 AM Thursday
 */
public class Solution {

    private int count = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] l = dfs(root.left);
        int[] r = dfs(root.right);

        if ((l[0] + r[0] + root.val) / (l[1] + r[1] + 1) == root.val) {
            count++;
        }

        return new int[]{l[0] + r[0] + root.val, l[1] + r[1] + 1};
    }


    // private int count = 0;
    // Map<TreeNode, int[]> map = new HashMap<>();
    //
    // public int averageOfSubtree(TreeNode root) {
    //     dfs(root);
    //     return count;
    // }

    // private void dfs(TreeNode root) {
    //     if (root != null) {
    //         dfs(root.left);
    //         dfs(root.right);
    //
    //         if (root.left == null && root.right == null) {
    //             count++;
    //             map.put(root, new int[]{root.val, 1});
    //             return;
    //         }
    //
    //         if (root.left == null) {
    //             int[] temp = map.get(root.right);
    //             if ((temp[0] + root.val) / (temp[1] + 1) == root.val) {
    //                 count++;
    //             }
    //             map.put(root, new int[] {temp[0] + root.val, temp[1] + 1});
    //             return;
    //         }
    //
    //         if (root.right == null) {
    //             int[] temp = map.get(root.left);
    //             if ((temp[0] + root.val) / (temp[1] + 1) == root.val) {
    //                 count++;
    //             }
    //             map.put(root, new int[] {temp[0] + root.val, temp[1] + 1});
    //             return;
    //         }
    //
    //         int[] temp1 = map.get(root.left);
    //         int[] temp2 = map.get(root.right);
    //         if ((temp1[0] + temp2[0] + root.val) / (temp1[1] + temp2[1] + 1) == root.val) {
    //             count++;
    //         }
    //         map.put(root, new int[] {temp1[0] + temp2[0] + root.val, temp1[1] + temp2[1] + 1});
    //     }
    // }


    static class TreeNode {
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
}
