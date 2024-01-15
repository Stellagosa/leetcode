package com.stellagosa.leetcode.leetcode1_99.leetcode_82;

/**
 * @author Stellagosa
 * @description 删除排序链表中的重复元素Ⅱ
 * @date 2024/1/15 7:41 星期一
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = new ListNode();
        p.next = head;
        ListNode node = p;
        while (node != null) {
            ListNode next = node.next;
            if (next != null) {
                ListNode next_next = next.next;
                while (next_next != null && next.val == next_next.val) {
                    next_next = next_next.next;
                }
                if (next.next != next_next) {
                    node.next = next_next;
                    // 1,2,3,3,4,4,5,删除3,3后接着判断4,4
                    continue;
                }
            }
            node = node.next;
        }
        return p.next;
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
