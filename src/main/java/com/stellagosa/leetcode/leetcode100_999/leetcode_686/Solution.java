package com.stellagosa.leetcode.leetcode100_999.leetcode_686;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/22 7:43
 * @Description: 重复叠加字符串匹配
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "abc";
        String b = "asdasdasdaasd";
        System.out.println(solution.repeatedStringMatch(a, b));
    }

    public int repeatedStringMatch(String a, String b) {
        if (b.length() < 2 * a.length()) {
            return a.contains(b) ? 1 : (a + a).contains(b) ? 2 : (a + a + a).contains(b) ? 3 : -1;
        } else {
            // 至少含有一个完整匹配
            int first = b.indexOf(a); // 第一次匹配的地方
            // b 字符串从 0 到 first 的部分应该匹配 a 的后半部分
            // 从 first 开始，每 a.length() 长度的 b 就应该匹配 a
            // 最后剩下的结尾应该匹配 a 的前半部
            if (first == -1) return -1;
            int count;
            if (first == 0) {
                count = 1;
            } else {
                String substring = b.substring(0, first);
                int index = a.indexOf(substring);
                // 与 a 的后半截匹配
                if (index > 0 && index + substring.length() == a.length()) {
                    count = 2;
                } else {
                    return -1;
                }
            }
            // 重复匹配 a
            int indexA = 0;
            int indexB = first + a.length();
            char[] arrA = a.toCharArray();
            char[] arrB = b.toCharArray();
            while (indexB < b.length() && arrA[indexA] == arrB[indexB]) {
                indexA++;
                indexB++;
                if (indexA == a.length()) {
                    indexA = 0;
                    count++;
                }
            }
            if (indexB != b.length()) {
                // 说明 b 没有匹配完成，肯定存在不匹配 a 的地方
                return -1;
            } else {
                // 匹配完成，但不确定是否存在结尾部分匹配 a
                // 可以根据 indexA 的值判读，indexA = 0 说明正好结束一轮匹配，否则有一节结尾
                return indexA == 0 ? count : count + 1;
            }
        }
    }
}
