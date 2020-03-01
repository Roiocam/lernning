package com.roiocam.algorithm.search;

/**
 * @author Andy Chen
 * @date 2020/3/1 上午4:01
 */
public class RedBlackTree {

}

class RBNode extends Node implements Comparable<String> {
    final boolean RED = true;
    final boolean BLACK = false;
    private boolean color;

    public RBNode(String key, Object value, int N, boolean color) {
        super(key, value, N);
        this.color = false;
    }

    private boolean isRed(Node node) {
        if (node == null) return false;
        else return color;
    }

    private int hash(String key) {
        int hash = 0;
        int i;
        for (i = 0; i < key.length(); ++i) {
            hash = 33 * hash + key.charAt(i);
        }
        return hash;
    }

    @Override
    public int compareTo(String o) {
        if (hash(getKey()) > hash(o)) return 1;
        else if (hash(getKey()) < hash(o)) return -1;
        else return 0;
    }
}