package com.roiocam.algorithm.search;

/**
 * @author Andy Chen
 * @date 2020/2/28 上午2:59
 */
public class BinarySearch implements Search {
    @Override
    public int search(int[] arr, int n) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left ) / 2;
            if (arr[mid] < n) {
                left = mid + 1;
            } else if (arr[mid] > n) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
