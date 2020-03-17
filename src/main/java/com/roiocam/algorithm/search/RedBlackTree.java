package com.roiocam.algorithm.search;

import com.sun.org.apache.regexp.internal.RE;
import org.omg.CORBA.NO_IMPLEMENT;

/**
 * @author Andy Chen
 * @date 2020/3/1 上午4:01
 */
public class RedBlackTree {
    final boolean RED = true;
    final boolean BLACK = false;
    private RBNode root;

    private boolean isRed(Node node) {
        if (node == null) return false;
        else {
            if (node instanceof RBNode) {
                return ((RBNode) node).getColor();
            } else {
                return false;
            }
        }
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.getN();
    }

    private RBNode rotateLeft(RBNode h) {
        RBNode temp = (RBNode) h.getRight();
        h.setRight(temp.getLeft());
        temp.setLeft(h);
        temp.setColor(h.getColor());
        h.setColor(RED);
        temp.setN(h.getN());
        h.setN(size(h.getLeft()) + size(h.getRight()) + 1);
        return temp;
    }

    private RBNode rotateRight(RBNode h) {
        RBNode temp = (RBNode) h.getLeft();
        h.setLeft(temp.getRight());
        temp.setRight(h);
        temp.setColor(h.getColor());
        h.setColor(RED);
        temp.setN(h.getN());
        h.setN(size(h.getLeft()) + size(h.getRight()) + 1);
        return temp;
    }

    private void flipColor(RBNode h) {
        h.setColor(RED);
        ((RBNode) h.getRight()).setColor(BLACK);
        ((RBNode) h.getLeft()).setColor(BLACK);
    }

    public void put(String key, Object value) {
        root = put(root, key, value);
        root.setColor(BLACK);
    }

    private RBNode put(RBNode n, String key, Object value) {
        if (n == null) {
            return new RBNode(key, value, 1, RED);
        }
        int cmp = n.compareTo(key);

        if (cmp < 0) {
            n.setRight(put((RBNode) n.getRight(), key, value));
        } else if (cmp > 0) {
            n.setLeft(put((RBNode) n.getLeft(), key, value));
        } else {
            n.setValue(value);
        }
        if (isRed(n.getRight()) && !isRed(n.getLeft())) {
            //左旋转
            n = rotateLeft(n);
        } else if (isRed(n.getLeft()) && isRed(n.getLeft().getLeft())) {
            //右旋转
            n = rotateRight(n);
        } else if (isRed(n.getLeft()) && isRed(n.getRight())) {
            //颜色转换
            flipColor(n);
        }
        n.setN(size(n.getLeft()) + size(n.getRight()) + 1);
        return n;
    }
}

class RBNode extends Node implements Comparable<String> {

    private boolean color;

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public RBNode(String key, Object value, int N, boolean color) {
        super(key, value, N);
        this.color = color;
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