package com.stellagosa.offer_II.offer_041;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Stellagosa
 * @Date: 2022/7/16 5:30
 * @Description: 滑动窗口的平均值
 */
public class MovingAverage {

    public static void main(String[] args) {
        MovingAverage o = new MovingAverage(3);
        int[] arr = {1, 10, 3, 5};
        for (int num : arr) {
            System.out.println(o.next(num));
        }
    }

    private final int[] arr;
    private int last;
    private int count;
    private final int size;
    private double sum;

    public MovingAverage(int size) {
        arr = new int[size];
        this.size = size;
        this.last = -1;
        this.count = 0;
        this.sum = 0;
    }

    public double next(int val) {
        if (count == size) {
            last = (last + 1) % size;
            sum -= arr[last];
            arr[last] = val;
            sum += val;
            return sum / size;
        } else {
            count++;
            last++;
            arr[last] = val;
            sum += val;
            return sum / (last + 1);
        }
    }


    // private final Queue<Integer> queue;
    // private final int size;
    // private double count;
    //
    // public MovingAverage(int size) {
    //     this.queue = new LinkedList<>();
    //     this.size = size;
    //     this.count = 0;
    // }
    //
    // public double next(int val) {
    //     if (queue.size() == this.size) {
    //         this.count -= queue.remove();
    //     }
    //     this.queue.offer(val);
    //     this.count += val;
    //     return count / this.queue.size();
    // }
}
