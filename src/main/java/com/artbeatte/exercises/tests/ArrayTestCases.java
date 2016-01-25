package com.artbeatte.exercises.tests;

/**
 * @author art.beatte
 * @version 12/15/15
 */
public class ArrayTestCases {

    /**
     * An array containing 200,000,000 elements.
     */
    public static int[] EXTRA_LARGE = new int[200000000];
    static {
        for (int i = 0; i < 200000000; i ++) {
            EXTRA_LARGE[i] = i * 2;
        }
    }

    /**
     * An array containing 20,000,000 elements.
     */
    public static int[] LARGE = new int[20000000];
    static {
        for (int i = 0; i < 20000000; i ++) {
            LARGE[i] = i * 2;
        }
    }

    /**
     * An array containing 1,000,000 elements.
     */
    public static int[] MEDIUM = new int[1000000];
    static {
        for (int i = 0; i < 1000000; i ++) {
            MEDIUM[i] = i * 2;
        }
    }

    /**
     * An array containing 100,000 elements.
     */
    public static int[] SMALL = new int[100000];
    static {
        for (int i = 0; i < 100000; i ++) {
            SMALL[i] = i * 2;
        }
    }

    /**
     * An empty array.
     */
    public static int[] EMPTY = new int[0];

    /**
     * A null array.
     */
    public static int[] NULL = null;

    public static int[][] TEST_CASES = new int[][]
            {EXTRA_LARGE, LARGE, MEDIUM, SMALL, EMPTY};
}
