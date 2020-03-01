package com.roiocam.algorithm.sort;


/**
 * 冒泡排序
 * <p>
 * 通过与相邻元素的比较和交换来把小的数交换到最前面
 * </p>
 *
 * @author Andy Chen
 * @date 2020/1/5 下午3:14
 */
public class BubbleSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }


}
