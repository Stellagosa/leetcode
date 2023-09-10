package com.stellagosa.leetcode.leetcode100_999.leetcode_449;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringJoiner;

/**
 * @author Stellagosa
 * @description 序列化和反序列化二叉搜索树
 * @date 2023/9/4 8:24 星期一
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "5,3,2,1,4,7,6,8";
        TreeNode root = solution.deserialize(str);
        String s = solution.serialize(root);
        System.out.println(s);
    }

    // 先序遍历
    public String serialize(TreeNode root) {
        StringJoiner joiner = new StringJoiner(",");
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null) {
            joiner.add(node.val + "");
            stack.push(node);
            node = node.left;
        }
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.right != null) {
                joiner.add(pop.right.val + "");
                stack.push(pop.right);
                node = pop.right;
                while (node.left != null) {
                    joiner.add(node.left.val + "");
                    stack.push(node.left);
                    node = node.left;
                }
            }
        }
        return joiner.toString();
    }

    public TreeNode deserialize(String data) {
        if ("".equals(data)) return null;
        String[] split = data.split(",");
        int n = split.length;
        int[] arr1 = new int[n]; // 先序遍历
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(split[i]);
        }
        int[] arr2 = new int[n]; // 排序后就是中序遍历
        System.arraycopy(arr1, 0, arr2, 0, n);
        Arrays.sort(arr2);

        // 根据先序和中序遍历恢复二叉树
        return dfs(arr1, 0, n - 1, arr2, 0, n - 1);
    }

    private TreeNode dfs(int[] arr1, int begin1, int end1, int[] arr2, int begin2, int end2) {
        if (begin1 > end1 || begin2 > end2) return null;
        TreeNode node = new TreeNode(arr1[begin1]);
        int search = search(arr2, begin2, end2, arr1[begin1]);
        int leftTreeLen = search - begin2;
        TreeNode left = dfs(arr1, begin1 + 1, begin1 + leftTreeLen, arr2, begin2, search - 1);
        TreeNode right = dfs(arr1, begin1 + leftTreeLen + 1, end1, arr2, search + 1, end2);
        node.left = left;
        node.right = right;
        return node;
    }

    private int search(int[] arr, int begin, int end, int target) {
        for (int i = begin; i <= end; i++) {
            if (arr[i] == target) return i;
        }
        return begin;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}