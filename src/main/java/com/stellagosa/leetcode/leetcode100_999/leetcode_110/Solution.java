package com.stellagosa.leetcode.leetcode100_999.leetcode_110;

import com.sun.source.tree.Tree;

/**
 * @Author: Stellagosa
 * @Date: 2022/2/4 11:25
 * @Description: 平衡二叉树
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        Solution solution = new Solution();
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.println(solution.isBalanced(node1));
    }

    public boolean isBalanced(TreeNode root) {
        return high(root) != -1;
    }

    // 计算二叉树高度并判断是否平衡，不平衡就返回 -1
    private int high(TreeNode root) {
        if (root == null) return 0;
        int leftHigh = 0, rightHigh = 0;
        if (root.left != null) {
            leftHigh = high(root.left);
        }
        if (root.right != null) {
            rightHigh = high(root.right);
        }

        if (leftHigh == -1 || rightHigh == -1) return -1;
        if (Math.abs(leftHigh - rightHigh) > 1) return -1;
        return Math.max(leftHigh, rightHigh) + 1;
    }

    // 先递归遍历计算高度，然后递归判断是否是平衡二叉树
    // 缺点：修改了原二叉树，还进行了两次递归
    // public boolean isBalanced(TreeNode root) {
    //     if (root == null) return true;
    //     calculateHigh(root);
    //     return check(root);
    // }
    //
    // private boolean check(TreeNode root) {
    //     if (root == null) return true;
    //     int leftHigh = 0, rightHigh = 0;
    //     if (root.left != null) {
    //         leftHigh = root.left.val;
    //     }
    //     if (root.right != null) {
    //         rightHigh = root.right.val;
    //     }
    //     return Math.abs(leftHigh - rightHigh) <= 1 && check(root.left) && check(root.right);
    // }
    //
    // private void calculateHigh(TreeNode root) {
    //     int leftHigh = 0, rightHigh = 0;
    //     if (root.left != null) {
    //         calculateHigh(root.left);
    //         leftHigh = root.left.val;
    //     }
    //     if (root.right != null) {
    //         calculateHigh(root.right);
    //         rightHigh = root.right.val;
    //     }
    //     root.val = Math.max(leftHigh, rightHigh) + 1;
    // }
}
