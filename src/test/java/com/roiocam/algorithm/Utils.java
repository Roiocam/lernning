package com.roiocam.algorithm;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Andy Chen
 * @date 2020/2/28 上午3:15
 */
public class Utils {
    public  final int[] EMPTY = new int[0];
    public final int[] SAME = new int[]{6, 6, 6, 6, 6, 6};
    public final int[] SAME_ZERO = new int[]{0, 0, 0, 0, 0, 0};

    public static void main(String[] args) {
        System.out.println(reverse(123));
        int[][] m = new int[17][7];
        System.out.println(m.length);
    }
    public static int reverse(int x) {
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }
}
