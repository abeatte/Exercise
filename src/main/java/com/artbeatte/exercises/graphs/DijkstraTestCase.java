package com.artbeatte.exercises.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author art.beatte
 * @version 1/21/16
 */
public class DijkstraTestCase {

    public static class Test {
        public Node<Integer> root;
        public Map<String, Edge<Integer>> edges;
        public Map<Node, Integer> answer;

        public Test() {
            root = null;
            edges = new HashMap<>();
            answer = new HashMap<>();
        }
    }

    public static final Test ONE =  new Test();
    static {
        ONE.root = new Node<>(1);
        ONE.answer.put(ONE.root, 0);
    }
    public static final Test SHORT =  new Test();
    static {
        Node<Integer> one = new Node<>(1);
        SHORT.answer.put(one, 0);
        Node<Integer> two = new Node<>(2);
        SHORT.answer.put(two, 24);
        Node<Integer> three = new Node<>(3);
        SHORT.answer.put(three, 3);
        Node<Integer> four = new Node<>(4);
        SHORT.answer.put(four, 15);

        one.addNeighbor(two);
        two.addNeighbor(one);

        one.addNeighbor(four);
        four.addNeighbor(one);

        three.addNeighbor(one);
        one.addNeighbor(three);

        four.addNeighbor(three);
        three.addNeighbor(four);

        Node<Integer> root = one;
        SHORT.root = root;

        Edge<Integer> oneTwo = new Edge<>(one, two, 24);
        SHORT.edges.put(oneTwo.getKey(), oneTwo);
        Edge<Integer> twoOne = new Edge<>(two, one, 24);
        SHORT.edges.put(twoOne.getKey(), twoOne);

        Edge<Integer> oneFour = new Edge<>(one, four, 20);
        SHORT.edges.put(oneFour.getKey(), oneFour);
        Edge<Integer> fourOne = new Edge<>(four, one, 20);
        SHORT.edges.put(fourOne.getKey(), fourOne);

        Edge<Integer> threeOne = new Edge<>(three, one, 3);
        SHORT.edges.put(threeOne.getKey(), threeOne);
        Edge<Integer> oneThree = new Edge<>(one, three, 3);
        SHORT.edges.put(oneThree.getKey(), oneThree);

        Edge<Integer> fourThree = new Edge<>(four, three, 12);
        SHORT.edges.put(fourThree.getKey(), fourThree);
        Edge<Integer> threeFour = new Edge<>(three, four, 12);
        SHORT.edges.put(threeFour.getKey(), threeFour);
    }

    public static final Set<Test> TESTS = new HashSet<>();
    static {
        TESTS.add(ONE);
        TESTS.add(SHORT);
    }
}
