package com.stellagosa.leetcode.leetcode100_999.leetcode_103;

import java.util.*;

/**
 * @author Stellagosa
 * @description 二叉树的锯齿形层序遍历
 * @date 2024/2/16 16:25 星期五
 */
public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        boolean flag = false;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pop = deque.pop();
                if (flag) {
                    list.addFirst(pop.val);
                } else {
                    list.addLast(pop.val);
                }
                if (pop.left != null) {
                    deque.offer(pop.left);
                }
                if (pop.right != null) {
                    deque.offer(pop.right);
                }
            }
            result.add(list);
            flag = !flag;
        }
        return result;
    }

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
