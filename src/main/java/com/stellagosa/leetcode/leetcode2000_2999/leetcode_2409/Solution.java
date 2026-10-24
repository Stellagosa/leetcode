package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2409;

/**
 * @author Stellagosa
 * @description 2409.统计共同度过的日子数
 * @date 10/24/2026 9:00 AM Saturday
 */
public class Solution {

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] daysOfYear = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        int a1 = daysOfYear[(arriveAlice.charAt(0) - '0') * 10 + (arriveAlice.charAt(1) - '0') - 1]
                + (arriveAlice.charAt(3) - '0') * 10 + (arriveAlice.charAt(4) - '0');
        int l1 = daysOfYear[(leaveAlice.charAt(0) - '0') * 10 + (leaveAlice.charAt(1) - '0') - 1]
                + (leaveAlice.charAt(3) - '0') * 10 + (leaveAlice.charAt(4) - '0');
        int a2 = daysOfYear[(arriveBob.charAt(0) - '0') * 10 + (arriveBob.charAt(1) - '0') - 1]
                + (arriveBob.charAt(3) - '0') * 10 + (arriveBob.charAt(4) - '0');
        int l2 = daysOfYear[(leaveBob.charAt(0) - '0') * 10 + (leaveBob.charAt(1) - '0') - 1]
                + (leaveBob.charAt(3) - '0') * 10 + (leaveBob.charAt(4) - '0');

        if (l1 < a2 || l2 < a1) return 0;
        return Math.min(l1, l2) - Math.max(a1, a2) + 1;
    }
}
