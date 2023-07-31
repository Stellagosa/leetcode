package com.stellagosa.leetcode.leetcode100_999.leetcode_143;

/**
 * @Author: Stellagosa
 * @Date: 2023/7/31 9:06
 * @Description: 重排链表
 */
public class Solution {

    public void reorderList(ListNode head) {
        // 长度为0、1、2直接返回
        if (head == null || head.next == null || head.next.next == null) return;

        // 快慢指针找中间位置，分割成两个链表
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 拆分成两个链表，head/list2
        ListNode list1 = head;
        ListNode list2 = slow.next;
        slow.next = null;

        // 后半链表反转,list2
        ListNode pre = list2.next;
        list2.next = null;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = list2;
            list2 = pre;
            pre = temp;
        }

        // 合并前后两个链表
        while (list2 != null) {
            ListNode temp = list1.next;
            list1.next = list2;
            list2 = list2.next;
            list1.next.next = temp;
            list1 = temp;
        }
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
