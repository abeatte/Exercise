package com.artbeatte.exercises.trees.binary;

/**
 * @author art.beatte
 * @version 11/13/15
 */
public class Node<T extends Comparable<T>> {

    private T mValue;
    private Node<T> mLeft;
    private Node<T> mRight;

    public Node(T value) {
        this.mValue = value;
    }

    public T getValue() {
        return mValue;
    }

    public Node<T> getLeftNode() {
        return mLeft;
    }

    public void setLeftNode(T left) {
        this.mLeft = new Node<>(left);
    }

    void setLeftNode(Node<T> left) {
        this.mLeft = left;
    }

    public Node<T> getRightNode() {
        return mRight;
    }

    public void setRightNode(T right) {
        this.mRight = new Node<>(right);
    }

    void setRightNode(Node<T> right) {
        this.mRight = right;
    }
}
