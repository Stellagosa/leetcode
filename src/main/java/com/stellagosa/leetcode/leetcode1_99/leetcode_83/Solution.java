package com.stellagosa.leetcode.leetcode1_99.leetcode_83;

/**
 * @author Stellagosa
 * @description 删除排序链表中的重复元素
 * @date 2024/1/14 19:35 星期日
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        while (node.next != null) {
            ListNode next = node.next;
            if (node.val == next.val) {
                node.next = next.next;
            } else {
                node = next;
            }
        }
        return head;
    }

    public static class ListNode {
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


}