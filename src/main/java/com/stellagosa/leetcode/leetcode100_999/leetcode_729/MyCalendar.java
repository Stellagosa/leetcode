package com.stellagosa.leetcode.leetcode100_999.leetcode_729;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author: Stellagosa
 * @Date: 2022/7/5 6:09
 * @Description: 我的日程安排表I
 */
public class MyCalendar {

    TreeSet<int[]> set;

    public MyCalendar() {
        set = new TreeSet<>((o1, o2) -> {
            if (o1[1] <= o2[0]) {
                return -1;
            } else if (o2[1] <= o1[0]) {
                return 1;
            } else return 0;
        });
    }

    public boolean book(int start, int end) {
        int[] temp = new int[]{start, end};
        return set.add(temp);
    }
}

// public class MyCalendar {
//
//     List<List<Integer>> list;
//
//     public MyCalendar() {
//         list = new ArrayList<>();
//     }
//
//     public boolean book(int start, int end) {
//         for (List<Integer> book : list) {
//             if (book.get(1) > start && end > book.get(0)) return false;
//         }
//         List<Integer> temp = new ArrayList<>();
//         temp.add(start);
//         temp.add(end);
//         list.add(temp);
//         return true;
//     }
// }

// {s1,e1} {s2,e2}，没有产生交集，则 e1<=s2||e2<=s1
// 则产生交集为 !(e1<=s2||e2<=s1) = !(e1<=s2)&&!(e2<=s1) = e1>s2&&e2>s1
