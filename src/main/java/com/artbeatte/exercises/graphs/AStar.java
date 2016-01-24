package com.artbeatte.exercises.graphs;

import java.util.*;

/**
 * @author art.beatte
 * @version 1/23/16
 */
public class AStar {

    /**
     * The level of confidence that the heuristic accurately judges distance.
     */
    private static final double CONFIDENCE = 0.25;
    
    public static List<Node<Character>> findPath(Set<Edge<Character>> edges, Node<Character> start, Node<Character> target) {
        if (edges == null || start == null || target == null) return null;
        Set<Node<Character>> working = new HashSet<>();
        Set<Node<Character>> visited = new HashSet<>();
        Map<Node<Character>, Integer> distances = new HashMap<>();
        Map<Node<Character>, Node<Character>> previouses = new HashMap<>();
        
        working.add(start);
        distances.put(start, 0);
        while (!working.isEmpty()) {
            Node<Character> n = getNextBestGuess(working, distances, target);
            if (n.equals(target)) {
                return getPath(n, previouses);
            }
            working.remove(n);
            visited.add(n);
            processNeighbors(n, edges, working, visited, distances, previouses);
        }
        return null; // no path found
    } 
    
    private static Node<Character> getNextBestGuess(Set<Node<Character>> nodes, Map<Node<Character>, Integer> distances, Node<Character> target) {
        Node<Character> best = null;
        for (Node<Character> n : nodes) {
            if (best == null || distances.get(best) + guessDist(best, target) > distances.get(n) + guessDist(n, target)) {
                best = n;
            }
        }
        return best;
    }
    
    private static int guessDist(Node<Character> n, Node<Character> target) {
        return (int)((target.getValue() - n.getValue()) * CONFIDENCE);
    }

    private static void processNeighbors(Node<Character> n,
                                         Set<Edge<Character>> edges, Set<Node<Character>> working, Set<Node<Character>> visited,
                                         Map<Node<Character>, Integer> distances, Map<Node<Character>, Node<Character>> previouses) {
        for (Edge<Character> edge : edges) {
            if (edge.has(n) && !visited.contains(edge.other(n))) {
                working.add(edge.other(n));
                Integer dist = distances.get(edge.other(n));
                if (dist == null || dist > distances.get(n) + edge.getDistance()) {
                    distances.put(edge.other(n), distances.get(n) + edge.getDistance());
                    previouses.put(edge.other(n), n);
                }
            }
        }
    }

    private static List<Node<Character>> getPath(Node<Character> n, Map<Node<Character>, Node<Character>> previouses) {
        List<Node<Character>> path = new LinkedList<>();
        path.add(n);
        Node<Character> previous = previouses.get(n);
        while (previous != null) {
            path.add(0, previous);
            previous = previouses.get(previous);
        }
        return path;
    }
}
