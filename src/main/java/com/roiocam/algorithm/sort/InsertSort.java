package com.roiocam.algorithm.sort;

/**
 * 插入排序
 * <p>
 * 通过比较找到合适的位置插入元素来达到排序
 * </p>
 *
 * @author Andy Chen
 * @date 2020/1/5 下午4:01
 */
public class InsertSort implements Sort {

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        //假设第一个数位置时正确的；要往后移，必须要假设第一个。
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            //待插入的数字
            int target = arr[i];
            //若发现前面元素有小于此元素，则将更大的元素后移
            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            //将目标元素，插入到合适位置
            arr[j] = target;
        }
    }
}
