package com.stellagosa.leetcode.leetcode100_999.leetcode_846;

import java.util.Arrays;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/30 10:24
 * @Description: 一手顺子
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] hand = {1, 1, 2, 2, 3, 3};
        System.out.println(solution.isNStraightHand(hand, 2));
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (groupSize == 1) return true;
        if (hand.length % groupSize != 0) return false;
        Arrays.sort(hand);
        return check(0, hand, groupSize);
    }

    private boolean check(int begin, int[] hand, int groupSize) {
        int count = 0;
        while (begin < hand.length && hand[begin] == -1) {
            begin++;
        }
        if (begin == hand.length) return true;
        int num = hand[begin];
        int index = begin;
        while (index < hand.length) {
            if (hand[index] > num + count) {
                return false;
            }
            if (hand[index] == num + count) {
                hand[index] = -1;
                count++;
                if (count == groupSize) break;
            }
            index++;
        }
        if (index == hand.length) {
            if (count != groupSize) return false;
        }
        return check(begin + 1, hand, groupSize);
    }


    // public boolean isNStraightHand(int[] hand, int groupSize) {
    //     if (groupSize == 1) return true;
    //     if (hand.length % groupSize != 0) return false;
    //     Arrays.sort(hand);
    //     LinkedList<Integer> list = new LinkedList<>();
    //     for (int item : hand) {
    //         list.add(item);
    //     }
    //     return check(list, groupSize);
    // }
    //
    // private boolean check(LinkedList<Integer> list, int groupSize) {
    //     if (list.isEmpty()) return true;
    //     int count = 0;
    //     Integer num = list.get(0);
    //     while (count < groupSize) {
    //         boolean remove = list.removeFirstOccurrence(num + count);
    //         if (!remove) return false;
    //         count++;
    //     }
    //     return check(list, groupSize);
    // }
}
