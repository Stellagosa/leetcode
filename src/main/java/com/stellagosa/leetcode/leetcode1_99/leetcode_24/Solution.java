package com.stellagosa.leetcode.leetcode1_99.leetcode_24;

/**
 * @Author: Stellagosa
 * @Date: 2023/8/7 8:20
 * @Description: 两两交换链表中的节点
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = head;
        ListNode parent = new ListNode();
        parent.next = head;
        head = head.next;
        while (node != null && node.next != null) {
            parent.next = node.next;
            parent = node;
            node = node.next.next;
            parent.next.next = parent;
            parent.next = node;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
