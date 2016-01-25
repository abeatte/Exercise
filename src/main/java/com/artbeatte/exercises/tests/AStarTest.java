package com.artbeatte.exercises.tests;

import com.artbeatte.exercises.graphs.AStar;
import com.artbeatte.exercises.graphs.AStarTestCase;
import com.artbeatte.exercises.graphs.Node;
import com.artbeatte.testrunner.ExternalTestCase;
import com.artbeatte.testrunner.SystemTestRunner;
import com.artbeatte.testrunner.TestRunner;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

/**
 * @author art.beatte
 * @version 1/23/16
 */
public class AStarTest {

    public static void main(String[] args) {
        TestRunner testRunner = new SystemTestRunner();
        for (final AStarTestCase.Test test : AStarTestCase.TESTS) {
            testRunner.addTestCase(new ExternalTestCase("Test", new ExternalTestCase.ExternalTest() {
                @Override
                public boolean execute(OutputStream outputStream) throws IOException {
                    List<Node<Character>> path = AStar.findPath(test.edges, test.start, test.target);
                    boolean success;
                    if (path == null && test.answer == null) {
                        success = true;
                    } else if (path == null) {
                        success = false;
                    } else {
                        Iterator<Node<Character>> pathItr = path.iterator();
                        Iterator<Node<Character>> ansItr = test.answer.iterator();
                        success = path.size() == test.answer.size();
                        outputStream.write("Fount Path: ".getBytes());
                        while (success && pathItr.hasNext()) {
                            Node<Character> pathNode = pathItr.next();
                            outputStream.write((pathNode.getValue() + " => ").getBytes());
                            success = pathNode.equals(ansItr.next());
                        }
                        outputStream.write("|\n".getBytes());
                    }
                    return success;
                }
            }));
        }
        testRunner.runTests();
    }
}
