package com.stellagosa.leetcode.leetcode100_999.leetcode_515;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2022/6/24 8:03
 * @Description: 在每个树行中找最大值
 */
public class Solution {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) {
            deque.offer(root);
        }

        while (!deque.isEmpty()) {
            int size = deque.size();
            int max = deque.peek().val;
            while (size > 0) {
                TreeNode node = deque.poll();
                max = Math.max(node.val, max);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
                size--;
            }
            list.add(max);
        }
        return list;
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

