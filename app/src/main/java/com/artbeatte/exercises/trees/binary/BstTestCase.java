package com.artbeatte.exercises.trees.binary;

/**
 * @author art.beatte
 * @version 11/17/15
 */
public class BstTestCase {

    /**
     *     0
     *    / \
     *   0  0
     *  /  / \
     * 0  0   0
     *   /   /
     *  0   0
     */
    public static BinarySearchTree<Integer> LARGE = new BinarySearchTree<>();
    static {
        LARGE.add(3);
        LARGE.add(6);
        LARGE.add(8);
        LARGE.add(7);
        LARGE.add(5);
        LARGE.add(4);
        LARGE.add(2);
        LARGE.add(1);
    }

    /**
     *   0
     *  / \
     * 0   0
     */
    public static BinarySearchTree<Integer> SMALL = new BinarySearchTree<>();
    static {
        SMALL.add(2);
        SMALL.add(1);
        SMALL.add(3);
    }

    public static BinarySearchTree<Integer> EMPTY = new BinarySearchTree<>();

    /**
     *  0
     */
    public static BinarySearchTree<Integer> SINGLE = new BinarySearchTree<>();
    static {
        SINGLE.add(14);
    }

    /**
     *      0
     *    /  \
     *   0    0
     *  /    / \
     * 0    0   0
     *      /   /
     *     0   0
     *    / \   \
     *   0  0   0
     *  /    \
     * 0     0
     *       \
     *        0
     */
    public static BinarySearchTree<Integer> X_LARGE = new BinarySearchTree<>();
    static {
        X_LARGE.add(3);
        X_LARGE.add(2);
        X_LARGE.add(1);

        X_LARGE.add(11);
        X_LARGE.add(10);
        X_LARGE.add(6);
        X_LARGE.add(7);
        X_LARGE.add(8);
        X_LARGE.add(9);
        X_LARGE.add(5);
        X_LARGE.add(4);

        X_LARGE.add(14);
        X_LARGE.add(12);
        X_LARGE.add(13);
    }

    /**
     *   0
     *  / \
     * 0  0
     */
    public static BinarySearchTree<String> STRING = new BinarySearchTree<>();
    static {
        STRING.add("Beta");
        STRING.add("Alpha");
        STRING.add("Gamma");
    }
}
