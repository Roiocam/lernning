package com.roiocam.algorithm.sort;

/**
 * 堆排序
 * <p>
 * 借助堆来实现的选择排序，
 * </p>
 *
 * @author Andy Chen
 * @date 2020/1/5 下午5:36
 */
public class HeapSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int n = arr.length;
        //(n/2 -1) ,当n=7时， 当前i为2,也就是完全二叉树顶点的右孩子，最后一个小树的顶点。从这里开始最大堆化
        for (int i = n / 2 - 1; i >= 0; i--) {
            //heapify最大堆化
            heapify(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            //交换顶点到最后
            swap(arr, i, 0);
            //将剩余的数最大堆化,当前i会慢慢递减
            heapify(arr, i, 0);
        }
    }

    /**
     * 最大堆化
     *
     * @param arr 数组
     * @param n   当前数组size
     * @param i   起始index
     */
    private void heapify(int[] arr, int n, int i) {
        //设当前顶点为最大数
        int largest = i;
        //左右子节点
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        //发生了顶点变化，
        if (largest != i) {
            //交换实际位置
            swap(arr, largest, i);
            heapify(arr, n, largest);
        }
    }
}

