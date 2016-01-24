package com.artbeatte.exercises.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author art.beatte
 * @version 1/23/16
 */
public class AStarTestCase {

    public static class Test {
        public Set<Edge<Character>> edges;
        public Node<Character> start;
        public Node<Character> target;
        public List<Node<Character>> answer;

        public Test() {
            answer = new LinkedList<>();
            edges = new HashSet<>();
        }
    }

    public static final Test EMPTY = new Test();
    static {
        EMPTY.answer = null;
        EMPTY.edges = null;
    }

    public static final Test ONE = new Test();
    static {
        ONE.start = new Node<>('A');
        ONE.target = new Node<>('A');
        ONE.answer.add(ONE.start);
    }

    public static final Test TWO = new Test();
    static {
        TWO.start = new Node<>('A');
        TWO.target = new Node<>('B');
        TWO.edges.add(new Edge<>(TWO.start, TWO.target, 3));
        TWO.answer.add(TWO.start);
        TWO.answer.add(TWO.target);
    }

    public static final Test REAL = new Test();
    static {
        Node<Character> a = new Node<>('A');
        Node<Character> b = new Node<>('B');
        Node<Character> c = new Node<>('C');
        Node<Character> d = new Node<>('D');
        Node<Character> e = new Node<>('E');
        Node<Character> f = new Node<>('F');
        Node<Character> g = new Node<>('G');
        Node<Character> h = new Node<>('H');
        Node<Character> i = new Node<>('I');
        Node<Character> j = new Node<>('J');
        Node<Character> k = new Node<>('K');
        Node<Character> l = new Node<>('L');
        Node<Character> m = new Node<>('M');
        Node<Character> n = new Node<>('N');
        Node<Character> o = new Node<>('O');
        Node<Character> p = new Node<>('P');
        REAL.start = a;
        REAL.target = p;
        REAL.edges.add(new Edge<>(a, b, 1));
        REAL.edges.add(new Edge<>(a, c, 4));
        REAL.edges.add(new Edge<>(c, h, 2));
        REAL.edges.add(new Edge<>(h, i, 1));
        REAL.edges.add(new Edge<>(h, j, 1));
        REAL.edges.add(new Edge<>(a, d, 3));
        REAL.edges.add(new Edge<>(d, e, 5));
        REAL.edges.add(new Edge<>(d, f, 3));
        REAL.edges.add(new Edge<>(f, g, 6));
        REAL.edges.add(new Edge<>(g, k, 1));
        REAL.edges.add(new Edge<>(k, j, 3));
        REAL.edges.add(new Edge<>(g, l, 4));
        REAL.edges.add(new Edge<>(l, m, 4));
        REAL.edges.add(new Edge<>(e, m, 4));
        REAL.edges.add(new Edge<>(l, n, 2));
        REAL.edges.add(new Edge<>(n, o, 1));
        REAL.edges.add(new Edge<>(o, p, 1));
        REAL.edges.add(new Edge<>(n, p, 3));
        REAL.answer.add(a);
        REAL.answer.add(c);
        REAL.answer.add(h);
        REAL.answer.add(j);
        REAL.answer.add(k);
        REAL.answer.add(g);
        REAL.answer.add(l);
        REAL.answer.add(n);
        REAL.answer.add(o);
        REAL.answer.add(p);
    }

    public static final Set<Test> TESTS = new HashSet<>();
    static {
        TESTS.add(EMPTY);
        TESTS.add(ONE);
        TESTS.add(TWO);
        TESTS.add(REAL);
    }
}
