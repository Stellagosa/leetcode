package com.stellagosa.leetcode.leetcode100_999.leetcode_478;

import java.util.Random;

/**
 * @Author: Stellagosa
 * @Date: 2022/6/5 8:15
 * @Description: 在圆内随机生成点
 */
public class Solution {
    private final double radius;
    private final double x_center;
    private final double y_center;
    private final Random random;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        this.random = new Random();
    }

    // 在边长2r的正方形内生成点，返回在圆内的
    public double[] randPoint() {
        double x = random.nextDouble() * 2 * this.radius - this.radius;
        double y = random.nextDouble() * 2 * this.radius - this.radius;
        if (x * x + y * y <= this.radius * this.radius) {
            return new double[]{x + this.x_center, y + this.y_center};
        } else return this.randPoint();
    }
}
