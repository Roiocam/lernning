package com.roiocam.algorithm.sort;

/**
 * 算法: 计数排序
 * 时间复杂度: 线性O(N+K)
 *
 * @author Andy Chen
 * @date 2020/1/6 下午3:58
 */
public class CountingSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int max = Integer.MIN_VALUE;
        //找到数组的最大数
        for (int a : arr) {
            if (a > max) {
                max = a;
            }
        }
        int[] count = new int[max + 1];
        countSort(arr, count);
    }

    private void countSort(int[] arr, int[] count) {
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int[] sorted = new int[arr.length];
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            int tmp = count[i];
            while (tmp > 0) {
                sorted[index++] = i;
                tmp--;
            }
        }
        System.arraycopy(sorted, 0, arr, 0, arr.length);
    }
}
