package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2641;

import java.util.*;

/**
 * @author Stellagosa
 * @description 二叉树的堂兄弟节点Ⅱ
 * @date 2024/2/7 10:17 星期三
 */
public class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        root.val = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            int sum = 0;
            for (TreeNode node : deque) {
                if (node.left != null) {
                    sum += node.left.val;
                }
                if (node.right != null) {
                    sum += node.right.val;
                }
            }
            for (int i = 0; i < size; i++) {
                TreeNode pop = deque.pop();
                int temp = sum;
                if (pop.left != null) {
                    temp -= pop.left.val;
                }
                if (pop.right != null) {
                    temp -= pop.right.val;
                }
                if (pop.left != null) {
                    pop.left.val = temp;
                    deque.offer(pop.left);
                }
                if (pop.right != null) {
                    pop.right.val = temp;
                    deque.offer(pop.right);
                }
            }
        }
        return root;
    }

    // public TreeNode replaceValueInTree(TreeNode root) {
    //     if (root == null) return null;
    //     LinkedList<TreeNode> list = new LinkedList<>();
    //     list.add(root);
    //     root.val = 0;
    //     while (!list.isEmpty()) {
    //         int size = list.size();
    //         int sum = 0;
    //         for (int i = 0; i < size; i++) {
    //             TreeNode node = list.get(i);
    //             if (node.left != null) {
    //                 sum += node.left.val;
    //                 list.add(node.left);
    //             }
    //             if (node.right != null) {
    //                 sum += node.right.val;
    //                 list.add(node.right);
    //             }
    //         }
    //         for (int i = 0; i < size; i++) {
    //             TreeNode node = list.removeFirst();
    //             int temp = sum;
    //             if (node.left != null) {
    //                 temp -= node.left.val;
    //             }
    //             if (node.right != null) {
    //                 temp -= node.right.val;
    //             }
    //             if (node.left != null) {
    //                 node.left.val = temp;
    //             }
    //             if (node.right != null) {
    //                 node.right.val = temp;
    //             }
    //         }
    //     }
    //     return root;
    // }

    // public TreeNode replaceValueInTree(TreeNode root) {
    //     if (root == null) return null;
    //     // 存放各深度的和
    //     List<Integer> sums = new ArrayList<>();
    //     sums.add(root.val);
    //     Deque<TreeNode> deque = new ArrayDeque<>();
    //     deque.offer(root);
    //     // 第一遍广度优先遍历统计各层的和
    //     while (!deque.isEmpty()) {
    //         int size = deque.size();
    //         int sum = 0;
    //         for (int i = 0; i < size; i++) {
    //             TreeNode pop = deque.pop();
    //             if (pop.left != null) {
    //                 deque.offer(pop.left);
    //                 sum += pop.left.val;
    //             }
    //             if (pop.right != null) {
    //                 deque.offer(pop.right);
    //                 sum += pop.right.val;
    //             }
    //         }
    //         sums.add(sum);
    //     }
    //
    //     for (Integer sum : sums) {
    //         System.out.println(sum);
    //     }
    //
    //
    //     // 第二层广度优先遍历计算堂兄弟的和
    //     root.val = 0;
    //     // 深度
    //     int depth = 1;
    //     deque.offer(root);
    //     while (!deque.isEmpty()) {
    //         int size = deque.size();
    //         for (int i = 0; i < size; i++) {
    //             int sum = sums.get(depth);
    //             TreeNode pop = deque.pop();
    //             if (pop.left != null) {
    //                 deque.offer(pop.left);
    //                 sum -= pop.left.val;
    //             }
    //             if (pop.right != null) {
    //                 deque.offer(pop.right);
    //                 sum -= pop.right.val;
    //             }
    //             if (pop.left != null) {
    //                 pop.left.val = sum;
    //             }
    //             if (pop.right != null) {
    //                 pop.right.val = sum;
    //             }
    //         }
    //         depth++;
    //     }
    //     return root;
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
