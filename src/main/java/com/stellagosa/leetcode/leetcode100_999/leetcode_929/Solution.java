package com.stellagosa.leetcode.leetcode100_999.leetcode_929;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Stellagosa
 * @Date: 2022/6/4 6:15
 * @Description: 独特的电子邮箱地址
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] emails = {"test.email+alex@leetcode.com","test.email@leetcode.com"};
        System.out.println(solution.numUniqueEmails(emails));
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            StringBuilder builder = new StringBuilder();
            for (char ch : email.toCharArray()) {
                if (ch == '+' || ch == '@') break;
                if (ch != '.') builder.append(ch);
            }
            int index = email.indexOf("@");
            builder.append(email.substring(index));
            set.add(builder.toString());
        }
        return set.size();
    }
}
