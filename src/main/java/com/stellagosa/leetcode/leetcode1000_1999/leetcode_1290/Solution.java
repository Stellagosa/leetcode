package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1290;

/**
 * @author Stellagosa
 * @description 二进制链表转整数
 * @date 2025/7/14 10:38 星期一
 */
public class Solution {

    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res <<= 1;
            res += head.val;
            head = head.next;
        }
        return res;
    }

    public static class ListNode {
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


}


