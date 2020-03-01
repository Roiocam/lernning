package com.roiocam.algorithm.sort.inteface;

import com.roiocam.algorithm.sort.Sort;

/**
 * @author Andy Chen
 * @date 2020/2/28 上午1:17
 */
public interface NegativeTests extends BasicTests{
    final int[] NEGATIVE = new int[]{-1,-99,0,48128,-94192,0,-1,-1,0,0};
    default void valid(Sort sort) {
        valid(sort,NEGATIVE);
    }
}
