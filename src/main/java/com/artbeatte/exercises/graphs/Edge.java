package com.artbeatte.exercises.graphs;

/**
 * @author art.beatte
 * @version 1/21/16
 */
public class Edge<T> {

    public static String getEdgeKey(Node start, Node end) {
        return start + "-" + end;
    }

    private Node<T> mStart;
    private Node<T> mEnd;
    private int mDistance;

    public Edge(Node<T> start, Node<T> end, int distance) {
        this.mStart = start;
        this.mEnd = end;
        this.mDistance = distance;
    }

    public Node<T> getStart() {
        return mStart;
    }

    public void setStart(Node<T> start) {
        this.mStart = start;
    }

    public Node<T> getEnd() {
        return mEnd;
    }

    public void setEnd(Node<T> end) {
        this.mEnd = end;
    }

    public int getDistance() {
        return mDistance;
    }

    public void setDistance(int mDistance) {
        this.mDistance = mDistance;
    }

    public String getKey() {
        return getEdgeKey(mStart, mEnd);
    }

    @Override
    public String toString() {
        return mStart + "-(" + mDistance + ")-" + mEnd;
    }
}
