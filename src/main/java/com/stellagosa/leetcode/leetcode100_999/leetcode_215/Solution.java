package com.stellagosa.leetcode.leetcode100_999.leetcode_215;

import java.util.Random;

/**
 * @Author: Stellagosa
 * @Date: 2022/5/19 8:58
 * @Description: 数组中第k个最大元素
 */
public class Solution {

    Random random = new Random();

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 2, 1, 15, 6, 11, 32, 54, 3, 7};
        System.out.println(solution.findKthLargest(nums, 4));
    }

    // 每次快排都可以确定一个元素的位置，只要找到倒数第k个就可以了
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSort(int[] arr, int left, int right, int target) {
        if (left < right) {
            int mid = partition(arr, left, right);
            if (mid == target) return arr[mid];
            if (mid > target) return quickSort(arr, left, mid - 1, target);
            else return quickSort(arr, mid + 1, right, target);
        }
        return arr[left];
    }

    public int partition(int[] arr, int left, int right) {
        int index = random.nextInt(right - left + 1) + left;
        swap(arr, index, right);
        int target = arr[right];
        int pre = left;
        int cur = left;
        while (pre < right) {
            if (arr[pre] < target) {
                swap(arr, cur, pre);
                cur++;
            }
            pre++;
        }
        swap(arr, right, cur);
        return cur;
    }

    // 快读排序随机化
    // public int findKthLargest(int[] nums, int k) {
    //     quickSort(nums, 0, nums.length - 1);
    //     return nums[nums.length - k];
    // }
    //
    // public void quickSort(int[] arr, int left, int right) {
    //     if (left < right) {
    //         int mid = partition(arr, left, right);
    //         quickSort(arr, left, mid - 1);
    //         quickSort(arr, mid + 1, right);
    //     }
    // }
    //
    // public int partition(int[] arr, int left, int right) {
    //     int index = random.nextInt(right - left + 1) + left;
    //     swap(arr, index, right);
    //     int target = arr[right];
    //     int pre = left;
    //     int cur = left;
    //     while (pre < right) {
    //         if (arr[pre] < target) {
    //             swap(arr, cur, pre);
    //             cur++;
    //         }
    //         pre++;
    //     }
    //     swap(arr, right, cur);
    //     return cur;
    // }

    public void swap(int[] arr, int a1, int a2) {
        int temp = arr[a1];
        arr[a1] = arr[a2];
        arr[a2] = temp;
    }

    // // 快读排序
    // public int findKthLargest(int[] nums, int k) {
    //     quickSort(nums, 0, nums.length - 1);
    //     return nums[nums.length - k];
    // }
    //
    // public void quickSort(int[] arr, int left, int right) {
    //     if (left < right) {
    //         int mid = partition(arr, left, right);
    //         quickSort(arr, left, mid - 1);
    //         quickSort(arr, mid + 1, right);
    //     }
    // }
    //
    // public int partition(int[] arr, int left, int right) {
    //     int target = arr[right];
    //     int pre = left;
    //     int cur = left;
    //     while (pre < right) {
    //         if (arr[pre] < target) {
    //             int temp = arr[cur];
    //             arr[cur] = arr[pre];
    //             arr[pre] = temp;
    //             cur++;
    //         }
    //         pre++;
    //     }
    //     int temp = arr[cur];
    //     arr[cur] = arr[right];
    //     arr[right] = temp;
    //     return cur;
    // }


    // // 构建大顶堆
    // public int findKthLargest(int[] nums, int k) {
    //     buildHeap(nums);
    //     int heapSize = nums.length;
    //     int res = nums[0];
    //     for (int i = 0; i < k; i++) {
    //         res = deleteTopEle(nums, heapSize);
    //         heapSize--;
    //     }
    //     return res;
    // }
    //
    // // 大顶堆建堆
    // public void buildHeap(int[] arr) {
    //     for (int i = arr.length >> 1; i >= 0; i--) {
    //         maxHeapify(arr, i, arr.length);
    //     }
    // }
    //
    // // 删除大顶堆头元素
    // public int deleteTopEle(int[] arr, int heapSize) {
    //     int res = arr[0];
    //     arr[0] = arr[heapSize - 1];
    //     heapSize--;
    //     maxHeapify(arr, 0, heapSize);
    //     return res;
    // }
    //
    // // 调整大顶堆
    // public void maxHeapify(int[] arr, int index, int heapSize) {
    //     // 左右孩子节点
    //     int left = (index << 1) + 1;
    //     int right = left + 1;
    //     // 找出最大节点
    //     int largest = index;
    //     if (left < heapSize && arr[left] > arr[index]) {
    //         largest = left;
    //     }
    //
    //     if (right < heapSize && arr[right] > arr[largest]) {
    //         largest = right;
    //     }
    //
    //     // 最大节点还是 index 节点，不用调整
    //     if (index == largest) return;
    //
    //     // 交换index 和最大节点
    //     int temp = arr[index];
    //     arr[index] = arr[largest];
    //     arr[largest] = temp;
    //
    //     // 递归调正调整后的最大节点
    //     maxHeapify(arr, largest, heapSize);
    // }
}
