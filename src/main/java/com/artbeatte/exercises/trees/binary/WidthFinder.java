package com.artbeatte.exercises.trees.binary;

import java.util.HashMap;
import java.util.Map;

/**
 * @author art.beatte
 * @version 1/24/16
 */
public class WidthFinder {

    /**
     * Returns the maximum width of the tree who's root is given.
     * @param root the {@link Node} to traverse from
     * @param sameLevel true if the maximum width should be level specific; false if it should be level agnostic.
     * @return the maximum width of the tree
     */
    public static int getMaxWidth(Node root, boolean sameLevel) {
        return sameLevel ? getLevelSpecificMaxWidth(root) : getLevelAgnosticMaxWidth(root);
    }

    // region LevelAgnostic

    /**
     * Returns the maximum level agnostic width of the tree who's root is given.
     * Maximum level agnostic width is defined as the max number of edges that make up the boundary of the tree.
     * E.G. The below has two edges making up its boundary.
     *    0
     *   / \
     *  0   0
     * @param root the root {@link Node} to traverse from
     * @return the maximum width of the tree
     */
    public static int getLevelAgnosticMaxWidth(Node root) {
        if (root == null) return 0;
        int leftPosition = getPosition(root, 0, true);
        int rightPosition = getPosition(root, 0, false);
        return Math.abs(leftPosition) + rightPosition;
    }

    private static int getPosition(Node root, int position, boolean isForLeft) {
        if (root == null) return position;

        int leftPosition = position;
        int rightPosition = position;

        if (root.getLeftNode() != null) {
            leftPosition = getPosition(root.getLeftNode(), position - 1, isForLeft);
        }
        if (root.getRightNode() != null) {
            rightPosition = getPosition(root.getRightNode(), position + 1, isForLeft);
        }

        if (isForLeft) {
            position = Math.min(leftPosition, rightPosition);
        } else {
            position = Math.max(leftPosition, rightPosition);
        }

        return position;
    }
    // endregion

    // region LevelSpecific

    /**
     * Returns the maximum level specific width of the tree who's root is given.
     * Maximum level specific width is defined as the maximum number of edges that make up the boundary of the tree
     * terminating on the same level
     * E.G. The below has two edges making up its boundary terminating on the same level
     *    0
     *   / \
     *  0   0
     *       \
     *        0
     * @param root the root {@link Node} to traverse from
     * @return the maximum width of the tree
     */
    public static int getLevelSpecificMaxWidth(Node root) {
        if (root == null) return 0;
        Map<Integer, Integer> lefts = new HashMap<>();
        Map<Integer, Integer> rights = new HashMap<>();
        getPositions(root, 0, 0, lefts, rights);

        int maxDepth = 0;
        for (Integer lDepth : lefts.keySet()) {
            Integer rPosition = rights.get(lDepth);
            if (rPosition != null && !rPosition.equals(lefts.get(lDepth)) && maxDepth < lDepth) {
                maxDepth = lDepth;
            }
        }
        return Math.abs(lefts.get(maxDepth)) + rights.get(maxDepth);
    }

    private static void getPositions(Node root, int position, int depth, Map<Integer, Integer> lefts, Map<Integer, Integer> rights) {
        if (root == null) return;

        if (root.getLeftNode() != null) {
            getPositions(root.getLeftNode(), position - 1, depth + 1, lefts, rights);
        }
        if (root.getRightNode() != null) {
            getPositions(root.getRightNode(), position + 1, depth + 1, lefts, rights);
        }

        Integer leftPosition = lefts.get(depth);
        if (leftPosition == null || leftPosition > position) {
            lefts.put(depth, position);
        }
        Integer rightPosition = rights.get(depth);
        if (rightPosition == null || rightPosition < position) {
            rights.put(depth, position);
        }
    }
    // endregion
}
