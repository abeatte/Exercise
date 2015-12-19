package com.artbeatte.exercises.trees.binary;

import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @author art.beatte
 * @version 10/18/15
 * @version 11/14/15
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> mRoot;

    // region init
    public BinarySearchTree() {
        mRoot = null;
    }

    public BinarySearchTree(String data) {
        this();
        if (data != null && data.length() > 0) {
            StringTokenizer st = new StringTokenizer(data, " ");
            mRoot = deserialize(st);
        }
    }
    // endregion

    // region add
    public boolean add(T value) {
        boolean success = true;
        if (value == null) {
            success = false;
        } else if (mRoot == null) {
            mRoot = new Node<>(value);
        } else {
            mRoot =  add(mRoot, value);
        }
        return success;
    }

    private Node<T> add(Node<T> root, T value) {
        int comp = root.getValue().compareTo(value);
        if (comp < 0) {
            if (root.getLeftNode() == null) {
                root.setLeftNode(value);
            } else {
                root.setLeftNode(add(root.getLeftNode(), value));
            }
        } if (comp > 0) {
            if (root.getRightNode() == null) {
                root.setRightNode(value);
            } else {
                root.setRightNode(add(root.getRightNode(), value));
            }
        }
        return root;
    }
    // endregion

    // region remove
    public T remove(T value) {
        if (value == null || mRoot == null) return null;
        Node<T> found = find(mRoot, value);
        mRoot = remove(mRoot, value);
        return found == null ? null : found.getValue();
    }

    private Node<T> remove(Node<T> root, T value) {
        int comp = root.getValue().compareTo(value);
        if (comp < 0) {
            root.setLeftNode(remove(root.getLeftNode(), value));
        } else if (comp > 0) {
            root.setRightNode(remove(root.getRightNode(), value));
        } else {
            root = handleRemoval(root);
        }
        return root;
    }

    private Node<T> handleRemoval(Node<T> root) {
        if (root.getLeftNode() == null && root.getRightNode() == null) {
            root = null;
        } else if (root.getLeftNode() == null) {
            root = root.getRightNode();
        } else if(root.getRightNode() == null) {
            root = root.getLeftNode();
        } else {
            Node<T> rightsLeftMost = root.getRightNode();
            while (rightsLeftMost.getLeftNode() != null) {
                rightsLeftMost = rightsLeftMost.getLeftNode();
            }
            rightsLeftMost.setLeftNode(root.getLeftNode());
            root = root.getRightNode();
        }
        return root;
    }
    // endregion

    // region search
    public boolean contains(T value) {
        return find(mRoot, value) != null;
    }

    private Node<T> find(Node<T> root, T value) {
        if (root == null) return null;
        int comp = root.getValue().compareTo(value);
        if (comp < 0) {
            return find(root.getLeftNode(), value);
        } else if (comp > 0) {
            return find(root.getRightNode(), value);
        } else {
            return root;
        }
    }
    // endregion

    // region size
    public boolean isEmpty() {
        return mRoot == null;
    }

    public int size() {
        return count(mRoot);
    }

    private int count(Node root) {
        if (root == null) return 0;
        int leftCount = count(root.getLeftNode());
        int rightCount = count(root.getRightNode());
        return leftCount + rightCount + 1;
    }
    // endregion

    // region serialization
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        serialize(mRoot, sb);
        return sb.toString();
    }

    private void serialize(Node root, StringBuilder sb) {
        if (root == null) {
            sb.append("# ");
            return;
        }
        sb.append(root.getValue()).append(" ");
        serialize(root.getLeftNode(), sb);
        serialize(root.getRightNode(), sb);
    }

    private Node<T> deserialize(StringTokenizer st) {
        if (!st.hasMoreElements()) return null;
        String value = st.nextToken();
        if (value.equals("#")) {
            return null;
        }
        @SuppressWarnings("unchecked")
        Node<T> root = new Node<>((T) value);
        root.setLeftNode(deserialize(st));
        root.setRightNode(deserialize(st));
        return root;
    }
    // endregion

    // region depth
    /**
     * Depth is the deepest level reached by the tree
     *   0
     *  / \
     * 0   0
     *    / \
     *   0   0
     * The preceding tree has a depth of 3.
     * @return the depth
     */
    @SuppressWarnings("unused")
    public int getDepth() {
        return getDepth(mRoot);
    }

    private int getDepth(Node root) {
        if (root == null) return 0;
        int lDepth = getDepth(root.getLeftNode());
        int rDepth = getDepth(root.getRightNode());
        return 1 + Math.max(lDepth , rDepth);
    }
    // endregion

    // region width
    /**
     * Width is defined as the number of edges between the left most and right most nodes.
     *   0
     *  / \
     * 0   0
     *    / \
     *   0   0
     *  /
     * 0
     * The proceeding tree has a width of 3.
     *  @return the width
     */
    @SuppressWarnings("unused")
    public int getEdgeWidth() {
        int[] xy=  new int[2];
        getEdgeWidth(mRoot, 0, xy);
        return Math.abs(xy[1] - xy[0]);
    }

    /**
     * Calculates the edge width
     * @param root the root {@link Node}
     * @param center the distance from the root
     * @param xy a {@code int[2]} containing the left and right most values.
     */
    private void getEdgeWidth(Node root, int center, int[] xy) {
        if (root == null) return;
        if (center < xy[0]) xy[0] = center;
        if (center > xy[1]) xy[1] = center;
        getEdgeWidth(root.getLeftNode(), center - 1, xy);
        getEdgeWidth(root.getRightNode(), center + 1, xy);
    }
    // endregion

    // region max width
    /**
     * Max Width is defined as the most number of nodes of the same depth.
     *     0
     *    / \
     *   0  0
     *  /  / \
     * 0  0   0
     *   /   /
     *  0   0
     * The preceding tree has a max width of 3.
     * @return the max width
     */
    @SuppressWarnings("unused")
    public int getMaxWidth() {
        HashMap<Integer, Integer> depths = new HashMap<>();
        getMaxWidth(mRoot, 0, depths);
        int width = 0;
        for (Integer key : depths.keySet()) {
            if (depths.get(key) > width) width = depths.get(key);
        }
        return width;
    }

    public void getMaxWidth(Node root, int depth, HashMap<Integer, Integer> depths) {
        if (root == null) return;
        Integer recordedDepth = depths.get(depth);
        if (recordedDepth == null) {
            depths.put(depth, 1);
        } else {
            depths.put(depth, ++recordedDepth);
        }
        getMaxWidth(root.getLeftNode(), depth + 1, depths);
        getMaxWidth(root.getRightNode(), depth + 1, depths);
    }
    // endregion
}
