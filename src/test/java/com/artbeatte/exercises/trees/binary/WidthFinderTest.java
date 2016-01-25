package com.artbeatte.exercises.trees.binary;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author art.beatte
 * @version 11/17/15
 */
public class WidthFinderTest {

    @Test
    public void testEmptyTree() {
        assertEquals("getMaxWith (level agnostic) is wrong", WidthFinder.getMaxWidth(TreeTestCases.EMPTY, false), 0);
        assertEquals("getMaxWith (level specific) is wrong", WidthFinder.getMaxWidth(TreeTestCases.EMPTY, true), 0);
    }

    @Test
    public void testSingleTree() {
        assertEquals("getMaxWith (level agnostic) is wrong", WidthFinder.getMaxWidth(TreeTestCases.SIMPLE, false), 0);
        assertEquals("getMaxWith (level specific) is wrong", WidthFinder.getMaxWidth(TreeTestCases.SIMPLE, true), 0);
    }

    @Test
    public void testComplexTree() {
        assertEquals("getMaxWith (level agnostic) is wrong", WidthFinder.getMaxWidth(TreeTestCases.COMPLEX, false), 5);
        assertEquals("getMaxWith (level specific) is wrong", WidthFinder.getMaxWidth(TreeTestCases.COMPLEX, true), 4);
    }
}
