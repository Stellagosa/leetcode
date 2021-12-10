package com.stellagosa.leetcode.leetcode101_1000.leetcode_147;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:45
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{-1, 5, 3, 4, 0};

        ListNode p = new ListNode();
        ListNode q = p;

        for (int num : nums) {
            q.next = new ListNode(num);
            q = q.next;
        }

        ListNode listNode = solution.insertionSortList(p.next);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode p = new ListNode();
        p.next = head;
        head = p;
        p = head.next.next;
        head.next.next = null;

        // (0, p) 有序
        // null,-1,5,3,4,0
        while (p != null) {
            ListNode cur = head.next;
            ListNode pre = head;
            while (cur != null && cur.val < p.val) {
                cur = cur.next;
                pre = pre.next;
            }
            ListNode temp = p;
            p = p.next;
            temp.next = cur;
            pre.next = temp;
        }

        return head.next;
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

