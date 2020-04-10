package com.roiocam.algorithm.sort;

/**
 * 插入排序
 * <p>
 * 通过比较找到合适的位置插入元素来达到排序
 * </p>
 *
 * @author Andy Chen
 * @date 2020/1/5 下午4:01
 */
public class InsertSort implements Sort {

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }
}
