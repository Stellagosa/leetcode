package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2130;

/**
 * @author Stellagosa
 * @description 链表最大孪生和
 * @date 6/14/2026 8:56 AM June
 */
public class Solution {

    public int pairSum(ListNode head) {
        ListNode last = head, prev = null, cur = head;
        while (last != null) {
            last = last.next.next;
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        int max = Integer.MIN_VALUE;
        while (cur != null) {
            max = Math.max(max, cur.val + prev.val);
            prev = prev.next;
            cur = cur.next;
        }
        return max;
    }


    // public int pairSum(ListNode head) {
    //     Deque<ListNode> stack = new ArrayDeque<>();
    //     int n = 0;
    //     ListNode node = head;
    //
    //     while (node != null) {
    //         stack.push(node);
    //         node = node.next;
    //         n++;
    //     }
    //
    //     int max = Integer.MIN_VALUE;
    //     node = head;
    //     for (int i = 0; i <= (n / 2) - 1; i++) {
    //         max = Math.max(max, node.val + stack.pop().val);
    //         node = node.next;
    //     }
    //     return max;
    // }

    // public int pairSum(ListNode head) {
    //     ListNode node = head;
    //     int n = 0;
    //     while (node != null) {
    //         node = node.next;
    //         n++;
    //     }
    //
    //     int[] arr = new int[n];
    //
    //     node = head;
    //     int i = 0;
    //     while (node != null) {
    //         arr[i] = node.val;
    //         node = node.next;
    //         i++;
    //     }
    //
    //     int max = Integer.MIN_VALUE;
    //
    //     for (int j = 0; j <= (n / 2) - 1 ; j++) {
    //         max = Math.max(max, arr[j] + arr[n - 1 - j]);
    //     }
    //     return max;
    // }


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
