package com.stellagosa.leetcode.leetcode_1609;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/25 10:54
 * @Description: 奇偶树
 */
public class Solution {

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        boolean isOddLine = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                list.add(node.val);
                size--;
            }
            if (!check(list, isOddLine)) return false;
            isOddLine = !isOddLine;
        }
        return true;
    }

    private boolean check(List<Integer> list, boolean isOddLine) {
        if (list.size() == 0) return true;
        return isOddLine ? isEvenAndDecrease(list) : isOddAndIncrease(list);
    }

    // 奇数且单调递增
    private boolean isOddAndIncrease(List<Integer> list) {
        if (list.size() == 1) return list.get(0) % 2 == 1;
        if (list.get(0) % 2 == 0) return false;
        for (int i = 1; i < list.size(); i++) {
            Integer cur = list.get(i);
            if (cur % 2 == 0) return false;
            if (cur <= list.get(i - 1)) return false;
        }
        return true;
    }

    // 偶数且单调递减
    private boolean isEvenAndDecrease(List<Integer> list) {
        if (list.size() == 1) return list.get(0) % 2 == 0;
        if (list.get(0) % 2 == 1) return false;
        for (int i = 1; i < list.size(); i++) {
            Integer cur = list.get(i);
            if (cur % 2 == 1) return false;
            if (cur >= list.get(i - 1)) return false;
        }
        return true;
    }
}
