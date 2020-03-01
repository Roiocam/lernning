package com.roiocam.algorithm.sort;

/**
 * 希尔排序
 * <p>
 *
 * </p>
 *
 * @author Andy Chen
 * @date 2020/1/6 下午3:57
 */
public class ShellSort implements Sort {
    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 3; gap > 0; gap /= 3) {
            for (int i = gap; i < n; i++) {
                int key = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > key) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = key;
            }
        }
    }
}
