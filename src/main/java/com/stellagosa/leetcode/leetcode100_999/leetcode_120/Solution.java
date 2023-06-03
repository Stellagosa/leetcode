package com.stellagosa.leetcode.leetcode100_999.leetcode_120;

import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/2 下午 07:11
 * @Description: 三角形最小路径和
 */
public class Solution {

    // 从下到上，会修改原数据
    // 可以用类似从上到下的方式，声明一个空间交替使用，就不用修改原数据
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle.get(i).set(j,
                        Math.min(
                                triangle.get(i + 1).get(j),
                                triangle.get(i + 1).get(j + 1)
                        )
                                + triangle.get(i).get(j)
                );
            }
        }
        return triangle.get(0).get(0);
    }


// 从上到下一层层计算
//    public int minimumTotal(List<List<Integer>> triangle) {
//        List<Integer> pre = new ArrayList<>();
//        for (List<Integer> list : triangle) {
//            List<Integer> cur = new ArrayList<>(list.size());
//            for (int i = 0; i < list.size(); i++) {
//                int firstNum = Integer.MAX_VALUE;
//                if (i - 1 >= 0 && i - 1 < pre.size()) {
//                    firstNum = pre.get(i - 1);
//                }
//                int secondNum = Integer.MAX_VALUE;
//                if (i < pre.size()) {
//                    secondNum = pre.get(i);
//                }
//                int curNum = list.get(i);
//                if (firstNum != Integer.MAX_VALUE || secondNum != Integer.MAX_VALUE) {
//                    curNum += Math.min(firstNum, secondNum);
//                }
//                cur.add(curNum);
//            }
//            pre = cur;
//        }
//        int min = Integer.MAX_VALUE;
//        for (Integer integer : pre) {
//            min = Math.min(integer, min);
//        }
//        return min;
//    }
}
