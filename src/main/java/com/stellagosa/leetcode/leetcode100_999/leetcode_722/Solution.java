package com.stellagosa.leetcode.leetcode100_999.leetcode_722;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2023/8/3 7:35
 * @Description: 删除注释
 */
public class Solution {

    public List<String> removeComments(String[] source) {
        List<String> result = new LinkedList<>();
        boolean state = false;
        StringBuilder builder = new StringBuilder();
        for (String str : source) {
            for (int i = 0; i < str.length(); ++i) {
                // 块注释
                if (state) {
                    // 块注释结束
                    if (str.charAt(i) == '*' && i + 1 < str.length() && str.charAt(i + 1) == '/') {
                        ++i;
                        state = false;
                    }
                } else {
                    // 块注释开始
                    if (str.charAt(i) == '/' && i + 1 < str.length() && str.charAt(i + 1) == '*') {
                        state = true;
                        ++i;
                    } else if (str.charAt(i) == '/' && i + 1 < str.length() && str.charAt(i + 1) == '/') {
                        // 行注释，结束，后面的不用判断了
                        break;
                    } else {
                        // 即没有块注释，也没有行注释
                        builder.append(str.charAt(i));
                    }
                }
            }
            if (!state && builder.length() > 0) {
                result.add(builder.toString());
                builder.setLength(0);
            }
        }
        return result;
    }

}
