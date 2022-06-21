package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1108;

/**
 * @Author: Stellagosa
 * @Date: 2022/6/21 7:21
 * @Description: IP地址无效化
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.defangIPaddr("1.1.1.1"));
    }

    public String defangIPaddr(String address) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                builder.append("[.]");
            } else {
                builder.append(address.charAt(i));
            }
        }
        return builder.toString();
    }

    // public String defangIPaddr(String address) {
    //     return address.replace(".", "[.]");
    // }
}
