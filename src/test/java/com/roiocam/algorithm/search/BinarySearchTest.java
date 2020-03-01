package com.roiocam.algorithm.search;

import com.roiocam.algorithm.search.inteface.SearchBasicTests;
import org.junit.jupiter.api.Test;

/**
 * @author Andy Chen
 * @date 2020/2/28 上午3:06
 */
class BinarySearchTest implements SearchBasicTests {
    @Test
    public void searchTest() {
        valid(new BinarySearch());
    }
}