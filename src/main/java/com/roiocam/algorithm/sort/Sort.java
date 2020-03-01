package com.roiocam.algorithm.sort;

/**
 * 排序接口
 *
 * @author Andy Chen
 * @date 2020/1/5 下午4:06
 */
public interface Sort {
    /**
     * 排序
     *
     * @param arr
     */
    void sort(int[] arr);

    /**
     * 交换数组位置
     *
     * @param arr
     * @param i
     * @param j
     */
    default void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
