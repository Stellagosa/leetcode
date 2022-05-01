package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1305;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @Author: Stellagosa
 * @Date: 2022/5/1 8:16
 * @Description: 两个二叉搜索树中的所有元素
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root1 = new TreeNode(2);
        TreeNode l1 = new TreeNode(1);
        TreeNode r1 = new TreeNode(4);
        root1.left = l1;
        root1.right = r1;

        TreeNode root2 = new TreeNode(1);
        TreeNode l2 = new TreeNode(0);
        TreeNode r2 = new TreeNode(3);
        root2.left = l2;
        root2.right = r2;

        solution.getAllElements(root1, root2).forEach(System.out::println);
    }

    // 22ms
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        dfs(root1, l1);
        dfs(root2, l2);

        // 合并l1/l2
        l1.addAll(l2);
        return l1.stream().sorted().collect(Collectors.toList());
    }

    // 17ms
    // 分别使用递归中序遍历保存为两个有序队列，然后合并两个队列
    // public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    //     List<Integer> l1 = new ArrayList<>();
    //     List<Integer> l2 = new ArrayList<>();
    //     dfs(root1, l1);
    //     dfs(root2, l2);
    //
    //     // 合并l1/l2
    //     List<Integer> res = new ArrayList<>();
    //     int index1 = 0;
    //     int index2 = 0;
    //     while (index1 < l1.size() && index2 < l2.size()) {
    //         if (l1.get(index1) > l2.get(index2)) {
    //             res.add(l2.get(index2));
    //             index2++;
    //         } else {
    //             res.add(l1.get(index1));
    //             index1++;
    //         }
    //     }
    //     if (index1 >= l1.size()) {
    //         res.addAll(l2.subList(index2, l2.size()));
    //     } else {
    //         res.addAll(l1.subList(index1, l1.size()));
    //     }
    //
    //     return res;
    // }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }


    // 40ms
    // 展开递归使用迭代的方法
    // public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    //     List<Integer> res = new ArrayList<>();
    //     Stack<TreeNode> stack1 = new Stack<>();
    //     Stack<TreeNode> stack2 = new Stack<>();
    //
    //     TreeNode cur1 = root1;
    //     TreeNode cur2 = root2;
    //     while (cur1 != null || !stack1.isEmpty() || cur2 != null || !stack2.isEmpty()) {
    //         while (cur1!= null) {
    //             stack1.push(cur1);
    //             cur1 = cur1.left;
    //         }
    //         while (cur2 != null) {
    //             stack2.push(cur2);
    //             cur2 = cur2.left;
    //         }
    //         // 到达这里时，cur1和cur2都是null，两个栈顶分别保存着两颗树的最小值
    //         if (!stack1.isEmpty() && !stack2.isEmpty()) {
    //             // 两个栈都不为空，即没有遍历结束
    //             // 取栈顶元素
    //             cur1 = stack1.peek();
    //             cur2 = stack2.peek();
    //             if (cur1.val > cur2.val) {
    //                 res.add(cur2.val);
    //                 cur2 = cur2.right;
    //                 stack2.pop();
    //                 cur1 = null;
    //             } else {
    //                 res.add(cur1.val);
    //                 cur1 = cur1.right;
    //                 stack1.pop();
    //                 cur2 = null;
    //             }
    //         } else if (!stack1.isEmpty()) {
    //             cur1 = stack1.pop();
    //             res.add(cur1.val);
    //             cur1 = cur1.right;
    //         } else {
    //             cur2 = stack2.pop();
    //             res.add(cur2.val);
    //             cur2 = cur2.right;
    //         }
    //     }
    //     return res;
    // }
}


// Definition for a binary tree node.
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
