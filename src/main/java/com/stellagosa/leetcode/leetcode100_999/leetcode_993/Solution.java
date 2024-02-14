package com.stellagosa.leetcode.leetcode100_999.leetcode_993;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Stellagosa
 * @description 二叉树的堂兄弟节点
 * @date 2024/2/14 19:19 星期三
 */
public class Solution {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.val == x || root.val == y) return false;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            TreeNode xFather = null;
            TreeNode yFather = null;
            for (int i = 0; i < size; i++) {
                TreeNode pop = deque.pop();
                if (pop.left != null) {
                    if (pop.left.val == x) {
                        xFather = pop;
                    }
                    if (pop.left.val == y) {
                        yFather = pop;
                    }
                    deque.offer(pop.left);
                }
                if (pop.right != null) {
                    if (pop.right.val == x) {
                        xFather = pop;
                    }
                    if (pop.right.val == y) {
                        yFather = pop;
                    }
                    deque.offer(pop.right);
                }
            }
            if (xFather != null && yFather != null && xFather != yFather) {
                return true;
            }
            if (xFather != null && yFather == null) {
                return false;
            }
            if (xFather == null && yFather != null) {
                return false;
            }
        }
        return false;
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

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
