package com.roiocam.algorithm.search.inteface;

import com.roiocam.algorithm.search.Search;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Andy Chen
 * @date 2020/2/28 上午3:08
 */
public interface SearchBasicTests {
    final Random random = new Random();

    default void valid(Search search, int[] arrays) {
        int expect;
        if (arrays.length == 0) {
            return;
        }
        if (arrays.length == 1) {
            expect = 0;
        }else{
            expect = random.nextInt(arrays.length - 1);
        }
        Random random = new Random();
        int actually = search.search(arrays, arrays[expect]);
        try {
            assert expect == actually;
        } catch (AssertionError e) {
            throw new AssertionError(String.format("算法错误.\n数组:{%s}\n查询key:[%s]期待索引:{%s}\n实际结果:{%s}", Arrays.toString(arrays), arrays[expect], expect, actually));
        }
        System.out.println(String.format("已找到元素索引:%d,arrays[%d]=%d", actually, actually, arrays[actually]));
    }

    default int[] getArrays() {
        int[] arr = new int[random.nextInt(10)];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    default void valid(Search search) {
        for (int i = 0; i < (random.nextInt(10) + 1); i++) {
            int[] arrays = getArrays();
            Arrays.sort(arrays);
            valid(search, arrays);
        }
    }
}
