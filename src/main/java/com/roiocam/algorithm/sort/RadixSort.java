package com.roiocam.algorithm.sort;

/**
 * 基数排序
 * 基于计数排序，以在k变大时获得更好的时间复杂度O(n^2)
 * 基数排序通过将数字从最低有效位（LSD）到最高有效位（MSD）进行排序来工作(LSD首先基于个位数，将数排入0-9的二维数组中。再根据十位排序，百位排序。。)
 * 有LSD起始和MSD起始两种。根据数字大小决定（数字越大使用LSD越好）
 * <p>
 *
 * </p>
 *
 * @author Andy Chen
 * @date 2020/1/6 下午4:03
 */
public class RadixSort implements Sort {
    private final int RANGE = 10;

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int max = findMaxNumbers(arr);
        // 基数
        int numberOfDigits = calculateDigits(max);
        int placeValue = 1;
        //迭代排序
        while (numberOfDigits-- > 0) {
            applyCountingSortOn(arr, placeValue);
            placeValue *= 10;
        }
    }

    private void applyCountingSortOn(int[] arr, int placeValue) {
        int range = 10;
        int length = arr.length;
        int[] frequency = new int[range];
        int[] sortedValues = new int[arr.length];
        for (int i = 0; i < length; i++) {
            //求余数并计数
            int digit = (arr[i] / placeValue) % range;
            frequency[digit]++;
        }
        for (int i = 1; i < range; i++) {
            frequency[i] += frequency[i - 1];
        }
        for (int i = length - 1; i >= 0; i--) {
            int digit = (arr[i] / placeValue) % range;
            sortedValues[frequency[digit] - 1] = arr[i];
            frequency[digit]--;
        }
        System.arraycopy(sortedValues,0,arr,0,arr.length);
    }

    /**
     * 计算最大数长度
     *
     * @param max
     * @return
     */
    private int calculateDigits(int max) {
        return (int) Math.log10(max) + 1;
    }


    /**
     * 找到数组的最大数字
     *
     * @param arr 数组
     * @return
     */
    private int findMaxNumbers(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int a : arr) {
            if (a > max) {
                max = a;
            }
        }
        return max;
    }
}
