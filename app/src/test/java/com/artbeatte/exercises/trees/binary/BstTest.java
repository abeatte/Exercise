package com.artbeatte.exercises.trees.binary;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author art.beatte
 * @version 11/17/15
 */
public class BstTest {

    @Test
    public void testAdd() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(3);
        assertEquals("Add to empty is wrong", bst.size(), 1);
        bst.add(2);
        bst.add(11);
        assertEquals("Add to existing is wrong", bst.size(), 3);
        bst.add(3);
        assertEquals("Add duplicate value is wrong", bst.size(), 3);
    }

    @Test
    public void testSize() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assertEquals("Initial size is wrong", bst.size(), 0);
        bst.add(3);
        assertEquals("Size is wrong", bst.size(), 1);
    }

    @Test
    public void testSerialize() {
        BinarySearchTree<Integer> bst = BstTestCase.LARGE;
        assertEquals("Serialization is wrong", bst.serialize(), "3 6 8 # 7 # # 5 # 4 # # 2 # 1 # # ");
        assertEquals("Deserialization is wrong", new BinarySearchTree<Integer>(bst.serialize()).serialize(), bst.serialize());
    }

    @Test
    public void testRemove() {
        BinarySearchTree<Integer> bst = BstTestCase.EMPTY;
        Integer removed = bst.remove(3);
        assertEquals("Remove with existing is wrong", bst.size(), 0);
        assertNull("Removed null object is wrong", removed);
        bst = BstTestCase.LARGE;
        removed = bst.remove(3);
        assertEquals("Removed object is wrong", removed, (Integer) 3);
        removed = bst.remove(8);
        assertEquals("Removed object is wrong", removed, (Integer) 8);
        removed = bst.remove(4);
        assertEquals("Removed object is wrong", removed, (Integer) 4);
        assertEquals("Remove with existing is wrong", bst.size(), 5);
    }

    private void testBasicGets(BinarySearchTree bst, int depth, int edgeWidth, int maxWidth) {
        assertEquals("getDepth is wrong", bst.getDepth(), depth);
        assertEquals("getEdgeWidth is wrong", bst.getEdgeWidth(), edgeWidth);
        assertEquals("getMaxWidth is wrong", bst.getMaxWidth(), maxWidth);
    }

    @Test
    public void testLargeBst() {
        testBasicGets(BstTestCase.LARGE, 4, 4, 3);
    }

    @Test
    public void testEmptyBst() {
        testBasicGets(BstTestCase.EMPTY, 0, 0, 0);
    }

    @Test
    public void testSmallBst() {
        testBasicGets(BstTestCase.SMALL, 2, 2, 2);
    }

    @Test
    public void testSingleBst() {
        testBasicGets(BstTestCase.SINGLE, 1, 0, 1);
    }

    @Test
    public void testXLargeBst() {
        testBasicGets(BstTestCase.X_LARGE, 7, 5, 3);
    }

    @Test
    public void testStringBst() {
        testBasicGets(BstTestCase.STRING, 2, 2, 2);
    }
}
