package com.stellagosa.leetcode.leetcode1_99.leetcode_98;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Stellagosa
 * @Date: 2022/5/20 17:33
 * @Description: 验证二叉搜索树
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(2147483647);
        System.out.println(solution.isValidBST(root));
    }

    // 中序遍历递增
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode node = root;
        long pre = Long.MIN_VALUE;
        while (!deque.isEmpty() || node != null) {
            while (node != null) {
                deque.push(node);
                node = node.left;
            }
            node = deque.pop();
            if (node.val <= pre) return false;
            pre = node.val;
            node = node.right;
        }
        return true;
    }

        // public boolean isValidBST(TreeNode root) {
    //     return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    // }
    //
    // private boolean isValidBST(TreeNode root, long maxValue, long minValue) {
    //     if (root == null) return true;
    //
    //     if (root.val >= maxValue || root.val <= minValue) return false;
    //
    //     return isValidBST(root.left, root.val, minValue) && isValidBST(root.right, maxValue, root.val);
    //
    // }

    // public boolean isValidBST(TreeNode root) {
    //     if (root == null) return true;
    //     if (root.left == null && root.right == null) return true;
    //     if (root.left == null) {
    //         return isValidBST(root.right) && treeMinNum(root.right) > root.val;
    //     }
    //     if (root.right == null) {
    //         return isValidBST(root.left) && treeMaxNum(root.left) < root.val;
    //     }
    //     return isValidBST(root.left)
    //             && isValidBST(root.right)
    //             && treeMaxNum(root.left) < root.val
    //             && treeMinNum(root.right) > root.val;
    // }
    //
    // private int treeMinNum(TreeNode root) {
    //     return root.left == null ? root.val : treeMinNum(root.left);
    // }
    //
    // private int treeMaxNum(TreeNode root) {
    //     return root.right == null ? root.val : treeMaxNum(root.right);
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
