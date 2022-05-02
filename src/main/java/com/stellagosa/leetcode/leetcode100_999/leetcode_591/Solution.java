package com.stellagosa.leetcode.leetcode100_999.leetcode_591;

import java.util.Stack;

/**
 * @Author: Stellagosa
 * @Date: 2022/5/2 9:05
 * @Description: 标签验证器
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String code = "<A><!A></A>";
        System.out.println(solution.isValid(code));
    }

    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        int n = code.length();

        int i = 0;
        while (i < n) {
            if (code.charAt(i) == '<') {
                if (i == n - 1) {
                    return false;
                }
                if (code.charAt(i + 1) == '/') {
                    // 结束标签
                    // 查找结束位置
                    int end = code.indexOf(">", i);
                    if (end < 0) {
                        // 该标签没有结束符
                        return false;
                    }
                    // 取标签
                    String tag = code.substring(i + 2, end);
                    // 这是标签结束位置，则栈顶肯定也是这个，否则返回false
                    if (stack.isEmpty() || !stack.peek().equals(tag)) {
                        return false;
                    }
                    // 匹配了栈顶弹出
                    stack.pop();

                    i = end + 1;

                    if (stack.isEmpty() && i != n) {
                        // code必须被一个大的标签包裹
                        // 栈空了，但是还没有结束，则code没有被一个标签包裹，返回false
                        return false;
                    }
                } else if (code.charAt(i + 1) == '!') {
                    // cdata

                    // cdata 必须包含在标签中
                    if (stack.isEmpty()) {
                        return false;
                    }
                    // 判断长度是否够长，否则substring会报错
                    if (i + 9 > n) {
                        return false;
                    }

                    String cdata = code.substring(i, i + 9);
                    if (!"<![CDATA[".equals(cdata)) {
                        return false;
                    }

                    int cdataEnd = code.indexOf("]]>", i + 9);
                    if (cdataEnd < 0) {
                        return false;
                    }

                    i = cdataEnd + 1;

                } else {
                    // 起始标签
                    int end = code.indexOf(">", i);
                    if (end < 0) {
                        return false;
                    }

                    String tag = code.substring(i + 1, end);

                    // 标签长度限制
                    if (tag.length() < 1 || tag.length() > 9) {
                        return false;
                    }

                    // 标签必须大写字母
                    for (int j = 0; j < tag.length(); j++) {
                        if (tag.charAt(j) < 'A' || tag.charAt(j) > 'Z') {
                            return false;
                        }
                    }

                    stack.push(tag);
                    i = end + 1;
                }
            } else {
                // 读到非标签的内容，肯定是在标签内部，栈肯定不能为空
                if (stack.isEmpty()) {
                    return false;
                }
                i++;
            }
        }
        // 结束栈必须为空
        return stack.isEmpty();
    }
}
