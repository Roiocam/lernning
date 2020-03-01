package com.roiocam.algorithm.search;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Andy Chen
 * @date 2020/2/29 下午9:42
 */
public class BinarySearchTree {
    private Node root;

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.getN();
    }

    public Node get(String key) {
        return get(root, key);
    }


    public void put(String key, Object value) {
        root = put(root, key, value);
    }

    public void printf() {
        printf(root);
    }

    public Node min() {
        if (root == null) {
            return null;
        } else {
            return min(root);
        }
    }

    public void delete(String key) {
        delete(root, key);
    }

    private Node delete(Node node, String key) {
        if (node == null) return null;
        int compare = compareTo(key, node.getKey());
        if (compare < 0) {
            node.setLeft(delete(node.getLeft(), key));
        } else if (compare > 0) {
            node.setRight(delete(node.getRight(), key));
        } else {
            if (node.getRight() == null) return node.getLeft();
            if (node.getLeft() == null) return node.getRight();
            Node x = node;
            //从右子树找最小，替代node
            node = min(x.getRight());
            //删除原来的右子树的最小。若右子树最小有节点
            node.setRight(deleteMin(x.getRight()));
            node.setLeft(x.getLeft()); //原来的左子树
        }
        node.setN(size(node.getLeft()) + size(node.getRight()) + 1);
        return node;
    }

    private Node deleteMin(Node node) {
        if (node.getLeft() == null) return node.getRight();
        node.setLeft(deleteMin(node.getLeft()));
        node.setN(size(node.getLeft()) + size(node.getRight()) + 1);
        return node;
    }

    private Node min(Node node) {
        if (node.getLeft() == null) return node;
        else return min(node.getLeft());
    }

    public Node max() {
        if (root == null) {
            return null;
        } else {
            return max(root);
        }
    }

    private Node max(Node node) {
        if (node.getRight() == null) return node;
        else return max(node.getRight());
    }

    public Iterable<String> keys() {
        return keys(root);
    }
    private Iterable<String> keys(Node root) {
        Queue<String> queue = new ArrayDeque<>();
        keys(root, queue);
        return queue;
    }
    private void keys(Node node,Queue<String> queue){
        if (node == null) return;
        if (node.getLeft() != null) {
            keys(node.getLeft(),queue);
        }
        queue.offer(node.getKey());
        if (node.getRight() != null) {
            keys(node.getRight(),queue);
        }
    }
    private Iterable<String> keys(Node min, Node max) {
        Queue<String> queue = new ArrayDeque<>();
        keys(root, queue, min, max);
        return queue;
    }

    private void keys(Node node, Queue<String> queue, Node min, Node max) {
        if (node == null) return;
        int compareMin = compareTo(min.getKey(), node.getKey());
        int compareMax = compareTo(max.getKey(), node.getKey());
        if (compareMin < 0) keys(node.getLeft(), queue, min, max);
        if (compareMin <= 0 && compareMax >= 0) queue.offer(node.getKey());
        if (compareMax > 0) keys(node.getRight(), queue, min, max);
    }

    private void printf(Node node) {
        if (node == null) System.out.println("BST is empty");
        if (node.getLeft() != null) {
            printf(node.getLeft());
        }
        System.out.println(String.format("[Key:%s,Value:%s,N:%s]", node.getKey(), node.getValue(), size(node)));
        if (node.getRight() != null) {
            printf(node.getRight());
        }
    }

    private Node get(Node node, String key) {
        if (node == null) return null;
        int compare = compareTo(key, node.getKey());
        if (compare > 0) return get(node.getRight(), key);
        else if (compare < 0) return get(node.getLeft(), key);
        else return node;
    }

    private Node put(Node node, String key, Object value) {
        if (node == null) return new Node(key, value, 1);
        int compare = compareTo(key, node.getKey());
        if (compare > 0) node.setRight(put(node.getRight(), key, value));
        else if (compare < 0) node.setLeft(put(node.getLeft(), key, value));
        else node.setValue(value);
        node.setN(size(node.getLeft()) + size(node.getRight()) + 1);
        return node;
    }

    private int compareTo(String x, String y) {
        if (hash(x) > hash(y)) return 1;
        else if (hash(x) < hash(y)) return -1;
        else return 0;

    }

    private int hash(String key) {
        int hash = 0;
        int i;
        for (i = 0; i < key.length(); ++i) {
            hash = 33 * hash + key.charAt(i);
        }
        return hash;
    }
}

class Node {
    //键
    private String key;
    //值
    private Object value;
    //左节点
    private Node left;
    //右节点
    private Node right;
    //该节点为根的子树的结点总数
    private int N;

    public void setValue(Object value) {
        this.value = value;
    }

    public void setN(int n) {
        N = n;
    }

    public Node(String key, Object value, int N) {
        this.key = key;
        this.value = value;
        this.N = N;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getN() {
        return N;
    }


}