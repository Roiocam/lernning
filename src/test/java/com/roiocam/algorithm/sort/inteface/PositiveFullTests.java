package com.roiocam.algorithm.sort.inteface;

import com.roiocam.algorithm.sort.Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Andy Chen
 * @date 2020/2/28 上午1:23
 */
public interface PositiveFullTests extends BasicTests{
    final int[] EMPTY = new int[0];
    final int[] SAME = new int[]{6, 6, 6, 6, 6, 6};
    final int[] SAME_ZERO = new int[]{0, 0, 0, 0, 0, 0};

    default int[] getArrays() {
        Random random = new Random();
        int[] arr = new int[random.nextInt(10)];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }
    default void valid(Sort sort) {
        int[] random = getArrays();
        System.out.println("Random Original:"+ Arrays.toString(random));
        valid(sort, random);
        valid(sort, SAME);
        valid(sort, SAME_ZERO);
        valid(sort, EMPTY);
    }
}
