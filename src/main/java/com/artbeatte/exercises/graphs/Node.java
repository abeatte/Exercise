package com.artbeatte.exercises.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * @author art.beatte
 * @version 1/21/16
 */
public class Node<T> {

    private T mValue;
    private Set<Node<T>> mNeighbors;

    public Node(T value) {
        this.mValue = value;
        mNeighbors = new HashSet<>();
    }

    public T getValue() {
        return mValue;
    }

    Set<Node<T>> getNeighbors() {
        return mNeighbors;
    }

    boolean addNeighbor(Node<T> node) {
        return mNeighbors.add(node);
    }

    boolean removeNeighbor(Node<T> node) {
        return mNeighbors.remove(node);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Node)) return false;
        Node n = (Node) obj;
        return n.getValue().equals(getValue());
    }
}
