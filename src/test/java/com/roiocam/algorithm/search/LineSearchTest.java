package com.roiocam.algorithm.search;

import com.roiocam.algorithm.search.inteface.SearchBasicTests;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Andy Chen
 * @date 2020/2/28 下午3:42
 */
class LineSearchTest implements SearchBasicTests {
    @Test
    public void searchTest() {
        valid(new LineSearch());
    }

}