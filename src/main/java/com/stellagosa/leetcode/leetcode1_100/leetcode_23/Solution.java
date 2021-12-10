package com.stellagosa.leetcode.leetcode1_100.leetcode_23;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:27
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] arr = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
        ListNode[] lists = new ListNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode();
            ListNode pre = node;
            for (int j = 0; j < arr[i].length; j++) {
                node.next = new ListNode(arr[i][j]);
                node = node.next;
            }
            lists[i] = pre.next;
        }
        ListNode listNode = solution.mergeKLists(lists);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root;
        ListNode pre = new ListNode();
        root = pre;
        while (true) {
            ListNode node = minNode(lists);
            if (node == null) break;
            pre.next = node;
            pre = pre.next;
        }
        return root.next;
    }

    private ListNode minNode(ListNode[] lists) {
        ListNode min = new ListNode(Integer.MAX_VALUE);
        int index = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < min.val) {
                min = lists[i];
                index = i;
            }
        }
        if (index == -1) return null;
        lists[index] = lists[index].next;
        min.next = null;
        return min;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

}

