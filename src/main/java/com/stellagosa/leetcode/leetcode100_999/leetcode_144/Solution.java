package com.stellagosa.leetcode.leetcode100_999.leetcode_144;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Stellagosa
 * @description 二叉树的前序遍历
 * @date 2024/2/14 19:38 星期三
 */
public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;
        while (!deque.isEmpty() || node != null) {
            if (node != null) {
                result.add(node.val);
                deque.push(node);
                node = node.left;
            } else {
                node = deque.pop();
                node = node.right;
            }
        }
        return result;
    }

    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> result = new ArrayList<>();
    //     visit(root, result);
    //     return result;
    // }
    //
    // private void visit(TreeNode root, List<Integer> result) {
    //     if (root == null) return;
    //     result.add(root.val);
    //     visit(root.left, result);
    //     visit(root.right, result);
    // }

    public static class TreeNode {
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
