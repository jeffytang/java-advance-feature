package com.twq.collection.algorithm;

import java.util.*;

/**
 *  基本类型数组的排序算法的工具类，提供了四种排序算法的实现：
 *  1. 冒泡
 *  2. 插入
 *  3. 归并
 *  4. 快排
 */
public class PrimitiveTypeSortUtil {
    /**
     *  快排
     * @param arr
     */
    public static void quickSort(int[] arr) {
        int length = arr.length;
        if (length <= 1) return;

        quickSort(arr, 0, length - 1);
    }

    private static void quickSort(int[] arr, int p, int r) {
        // 终止条件
        if (p >= r) return;
        // 分区，返回分区之后的分区点所在的元素的下标
        int q = partition(arr, p, r);
        // 递归对分区点左边的数组进行快排
        quickSort(arr, p, q - 1);
        // 递归对分区点右边的数组进行快排
        quickSort(arr, q + 1, r);
    }

    /**
     *  分区的方法
     * @param arr   需要分区的数组
     * @param p 数组的第一个元素的下标
     * @param r 数组的最后一个元素的下标
     * @return  分区点所在的元素的下标
     */
    private static int partition(int[] arr, int p, int r) {
        // 定义分区点为最后一个元素
        int pivot = arr[r];
        // 定义两个下标，都是从第一个元素开始
        int i = p;
        for (int j = p; j <= r -1; j++) {
            // 如果元素小于分区点的元素的话
            if (arr[j] < pivot) {
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
     *  快排
     * @param arr
     */
    public static void quickSort(long[] arr) {
        int length = arr.length;
        if (length <= 1) return;

        quickSort(arr, 0, length - 1);
    }

    private static void quickSort(long[] arr, int p, int r) {
        // 终止条件
        if (p >= r) return;
        // 分区，返回分区之后的分区点所在的元素的下标
        int q = partition(arr, p, r);
        // 递归对分区点左边的数组进行快排
        quickSort(arr, p, q - 1);
        // 递归对分区点右边的数组进行快排
        quickSort(arr, q + 1, r);
    }

    /**
     *  分区的方法
     * @param arr   需要分区的数组
     * @param p 数组的第一个元素的下标
     * @param r 数组的最后一个元素的下标
     * @return  分区点所在的元素的下标
     */
    private static int partition(long[] arr, int p, int r) {
        // 定义分区点为最后一个元素
        long pivot = arr[r];
        // 定义两个下标，都是从第一个元素开始
        int i = p;
        for (int j = p; j <= r -1; j++) {
            // 如果元素小于分区点的元素的话
            if (arr[j] < pivot) {
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
     * 归并排序
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        int length = arr.length;
        int[] tmpArr = new int[length];
        mergeSort(arr, tmpArr, 0, length - 1);
    }

    private static void mergeSort(int[] arr, int[] tmpArr,  int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 归并排序左边的
            mergeSort(arr, tmpArr,  left, mid);
            // 归并排序右边的
            mergeSort(arr, tmpArr, mid + 1, right);

            // 将左边的元素和右边的元素按照顺序合并
            merge(arr, tmpArr, left, mid + 1, right);
        }
    }

    /**
     *  将左边的元素和右边的元素按照顺序合并
     * @param arr   数组
     * @param tmpArr 临时数组
     * @param leftPos   左边数组的开始下标
     * @param rightPos  右边数组的开始下标
     * @param rightEnd  右边数组的结束下标
     */
    private static void merge(int[] arr, int[] tmpArr,
                              int leftPos, int rightPos, int rightEnd) {
        // 左边数组的结束下标
        int leftEnd = rightPos - 1;
        // 定义临时数组的下标
        int tmpPos = leftPos;
        // 计算需要合并排序的元素个数
        int numElements = rightEnd - leftPos + 1;

        // 对比左边和右边数组的元素，小的元素先放入到临时数组中
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (arr[leftPos] > arr[rightPos]) {
                tmpArr[tmpPos++] = arr[rightPos++];
            } else {
                tmpArr[tmpPos++] = arr[leftPos++];
            }
        }

        // 将左边数组剩下的元素拷贝到临时数组中
        while (leftPos <= leftEnd) {
            tmpArr[tmpPos++] = arr[leftPos++];
        }

        // 将右边的数组剩下的元素拷贝到临时数组中
        while (rightPos <= rightEnd) {
            tmpArr[tmpPos++] = arr[rightPos++];
        }

        // 将临时数组元素拷贝到原来的数组中
        for (int i = 0; i < numElements; i++, rightEnd--) {
            arr[rightEnd] = tmpArr[rightEnd];
        }
    }

    /**
     *  插入排序
     * @param arr 需要排序的数组
     * @param n 数组的长度
     */
    public static void insertionSort(int[] arr, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; i++) { // 控制插入排序的次数
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (arr[j] > value) {
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
     *  冒泡排序
     * @param arr   要排序的数组
     * @param n 数组的长度
     */
    public static void bubbleSort(int[] arr, int n) {
        // 边界条件
        if (n <= 1) return;

        for (int i = 0; i < n; i++) { // 控制冒泡的次数
            // 判断每次冒泡是否有数据交换
            boolean hasSwap = false;
            for (int j = 0; j < n - 1 - i; j++) {
                // 如果大的数在前面的话，就需要交换元素
                if (arr[j] > arr[j + 1]) {
                    // 元素交换
                    swap(arr, j, j + 1);
                    hasSwap = true;
                }
            }
            // 如果没有数据交换了，说明已经排好序了，直接退出循环
            if (!hasSwap) break;
        }
    }

    /**
     *  数组元素交换
     * @param arr   数组
     * @param i 需要交换的元素下标 i
     * @param j 需要交换的元素下标 j
     */
    private static void swap(long[] arr, int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     *  数组元素交换
     * @param arr   数组
     * @param i 需要交换的元素下标 i
     * @param j 需要交换的元素下标 j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
