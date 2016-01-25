package com.artbeatte.exercises.trees.binary;

/**
 * @author art.beatte
 * @version 1/24/16
 */
@SuppressWarnings("unchecked")
public class TreeTestCases {

    /**
     *  An empty tree
     */
    public static Node EMPTY = null;

    /**
     * A tree of one
     *
     *  0
     */
    public static Node SIMPLE = new Node();

    /**
     * A complex tree
     *
     *         0
     *       /  \
     *      /    \
     *     0     0
     *      \   / \
     *      0  0  0
     *     /       \
     *    0        0
     *   /
     *  0
     *
     */
    public static Node COMPLEX = new Node();
    static {
        Node a = new Node();
        Node b = new Node();
        COMPLEX.setLeftNode(a);
        a.setRightNode(b);
        a = new Node();
        b.setLeftNode(a);
        b = new Node();
        a.setLeftNode(b);
        a = new Node();
        b = new Node();
        COMPLEX.setRightNode(a);
        a.setLeftNode(b);
        b = new Node();
        a.setRightNode(b);
        a = new Node();
        b.setRightNode(a);
    }
}
