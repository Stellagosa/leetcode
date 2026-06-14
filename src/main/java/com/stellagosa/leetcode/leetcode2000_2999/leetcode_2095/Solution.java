package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2095;

/**
 * @author Stellagosa
 * @description 删除链表的中间节点
 * @date 6/15/2026 7:03 AM June
 */
public class Solution {

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        ListNode fast = head, slow = head, prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = slow.next;
        slow.next = null;
        return head;
    }



    private static class ListNode {
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
