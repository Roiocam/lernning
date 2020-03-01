package com.roiocam.algorithm.sort;

/**
 * 排序: 归并排序
 * 时间复杂度: nlog(n)
 * 空间复杂度: 由于新生成了其他数组，故空间复杂度必不可少
 * 将数组切分为两部分，递归的两部分进行切分，然后进行排序归并。
 * @author Andy Chen
 * @date 2020/1/6 下午3:58
 */
public class MergeSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * @param arr 数组
     * @param lo  起点
     * @param hi  终点
     */
    private void mergeSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        //取中点
        int mid = lo + (hi - lo) / 2;
        //归并排序上半部分
        mergeSort(arr, lo, mid);
        //归并排序下半部分
        mergeSort(arr, mid + 1, hi);
        //合并两者
        merge(arr, lo, mid, hi);
    }

    /**
     * 比较并合并
     *
     * @param arr
     * @param lo
     * @param mid
     * @param hi
     */
    private void merge(int[] arr, int lo, int mid, int hi) {
        int[] nums = new int[hi - lo + 1];
        //两个数组的起点
        int p = lo, q = mid + 1;
        int index = 0;
        //p和q都没走到尽头
        while (p <= mid && q <= hi) {
            //新数组填入较小的数字,并将索引前移
            if (arr[p] > arr[q]) {
                nums[index++] = arr[q++];
            } else {
                nums[index++] = arr[p++];
            }
        }
        //查看两个数组是否走完
        while (p <= mid) {
            nums[index++] = arr[p++];
        }
        while (q <= hi) {
            nums[index++] = arr[q++];
        }
        //拷贝数组
        System.arraycopy(nums, 0, arr, lo, hi - lo + 1);
    }
}
