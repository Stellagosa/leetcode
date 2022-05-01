package com.stellagosa.leetcode.leetcode1_99.leetcode_94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Stellagosa
 * @Date: 2022/5/1 11:02
 * @Description: 二叉树的中序遍历
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode temp1 = new TreeNode(2);
        TreeNode temp2 = new TreeNode(3);
        root.right = temp1;
        temp1.left = temp2;
        solution.inorderTraversal(root).forEach(System.out::println);
    }

    // 基于栈的遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }


    // 递归遍历
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     dfs(root, res);
    //     return res;
    // }
    // public void dfs(TreeNode root, List<Integer> list) {
    //     if (root == null) return;
    //     dfs(root.left, list);
    //     list.add(root.val);
    //     dfs(root.right, list);
    // }

}

// Definition for a binary tree node.
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
