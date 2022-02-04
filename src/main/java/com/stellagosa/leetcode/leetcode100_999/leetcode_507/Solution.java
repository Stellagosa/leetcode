package com.stellagosa.leetcode.leetcode100_999.leetcode_507;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/31 11:20
 * @Description: 完美数
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkPerfectNumber(8128));
    }

    // [1,10^8]内就5个完美数。。。。。
    public boolean checkPerfectNumber(int num) {
        return num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336;
    }

//    public boolean checkPerfectNumber(int num) {
//        if (num == 1) return false;
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(num);
//        int target = 2;
//        while (target <= Math.sqrt(num)) {
//            if (num % target == 0) {
//                list.add(target);
//                if (target == num / target) {
//                    break;
//                }
//                list.add(num / target);
//            }
//            target++;
//        }
//        int sum = list.stream().mapToInt(s -> s).sum();
//        return num * 2 == sum;
//    }

//    public boolean checkPerfectNumber(int num) {
//        if (num == 1) return false;
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(num);
//        for (int i = 2; i < list.get(list.size() - 1); i++) {
//            if (num % i == 0) {
//                list.add(i);
//                if (i == num / i) {
//                    break;
//                }
//                list.add(num / i);
//            }
//        }
//        int sum = list.stream().mapToInt(s -> s).sum();
//        return num * 2 == sum;
//    }
}
