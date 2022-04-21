package com.stellagosa.leetcode.leetcode100_999.leetcode_824;

/**
 * @Author: Stellagosa
 * @Date: 2022/4/21 15:26
 * @Description: 山羊拉丁文
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String sentence = "I speak Goat Latin";
        System.out.println(solution.toGoatLatin(sentence));
    }

    public String toGoatLatin(String sentence) {
        String[] strings = sentence.split(" ");
        StringBuilder builder = new StringBuilder();

        String[] temp = {"a", "e", "i", "o", "u", "A", "E", "I", "O", "U"};
        for (int i = 0; i < strings.length; i++) {
            boolean flag = false;
            for (String s : temp) {
                if (strings[i].startsWith(s)) {
                    flag = true;
                    break;
                }
            }
            // 元音字母开头
            if (flag) {
                builder.append(strings[i]);
            } else {
                builder.append(strings[i].substring(1));
                builder.append(strings[i].charAt(0));
            }
            builder.append("ma");
            builder.append("a".repeat(i + 1));
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}
