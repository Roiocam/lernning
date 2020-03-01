package com.roiocam.algorithm.sort;

/**
 * @author Andy Chen
 * @date 2020/2/28 上午12:20
 */
public class QuickSortImpl implements Sort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);

    }

    private void quickSort(int[] unsorted, int left, int right) {
        if (left < right) {
            //分区
            int partitionIndex = partition(unsorted, left, right);
            if (partitionIndex > 0) {
                //快排左半部分
                quickSort(unsorted, left, partitionIndex );
            }
            if (partitionIndex < right) {
                //快排右半部分
                quickSort(unsorted, partitionIndex + 1, right);
            }

        }
    }

    private int partition(int[] unsorted, int left, int right) {
        int pivot = unsorted[(left + right) / 2];
        int i = left - 1;
        int j = right + 1;
        while (true) {
            do {
                i++;
            } while (unsorted[i] < pivot);
            do {
                j--;
            } while (unsorted[j] > pivot);
            //相遇
            if (i >= j) {
                return j;
            }
            swap(unsorted, i, j);
        }
    }
    // private int partition(int[] unsorted, int left, int right) {
    //     int pivot = unsorted[right];
    //     int index = left;
    //     for (int i = left; i <= right; i++) {
    //         if (unsorted[i] < pivot) {
    //             swap(unsorted, index, i);
    //             index++;
    //         }
    //     }
    //     swap(unsorted, index, right);
    //     return index;
    // }

}
