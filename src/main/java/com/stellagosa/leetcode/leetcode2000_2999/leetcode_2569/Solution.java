package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2569;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2023/7/26 8:58
 * @Description: 更改数组后处理求和查询
 */
public class Solution {

    // 暴力超时
    // public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
    //     long sumOfNums2 = 0;
    //     int oneCountInNums1 = 0;
    //     for (int i = 0; i < nums1.length; i++) {
    //         oneCountInNums1 += nums1[i];
    //         sumOfNums2 += nums2[i];
    //     }
    //     List<Long> result = new LinkedList<>();
    //     for (int[] query : queries) {
    //         if (query[0] == 1) {
    //             for (int i = query[1]; i <= query[2]; i++) {
    //                 if (nums1[i] == 1) {
    //                     nums1[i] = 0;
    //                     oneCountInNums1--;
    //                 } else {
    //                     nums1[i] = 1;
    //                     oneCountInNums1++;
    //                 }
    //             }
    //         } else if (query[0] == 2) {
    //             sumOfNums2 += (long) oneCountInNums1 * query[1];
    //         } else {
    //             // query[0] == 3
    //             result.add(sumOfNums2);
    //         }
    //     }
    //     return result.stream().mapToLong(Long::longValue).toArray();
    // }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 0, 1};
        int[] nums2 = {0, 0, 0};
        int[][] queries = {{1, 1, 1}, {2, 1, 0}, {3, 0, 0}};
        long[] results = solution.handleQuery(nums1, nums2, queries);
        for (long result : results) {
            System.out.println(result);
        }
    }


    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        List<Long> result = new LinkedList<>();
        SegTree tree = new SegTree(nums1);
        long sumOfNums2 = 0L;
        for (int num : nums2) {
            sumOfNums2 += num;
        }
        for (int[] query : queries) {
            if (query[0] == 1) {
                tree.reverse(query[1], query[2]);
            } else if (query[0] == 2) {
                sumOfNums2 += (long) query[1] * tree.sum();
            } else {
                result.add(sumOfNums2);
            }
        }
        return result.stream().mapToLong(Long::longValue).toArray();
    }
}

class SegTree {
    // 存放节点
    private final SegNode[] arrays;
    // 树的高度

    public SegTree(int[] nums) {
        int n = nums.length;
        int len = 1;
        // 计算最后一层的节点数
        // 大于等于n的最小2^k
        while (len < n) {
            len <<= 1;
        }
        // 最后一层节点数为len，总的节点数为 2*len - 1
        this.arrays = new SegNode[(len << 1) - 1];
        // 根据数组构建数
        build(0, 0, n - 1, nums);
    }

    // 反转
    public void reverse(int left, int right) {
        modify(0, left, right);
    }

    public int sum() {
        return query(0, this.arrays[0].l, this.arrays[0].r);
    }

    private void build(int index, int l, int r, int[] nums) {
        this.arrays[index] = new SegNode();
        this.arrays[index].l = l;
        this.arrays[index].r = r;
        this.arrays[index].lazy = false;
        if (l == r) {
            // 叶子节点
            this.arrays[index].value = nums[l];
            return;
        }
        build(2 * index + 1, l, (l + r) / 2, nums);
        build(2 * index + 2, ((l + r) / 2) + 1, r, nums);
        this.arrays[index].value = this.arrays[1 + 2 * index].value + this.arrays[2 + 2 * index].value;
    }

    private void pushDown(int index) {
        if (this.arrays[index].lazy) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            this.arrays[leftChild].lazy = !this.arrays[leftChild].lazy;
            this.arrays[leftChild].value = this.arrays[leftChild].r - this.arrays[leftChild].l + 1 - this.arrays[leftChild].value;
            this.arrays[rightChild].lazy = !this.arrays[rightChild].lazy;
            this.arrays[rightChild].value = this.arrays[rightChild].r - this.arrays[rightChild].l + 1 - this.arrays[rightChild].value;
            this.arrays[index].lazy = false;
        }
    }

    private void modify(int index, int l, int r) {
        if (this.arrays[index].l > r || this.arrays[index].r < l) return;
        if (this.arrays[index].l >= l && this.arrays[index].r <= r) {
            this.arrays[index].lazy = !this.arrays[index].lazy;
            this.arrays[index].value = this.arrays[index].r - this.arrays[index].l + 1 - this.arrays[index].value;
        } else {
            pushDown(index);
            modify(1 + 2 * index, l, r);
            modify(2 + 2 * index, l, r);
            this.arrays[index].value = this.arrays[1 + 2 * index].value + this.arrays[2 + 2 * index].value;
        }
    }

    private int query(int index, int l, int r) {
        if (this.arrays[index].l > r || this.arrays[index].r < l) return 0;
        if (this.arrays[index].l >= l && this.arrays[index].r <= r) {
            return this.arrays[index].value;
        }
        if (this.arrays[index].lazy) pushDown(index);
        return query(l, r, 1 + 2 * index) + query(l, r, 2 + 2 * index);
    }
}

class SegNode {
    int l, r, value;
    boolean lazy;

    public SegNode() {
    }

    public SegNode(int l, int r, int value, boolean lazy) {
        this.l = l;
        this.r = r;
        this.value = value;
        this.lazy = lazy;
    }
}
