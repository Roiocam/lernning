package com.roiocam.algorithm.sort;

import com.roiocam.algorithm.sort.inteface.PositiveFullTests;
import org.junit.jupiter.api.Test;

/**
 * @author Andy Chen
 * @date 2020/1/5 下午3:54
 */
class RadixSortTest implements PositiveFullTests {
    @Test
    public void sortTest() {
        valid(new RadixSort());
    }
}