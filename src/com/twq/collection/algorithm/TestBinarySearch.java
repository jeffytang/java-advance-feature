package com.twq.collection.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestBinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 11, 19, 23, 27, 33, 45, 55, 67, 98};

        int target = 1000;

        // 查找数组中是否有某个指定的元素
        // 可以使用 Java 提供的工具方法来做二分查找
        int index = Arrays.binarySearch(arr, target);

        List<Integer> list = Arrays.asList(new Integer[]{8, 11, 19, 23, 27, 33, 45, 55, 67, 98});
        // 集合的二分查找工具方法
        index = Collections.binarySearch(list, target);
        System.out.println(index);
    }

    /**
     *  二分查找数组是否存在某个指定的元素
     * @param arr   数组
     * @param target    指定的元素
     * @return  指定的元素所在的下标，如果不存在的话，返回 -1
     */
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                // 找到了指定元素，直接返回元素在数组中所在的下标
                return mid;
            } else if (arr[mid] < target) {
                // 表示指定的元素肯定在右边
                low = mid + 1;
            } else {
                // 表示指定的元素肯定在左边
                high = mid - 1;
            }
        }
        // 数组中没有找到指定的元素的值
        return -1;
    }

    /**
     * 查找数组中是否有某个指定的元素
     * 存在一个问题：随着数组的长度变大，需要循环遍历的次数变多，性能下降
     * @param arr   数组
     * @param target    指定的元素值
     * @return  指定的元素值在数组中的下标
     */
    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            if (element == target) {
                return i;
            }
        }
        return -1;
    }
}
