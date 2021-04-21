package com.twq.collection.algorithm;

import java.util.Comparator;

/**
 *  引用类型数组的排序算法工具类
 *  使用 java.util.Comparator 比较器实现比较的
 */
public class ComparatorSortUtil {
    /**
     *  引用类型数组的插入排序
     * @param arr   数组
     * @param comparator    比较器
     * @param <T>   任意类型
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        int n = arr.length;
        if (n <= 1) return;

        for (int i = 1; i < n; i++) { // 控制插入排序的次数
            T value = arr[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                // 使用比较器来比较两个人
                // 返回值大于 0 的话，表示前面的人大于后面的人
                // 返回值小于 0 的话，表示前面的人小于后面的人
                // 返回值等于 0 的话，表示前面的人等于后面的人
                if (comparator.compare(arr[j], value) > 0){
                    // 挪动数据
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            // 数据的插入
            arr[j + 1] = value;
        }
    }

    /**
     *  快排
     * @param arr
     */
    public static <T> void quickSort(T[] arr, Comparator<T> comparator) {
        int length = arr.length;
        if (length <= 1) return;

        quickSort(arr, 0, length - 1, comparator);
    }

    private static <T> void quickSort(T[] arr, int p, int r, Comparator<T> comparator) {
        // 终止条件
        if (p >= r) return;
        // 分区，返回分区之后的分区点所在的元素的下标
        int q = partition(arr, p, r, comparator);
        // 递归对分区点左边的数组进行快排
        quickSort(arr, p, q - 1, comparator);
        // 递归对分区点右边的数组进行快排
        quickSort(arr, q + 1, r, comparator);
    }

    /**
     *  分区的方法
     * @param arr   需要分区的数组
     * @param p 数组的第一个元素的下标
     * @param r 数组的最后一个元素的下标
     * @return  分区点所在的元素的下标
     */
    private static <T> int partition(T[] arr, int p, int r, Comparator<T> comparator) {
        // 定义分区点为最后一个元素
        T pivot = arr[r];
        // 定义两个下标，都是从第一个元素开始
        int i = p;
        for (int j = p; j <= r -1; j++) {
            // 如果元素小于分区点的元素的话
            if (comparator.compare(arr[j], pivot) < 0) {
                // 交换元素
                swap(arr, i, j);
                i++;
            }
        }
        // 交换分区点元素和 i下标对应的元素
        swap(arr, i, r);
        // 返回分区点所在的元素的下标
        return i;
    }

    /**
     *  数组元素交换
     * @param arr   数组
     * @param i 需要交换的元素下标 i
     * @param j 需要交换的元素下标 j
     */
    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
