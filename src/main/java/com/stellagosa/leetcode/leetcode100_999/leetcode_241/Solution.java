package com.stellagosa.leetcode.leetcode100_999.leetcode_241;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2022/7/1 5:52
 * @Description: 为运算表达式设计优先级
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // List<Integer> res = solution.diffWaysToCompute("2-1-1");
        List<Integer> res = solution.diffWaysToCompute("2*3-4*5");
        for (Integer item : res) {
            System.out.println(item);
        }
    }

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        if (!expression.contains("+") && !expression.contains("-") && !expression.contains("*")) {
            res.add(Integer.parseInt(expression));
            return res;
        }
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> res1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> res2 = diffWaysToCompute(expression.substring(i + 1));
                for (Integer num1 : res1) {
                    for (Integer num2 : res2) {
                        switch (ch) {
                            case '+':
                                res.add(num1 + num2);
                                break;
                            case '-':
                                res.add(num1 - num2);
                                break;
                            case '*':
                                res.add(num1 * num2);
                                break;
                        }
                    }
                }
            }
        }
        return res;
    }
}
