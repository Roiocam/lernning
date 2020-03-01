package com.roiocam.algorithm.sort;

import com.roiocam.algorithm.sort.inteface.FullTests;
import org.junit.jupiter.api.Test;

/**
 * @author Andy Chen
 * @date 2020/1/5 下午4:15
 */
class InsertSortTest implements FullTests {
    @Test
    public void sortTest() {
        valid(new SelectSort());
    }
}