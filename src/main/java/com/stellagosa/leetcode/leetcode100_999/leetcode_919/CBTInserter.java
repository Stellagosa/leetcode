package com.stellagosa.leetcode.leetcode100_999.leetcode_919;

/**
 * @Author: Stellagosa
 * @Date: 2022/7/25 8:01
 * @Description: 完全二叉树插入器
 */
public class CBTInserter {

    TreeNode root;
    int count;

    public CBTInserter(TreeNode root) {
        this.root = root;
        this.count = 0;
        dfs(this.root);
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        this.count++;
        dfs(node.left);
        dfs(node.right);
    }

    public int insert(int val) {
        this.count++;
        boolean flag = false;
        int num = this.count;
        TreeNode node = this.root;
        for (int i = 10; i > 0; i--) {
            if (!flag) {
                if (((num >> i) & 1) == 1) {
                    flag = true;
                }
            } else {
                if (((num >> i) & 1) == 1) {
                    node = node.right;
                } else {
                    node = node.left;
                }
            }
        }
        TreeNode treeNode = new TreeNode(val);
        if ((num & 1) == 1) {
            node.right = treeNode;
        } else {
            node.left = treeNode;
        }
        return node.val;
    }

    public TreeNode get_root() {
        return this.root;
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
