package com.artbeatte.exercises.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author art.beatte
 * @version 1/21/16
 */
public class Dijkstra<T> {

    private Set<Node<T>> workingSet;
    private Set<Node<T>> visitedSet;
    private Map<Node<T>, Integer> distances;

    public Dijkstra(Node<T> origin, Map<String, Edge<T>> edges) {
        // init
        workingSet = new HashSet<>();
        visitedSet = new HashSet<>();
        distances = new HashMap<>();

        // solve
        distances.put(origin, 0);
        workingSet.add(origin);
        while(!workingSet.isEmpty()) {
            Node current = getShortestIn(workingSet);
            workingSet.remove(current);
            visitedSet.add(current);
            processNeighbors(current, edges);
        }
    }

    /**
     * Gets the {@link Node} in pool with the shortest distance
     * @param pool the set of {@link Node}s to check
     * @return the {@link Node} with the shortest distance.
     */
    private Node getShortestIn(Set<Node<T>> pool) {
        Node min = null;
        for (Node n : pool) {
            if (min == null || getKnownDistance(min) > getKnownDistance(n)) {
                min = n;
            }
        }
        return min;
    }

    /**
     * Gets the current known distance to the {@link Node}
     * @param node the {@link Node} to distance check
     * @return the int distance to the node or {@code Integer.MAX_VALUE} if no known distance was found.
     */
    private int getKnownDistance(Node<T> node) {
        Integer dist = distances.get(node);
        if (dist == null) {
            dist = Integer.MAX_VALUE;
        }
        return dist;
    }

    private void processNeighbors(Node<T> node, Map<String, Edge<T>> edges) {
        for (Node<T> neighbor : node.getNeighbors()) {
            if (!visitedSet.contains(neighbor) &&
                    getKnownDistance(neighbor) > (getKnownDistance(node) + getDistance(node, neighbor, edges))) {
                distances.put(neighbor, getKnownDistance(node) + getDistance(node, neighbor, edges));
                workingSet.add(neighbor);
            }
        }
    }

    /**
     * Returns the distance between two nodes given a list of edges
     * @param source the start of the edge sought
     * @param destination the end of the edge sought
     * @param edges the list of edges to query from
     * @return the distance given by the found edge; {@code Integer.MAX_VALUE} if no edge was found.
     */
    private int getDistance(Node source, Node destination, Map<String, Edge<T>> edges) {
        int distance;
        Edge e = edges.get(Edge.getEdgeKey(source, destination));
        if (e == null) {
            distance = Integer.MAX_VALUE;
        } else {
            distance = e.getDistance();
        }
        return distance;
    }

    public Map<Node<T>, Integer> answer() {
        return distances;
    }
}
