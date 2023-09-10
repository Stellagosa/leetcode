package com.stellagosa.leetcode.leetcode100_999.leetcode_449;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Stellagosa
 * @description
 * @date 2023/9/10 11:36 星期日
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        String s = solution2.serialize(node1);
        TreeNode treeNode = solution2.deserialize(s);
    }

    // 后序遍历
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        List<Integer> list = new LinkedList<>();
        visit(root, list);
        StringBuilder builder = new StringBuilder();

        for (Integer integer : list) {
            builder.append(integer).append(",");
        }
        return builder.deleteCharAt(builder.lastIndexOf(",")).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isBlank()) return null;
        String[] split = data.split(",");
        Deque<Integer> stack = new LinkedList<>();
        for (String s : split) {
            stack.push(Integer.parseInt(s));
        }
        return build(stack, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private void visit(TreeNode node, List<Integer> list) {
        if (node == null) return;
        visit(node.left, list);
        visit(node.right, list);
        list.add(node.val);
    }

    private TreeNode build(Deque<Integer> stack, int min, int max) {
        if (stack.isEmpty() || stack.peek() > max || stack.peek() < min) return null;
        Integer pop = stack.pop();
        TreeNode node = new TreeNode(pop);
        node.right = build(stack, pop, max);
        node.left = build(stack, min, pop);
        return node;
    }
}
