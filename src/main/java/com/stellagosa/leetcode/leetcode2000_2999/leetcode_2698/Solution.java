package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2698;

/**
 * @author Stellagosa
 * @description 求一个整数的惩罚数
 * @date 2023/10/25 8:24 星期三
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.punishmentNumber(1000));
    }
    // 1,9,10,36,45,55,82,91,99,100,235,297,369,370,379,414,657,675,703,756,792,909,918,945,964,990,991,999,1000

    public int punishmentNumber(int n) {
        int[] arr = new int[]{1, 9, 10, 36, 45, 55, 82, 91, 99, 100,
                        235, 297, 369, 370, 379, 414, 657, 675, 703, 756,
                        792, 909, 918, 945, 964, 990, 991, 999, 1000};
        int result = 0;
        for (int num : arr) {
            if (num <= n) {
                result += num * num;
            } else {
                break;
            }
        }
        return result;
    }

    // public int punishmentNumber(int n) {
    //     int result = 0;
    //     for (int i = 1; i <= n; ++i) {
    //         if (check(i)) {
    //             System.out.println(i);
    //             result += i * i;
    //         }
    //     }
    //     return result;
    // }
    //
    // // 判断一个数是不是惩罚数
    // private boolean check(int num) {
    //     int p = num * num;
    //     String str = String.valueOf(p);
    //     return dfs(str, num);
    // }
    //
    // private boolean dfs(String str, int num) {
    //     if (("".equals(str) || Integer.parseInt(str) == 0) && num == 0) {
    //         return true;
    //     }
    //     if (!"".equals(str) && Integer.parseInt(str) != 0 && num > 0) {
    //         int n = str.length();
    //         for (int i = 1; i <= n; ++i) {
    //             String begin = str.substring(0, i);
    //             String end = str.substring(i);
    //             if (dfs(end, num - Integer.parseInt(begin))) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

}
