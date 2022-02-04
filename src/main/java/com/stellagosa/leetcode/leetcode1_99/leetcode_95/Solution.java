package com.stellagosa.leetcode.leetcode1_99.leetcode_95;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:39
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<TreeNode> treeNodes = solution.generateTrees(2);
    }

    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }
        for (int root = start; root <= end; root++) {
            List<TreeNode> lefts = generate(start, root - 1);
            List<TreeNode> rights = generate(root + 1, end);
            if (lefts.size() == 0) {
                for (TreeNode right : rights) {
                    TreeNode node = new TreeNode(root);
                    node.left = null;
                    node.right = right;
                    res.add(node);
                }
            } else if (rights.size() == 0) {
                for (TreeNode left : lefts) {
                    TreeNode node = new TreeNode(root);
                    node.left = left;
                    node.right = null;
                    res.add(node);
                }
            } else {
                for (TreeNode left : lefts) {
                    for (TreeNode right : rights) {
                        TreeNode node = new TreeNode(root);
                        node.left = left;
                        node.right = right;
                        res.add(node);
                    }
                }
            }
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
