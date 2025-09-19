package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3484;

/**
 * @author Stellagosa
 * @description 设计电子表格
 * @date 2025/9/19 9:49 星期五
 */
public class Spreadsheet {

    private int[][] arr;

    public Spreadsheet(int rows) {
        arr = new int[rows][26];
    }

    public void setCell(String cell, int value) {
        int column = cell.charAt(0) - 'A';
        int row = getIntValue(cell.toCharArray(), 1, cell.length() - 1);
        arr[row - 1][column] = value;
    }

    public void resetCell(String cell) {
        setCell(cell, 0);
    }

    public int getValue(String formula) {
        char[] chars = formula.toCharArray();
        int mid = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '+') {
                mid = i;
                break;
            }
        }
        return getValue(chars, 1, mid - 1) + getValue(chars, mid + 1, chars.length - 1);
    }

    private int getValue(char[] chars, int begin, int end) {
        if (chars[begin] >= 'A' && chars[begin] <= 'Z') {
            int column = chars[begin] - 'A';
            int row = getIntValue(chars, begin + 1, end);
            return arr[row - 1][column];
        } else {
            return getIntValue(chars, begin, end);
        }
    }

    private int getIntValue(char[] chars, int begin, int end) {
        int res = 0;
        for (int i = begin; i <= end; i++) {
            res *= 10;
            res += chars[i] - '0';
        }
        return res;
    }

}
