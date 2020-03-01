package com.roiocam.algorithm.sort.inteface;

import com.roiocam.algorithm.sort.Sort;

import java.util.Arrays;

/**
 * @author Andy Chen
 * @date 2020/2/28 上午1:16
 */
public interface BasicTests {

    default void valid(Sort sort, int[] arrays) {
        int[] expect = arrays.clone();
        int[] actually = arrays.clone();
        sort.sort(actually);
        Arrays.sort(expect);
        try {
            assert Arrays.equals(actually, expect);
        } catch (AssertionError e) {
            throw new AssertionError(String.format("算法错误.\n期待结果:{%s}\n实际结果:{%s}", Arrays.toString(expect), Arrays.toString(actually)));
        }
        System.out.println(Arrays.toString(actually));
    }

}
