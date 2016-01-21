package com.artbeatte.exercises.testrunner.tests;

import com.artbeatte.exercises.graphs.Dijkstra;
import com.artbeatte.exercises.graphs.DijkstraTestCase;
import com.artbeatte.exercises.testrunner.MethodTestCase;
import com.artbeatte.exercises.testrunner.SystemTestRunner;
import com.artbeatte.exercises.testrunner.TestRunner;

/**
 * @author art.beatte
 * @version 1/21/16
 */
public class DijkstraTest {

    public static void main(String[] args) {
        TestRunner testRunner = new SystemTestRunner();
        for (DijkstraTestCase.Test test : DijkstraTestCase.TESTS) {
            Dijkstra<Integer> dijkstra = new Dijkstra<>(test.root, test.edges);
            testRunner.addTestCase(new MethodTestCase<>(dijkstra, "answer", test.answer));
        }
        testRunner.runTests();
    }
}
