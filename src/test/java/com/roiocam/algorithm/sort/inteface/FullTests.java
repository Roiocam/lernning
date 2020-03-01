package com.roiocam.algorithm.sort.inteface;

import com.roiocam.algorithm.sort.Sort;

/**
 * @author Andy Chen
 * @date 2020/2/28 上午1:12
 */
public interface FullTests extends PositiveFullTests,NegativeTests {
    default void valid(Sort sort) {
        PositiveFullTests.super.valid(sort);
        NegativeTests.super.valid(sort);
    }
}
