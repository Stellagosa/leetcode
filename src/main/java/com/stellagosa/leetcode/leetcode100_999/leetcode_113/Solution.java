package com.stellagosa.leetcode.leetcode100_999.leetcode_113;

import java.util.*;

/**
 * @Author: Stellagosa
 * @Date: 2022/5/20 20:55
 * @Description:
 */
public class Solution {

    // private List<List<Integer>> res = new ArrayList<>();
    // 频繁增删
    private List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5);
        int[] nums = {5, 4, 8, 11, -10001, 13, 4, 7, 2, -10001, -10001, -10001, -10001, 5, 1};
        solution.treeGenerator(nums, root, 0);

        List<List<Integer>> lists = solution.pathSum(root, 22);

        for (List<Integer> list : lists) {
            for (Integer num : list) {
                System.out.printf("%d\t", num);
            }
            System.out.println();
        }
    }


    // TAG 广度优先搜索
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode node = root;
        deque.push(node);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                node = deque.pop();
                if (node.left == null && node.right == null) {
                    pathCount(map, targetSum, node);
                }

                if (node.left != null) {
                    map.put(node.left, node);
                    deque.push(node.left);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    deque.push(node.right);
                }
                size--;
            }
        }
        return res;
    }

    private void pathCount(Map<TreeNode, TreeNode> map, int targetSum, TreeNode node) {
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            targetSum-=node.val;
            node = map.get(node);
        }
        if (targetSum == 0) {
            Collections.reverse(list);
            res.add(list);
        }
    }

    // TAG 深度优先搜索
    // public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    //     dfs(root, new ArrayList<>(), targetSum);
    //     return res;
    // }

    // private void dfs(TreeNode node, List<Integer> list, int targetSum) {
    //     if (node == null) return;
    //     list.add(node.val);
    //     targetSum -= node.val;
    //     if (node.left == null && node.right == null && targetSum == 0) {
    //         res.add(new ArrayList<>(list));
    //         return;
    //     }
    //
    //     if (node.left != null) {
    //         dfs(node.left, list, targetSum);
    //         list.remove(list.size() - 1);
    //     }
    //     if (node.right != null) {
    //         dfs(node.right, list, targetSum);
    //         list.remove(list.size() - 1);
    //     }
    // }

    // TAG 生成树
    private void treeGenerator(int[] arr, TreeNode root, int index) {
        if (arr.length == 0) return;
        int leftIndex = 1 + (index << 1);
        int rightIndex = leftIndex + 1;
        if (leftIndex < arr.length && arr[leftIndex] != -10001) {
            root.left = new TreeNode(arr[leftIndex]);
            treeGenerator(arr, root.left, leftIndex);
        }
        if (rightIndex < arr.length && arr[rightIndex] != -10001) {
            root.right = new TreeNode(arr[rightIndex]);
            treeGenerator(arr, root.right, rightIndex);
        }
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
