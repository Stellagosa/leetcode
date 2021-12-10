package com.stellagosa.leetcode.leetcode_1707;

import java.util.Arrays;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 22:04
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{536870912, 0, 534710168, 330218644, 142254206};
        int[][] queries = new int[][]{{558240772, 1000000000}, {307628050, 1000000000}, {3319300, 1000000000}, {2751604, 683297522}, {214004, 404207941}};
//        int[] nums = new int[]{5,2,4,6,6,3};
//        int[][] queries = new int[][]{{12,4},{8,1},{6,3}};

        int[] xor = solution.maximizeXor(nums, queries);
        System.out.println(Arrays.toString(xor));
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = queries.length;
        int[] answer = new int[n];

        PrefixTree tree = new PrefixTree();
        for (int num : nums) {
            tree.insert(num);
        }

        for (int i = 0; i < n; i++) {
            answer[i] = tree.maxXor(queries[i][0], queries[i][1]);
        }

        return answer;
    }
}

class PrefixTree {
    private final PrefixTree[] children;
    private int minNum;

    public PrefixTree() {
        this.children = new PrefixTree[2];
        minNum = Integer.MAX_VALUE;
    }

    public void insert(int num) {
        int[] array = numToBinaryArray(num);
        PrefixTree node = this;
        for (int j : array) {
            if (node.children[j] == null) {
                node.children[j] = new PrefixTree();
            }
            node = node.children[j];
            node.minNum = Math.min(node.minNum, num);
        }
    }

    // 小于m，与x最大的异或值
    public int maxXor(int x, int m) {
        int[] xBin = numToBinaryArray(x);
        PrefixTree node = this;
        for (int i = 0; i < 30; i++) {
            if (node.children[0] != null && node.children[1] != null) {
                if (node.children[0].minNum <= m && node.children[1].minNum <= m) {
                    if (xBin[i] == 1) {
                        node = node.children[0];
                    } else {
                        node = node.children[1];
                    }
                } else if (node.children[0].minNum <= m) {
                    node = node.children[0];
                } else if (node.children[1].minNum <= m) {
                    node = node.children[1];
                } else {
                    return -1;
                }
            } else if (node.children[0] != null) {
                if (node.children[0].minNum <= m) {
                    node = node.children[0];
                } else {
                    return -1;
                }
            } else {
                if (node.children[1].minNum <= m) {
                    node = node.children[1];
                } else {
                    return -1;
                }
            }
        }
        return node.minNum ^ x;
    }

    private int[] numToBinaryArray(int num) {
        int[] arr = new int[30];
        for (int i = 29; i >= 0; i--) {
            arr[29 - i] = 1 & (num >> i);
        }
        return arr;
    }

//    private int binaryArrayToNum(int[] arr) {
//        int res = 0;
//        for (int i = 0; i < arr.length; i++) {
//            res += arr[i] << (29 - i);
//        }
//        return res;
//    }
}
