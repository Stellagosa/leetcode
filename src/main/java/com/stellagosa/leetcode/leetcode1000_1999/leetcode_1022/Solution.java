package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1022;

/**
 * @Author: Stellagosa
 * @Date: 2022/5/30 7:09
 * @Description: 从根到叶的二进制数之和
 */
public class Solution {

    int sum = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(0);
        // int[] arr = {0};
        // solution.treeGenerator(arr, root, 0);

        System.out.println(solution.sumRootToLeaf(root));
    }

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int num) {
        if (root == null) return 0;
        num = (num << 1) + root.val;
        if (root.left == null && root.right == null) {
            return num;
        }
        return dfs(root.left, num) + dfs(root.right, num);
    }



    // TAG 深度优先遍历
//    public int sumRootToLeaf(TreeNode root) {
//        dfs(root, 0);
//        return sum;
//    }

//    private void dfs(TreeNode root, int val) {
//        if (root == null) return;
//        int temp = root.val + (val << 1);
//        if (root.left == null && root.right == null) {
//            sum += temp;
//        }
//        if (root.left != null) {
//            dfs(root.left, temp);
//        }
//        if (root.right != null) {
//            dfs(root.right, temp);
//        }
//    }


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
