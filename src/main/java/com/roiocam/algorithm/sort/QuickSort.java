package com.roiocam.algorithm.sort;

/**
 * 快速排序
 * <p>
 * 快速排序的思想是来自冒泡排序，
 * 冒泡排序是通过相邻元素的比较和交换把最小的冒泡到最顶端，
 * 而快速排序是比较和交换小数和大数，这样一来不仅把小数冒泡到上面同时也把大数沉到下面。
 * 基本思想：
 * 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的数据都比另外一部分小。
 * 再通过此方法对两部分快速排序。
 * </p>
 * <p>
 * 快速排序不稳定,在最坏情况下的时间性能不如堆排序和归并排序。
 * </p>
 *
 * @author Andy Chen
 * @date 2020/1/5 下午4:31
 */
public class QuickSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }
    /**
     * 将数组分为两部分，其中一部分的数据都大于另一部分的数据
     *
     * @param unsorted 未排序数组
     * @param left     左指针
     * @param right    右指针
     * @return 两部分的交点的索引
     */
    private int partition(int[] unsorted, int left, int right) {
        //设置中点值
        int pivotKey = unsorted[left];
        while (left < right) {
            while (unsorted[right] > pivotKey) {
                right--;
            }
            while (unsorted[left] < pivotKey) {
                left++;
            }
            int temp = unsorted[left];
            unsorted[left] = unsorted[right];
            unsorted[right] = temp;
        }
        unsorted[left] = pivotKey;
        return left;
    }

    /**
     * @param unsorted 未排序数组
     * @param left     左指针
     * @param right    右指针
     * @return
     */
    private void quickSort(int unsorted[], int left, int right) {
        if (left >= right) {
            return;
        }
        //将未排序数组分为两部分，其中一部分的数字都比另一部分大。
        int pivotPos = partition(unsorted, left, right);
        //递归的将作左半部分的数值再快排
        quickSort(unsorted, left, pivotPos - 1);
        //递归的将作右半部分的数值再快排
        quickSort(unsorted, pivotPos + 1, right);
        //直到两边都无法再次切分为两部分。则排序完成
    }

}
