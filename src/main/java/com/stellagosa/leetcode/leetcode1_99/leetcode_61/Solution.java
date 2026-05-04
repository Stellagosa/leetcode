package com.stellagosa.leetcode.leetcode1_99.leetcode_61;

/**
 * @author Stellagosa
 * @description 旋转链表
 * @date 2026/5/5 6:35 星期二
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) return head;
        int n = 1;
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
            n++;
        }
        k %= n;
        if (k == 0) return head;
        ListNode pre_res = head;
        for (int i = 0; i < n - k - 1; i++) {
            pre_res = pre_res.next;
        }
        ListNode res = pre_res.next;
        pre_res.next = null;
        last.next = head;
        return res;
    }

    // public ListNode rotateRight(ListNode head, int k) {
    //     int n = 0;
    //     ListNode node = head;
    //     while (node != null) {
    //         node = node.next;
    //         n++;
    //     }
    //     if (n == 0 || n == 1) return head;
    //     k %= n;
    //     if ( k == 0) return head;
    //
    //     int index = 0;
    //     node = head;
    //     ListNode pre_res = null, last = null;
    //     while (node != null) {
    //         if (index == n - k - 1) {
    //             pre_res = node;
    //         }
    //         if (node.next == null) {
    //             last = node;
    //         }
    //         node = node.next;
    //         index++;
    //     }
    //
    //     ListNode res = pre_res.next;
    //     pre_res.next = null;
    //     last.next = head;
    //     return res;
    // }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
