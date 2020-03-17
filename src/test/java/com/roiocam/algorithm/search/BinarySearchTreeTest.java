package com.roiocam.algorithm.search;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andy Chen
 * @date 2020/2/29 下午10:10
 */
class BinarySearchTreeTest {

    final Map<String, Object> map = new HashMap<String, Object>();

    private void init() {
        map.put("5", 1);
        map.put("3", 2);
        map.put("7", 3);
        map.put("0", 123);
        map.put("9", 123);
        map.put("2", 123);
        map.put("1", 123);
        map.put("4", 123);
        map.put("6", 123);
        map.put("8", 123);
    }

    @Test
    public void test() {
        init();
        BinarySearchTree searchTree = new BinarySearchTree();
        searchTree.put("5", 1);
        searchTree.put("3", 2);
        searchTree.put("9", 123);
        searchTree.put("0", 123);
        searchTree.put("14", 123);
        searchTree.put("11", 123);
        searchTree.put("2", 123);
        searchTree.put("1", 123);
        searchTree.put("4", 123);
        searchTree.put("11", 123);
        searchTree.put("7", 3);
        searchTree.put("6", 123);
        searchTree.put("12", 123);
        searchTree.put("8", 123);
        searchTree.put("10", 123);

        // map.forEach((key, value) -> {
        //     searchTree.put(key, value);
        // });
        // map.forEach((key, value) -> {
        //     assert value.equals(searchTree.get(key));
        // });
        // assert map.size() == searchTree.size();
        // searchTree.put("1", 12412);
        // assert searchTree.get("1").equals(12412);
        Iterable<String> keys = searchTree.keys();
        keys.forEach(s->{
            System.out.println(s);
        });
        // searchTree.printf();
    }
}