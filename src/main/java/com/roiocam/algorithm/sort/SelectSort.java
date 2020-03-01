package com.roiocam.algorithm.sort;

/**
 * 选择排序
 * <p>
 * 通过对对整体元素的比较把小的数交换到最前面
 * </p>
 *
 * @author Andy Chen
 * @date 2020/1/5 下午3:41
 */
public class SelectSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int minIndex = 0;
        //遍历所有元素
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            //比较后一个选择是否小于于最小元素，若小于，将最小换到最前
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //如果minIndex不为i，说明找到了更小的值，交换之。
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }
}
