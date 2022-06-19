package com.stellagosa.leetcode.leetcode100_999.leetcode_508;

import java.util.*;

/**
 * @Author: Stellagosa
 * @Date: 2022/6/19 8:00
 * @Description: 出现次数最多的子树元素和
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(-3);
        node1.left = node2;
        node1.right = node3;
        int[] arr = solution.findFrequentTreeSum(node1);
        for (int item : arr) {
            System.out.println(item);
        }
    }

    Map<Integer,Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> list = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int sum = node.val + dfs(node.left) + dfs(node.right);
        map.merge(sum, 1, Integer::sum);
        max = Math.max(map.get(sum), max);
        return sum;
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
