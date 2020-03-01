package com.roiocam.algorithm.search;

/**
 * 线性搜索
 *
 * @author Andy Chen
 * @date 2020/2/26 下午6:57
 */
public class LineSearch implements Search {
    @Override
    public int search(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == n) {
                return i;
            }
        }
        return -1;
    }
}
