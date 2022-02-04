package com.stellagosa.leetcode.leetcode1_99.leetcode_2;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:14
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(9);

        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(2);
        ListNode l7 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        l5.next = l6;
        l6.next = l7;


        Solution solution = new Solution();

        ListNode listNode = solution.addTwoNumbers(l1, l5);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        ListNode l3 = new ListNode();
        ListNode ll = l3;
        while (l1 != null || l2 != null || temp == 1) {
            ListNode listNode = new ListNode();

            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

            listNode.val = (n1 + n2 + temp) % 10;
            temp = (n1 + n2 + temp) / 10;

            l3.next = listNode;
            l3 = l3.next;
        }
        return ll.next;
    }

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int temp = 0;
//        ListNode l3 = new ListNode();
//        ListNode ll = l3;
//        while (l1 != null || l2 != null || temp == 1) {
//            ListNode listNode = new ListNode();
//            if (l1 != null && l2 != null) {
//                if (l1.val + l2.val + temp > 9) {
//                    listNode.val = l1.val + l2.val + temp - 10;
//                    temp = 1;
//                } else {
//                    listNode.val = l1.val + l2.val + temp;
//                    temp = 0;
//                }
//                l1 = l1.next;
//                l2 = l2.next;
//            } else if (l1 == null && l2 != null) {
//                if (l2.val + temp > 9) {
//                    listNode.val = l2.val + temp - 10;
//                    temp = 1;
//                } else {
//                    listNode.val = l2.val + temp;
//                    temp = 0;
//                }
//                l2 = l2.next;
//            } else if (l1 != null && l2 == null) {
//                if (l1.val + temp > 9) {
//                    listNode.val = l1.val + temp - 10;
//                    temp = 1;
//                } else {
//                    listNode.val = l1.val + temp;
//                    temp = 0;
//                }
//                l1 = l1.next;
//            } else {
//                listNode.val = temp;
//                temp = 0;
//            }
//
//            l3.next = listNode;
//            l3 = l3.next;
//        }
//        return ll.next;
//    }
}
