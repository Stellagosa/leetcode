package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1171;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/11 上午 10:50
 * @Description: 从链表中删去总和值为零的连续节点
 */
public class Solution {

    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) return null;
        int sum = 0;
        ListNode node = head;
        while (node != null) {
            sum += node.val;
            if (sum == 0) {
                return removeZeroSumSublists(node.next);
            }
            node = node.next;
        }
        head.next = removeZeroSumSublists(head.next);
        return head;
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

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
