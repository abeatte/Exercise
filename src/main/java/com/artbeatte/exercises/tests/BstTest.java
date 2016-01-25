package com.artbeatte.exercises.tests;

import com.artbeatte.exercises.trees.binary.BinarySearchTree;
import com.artbeatte.exercises.trees.binary.BstTestCase;
import com.artbeatte.testrunner.ExternalTestCase;
import com.artbeatte.testrunner.MethodTestCase;
import com.artbeatte.testrunner.SystemTestRunner;
import com.artbeatte.testrunner.TestRunner;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author art.beatte
 * @version 11/17/15
 */
public class BstTest {

    public static void main(String[] args) {
        final BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        final boolean[] sizeSuccess = {false};

        TestRunner testRunner = new SystemTestRunner();
        // alternately:      `= new FileTestRunner("testFile.txt");`
        testRunner.addTestCase(new ExternalTestCase("add", new ExternalTestCase.ExternalTest() {
            @Override
            public boolean execute(OutputStream os) throws IOException {
                // setup
                boolean addSuccess;
                os.write(("Initial state: " + bst.serialize() + "\n").getBytes());

                os.write("Populating".getBytes());
                sizeSuccess[0] = bst.size() == 0;
                bst.add(5);
                os.write(".".getBytes());
                sizeSuccess[0] = sizeSuccess[0] && bst.size() == 1;
                addSuccess = bst.contains(5);
                bst.add(34);
                os.write(".".getBytes());
                bst.add(10);
                os.write(".".getBytes());
                sizeSuccess[0] = sizeSuccess[0] && bst.size() == 3;
                addSuccess = addSuccess && bst.contains(34);
                addSuccess = addSuccess && bst.contains(10);
                bst.add(2);
                os.write(".".getBytes());
                bst.add(200);
                os.write(".".getBytes());
                bst.add(44);
                os.write(".".getBytes());
                os.write("\n".getBytes());
                sizeSuccess[0] = sizeSuccess[0] && bst.size() == 6;
                addSuccess = addSuccess && bst.contains(2);
                addSuccess = addSuccess && bst.contains(200);
                addSuccess = addSuccess && bst.contains(44);
                os.write("\n".getBytes());

                return addSuccess;
            }
        }));
        testRunner.addTestCase(new ExternalTestCase("size", new ExternalTestCase.ExternalTest() {
            @Override
            public boolean execute(OutputStream os) {
                return sizeSuccess[0];
            }
        }));
        testRunner.addTestCase(new ExternalTestCase("serialize", new ExternalTestCase.ExternalTest() {
            @Override
            public boolean execute(OutputStream os) throws IOException {
                os.write("\n".getBytes());
                os.write(("State: " + bst.serialize() + "\n").getBytes());
                boolean success = bst.serialize().contentEquals(new BinarySearchTree<Integer>(bst.serialize()).serialize());
                os.write(("State: " + bst.serialize() + "\n").getBytes());
                os.write("\n".getBytes());

                return success;
            }
        }));
//        testRunner.addTestCase(new MethodTestCase<>(binary, "serialize", new BinarySearchTree<Integer>(binary.serialize()).serialize()));
        testRunner.addTestCase(new ExternalTestCase("remove", new ExternalTestCase.ExternalTest() {
            @Override
            public boolean execute(OutputStream os) throws IOException {
                // teardown
                os.write("\n".getBytes());
                os.write("Resetting".getBytes());
                bst.remove(10);
                os.write(".".getBytes());
                bst.remove(44);
                os.write(".".getBytes());
                bst.remove(200);
                os.write(".".getBytes());
                bst.remove(34);
                os.write(".".getBytes());
                bst.remove(2);
                os.write(".".getBytes());
                bst.remove(5);
                os.write("\n".getBytes());
                os.write("\n".getBytes());
                os.write(("State: " + bst.serialize() + "\n").getBytes());
                os.write("\n".getBytes());

                return bst.isEmpty();
            }
        }));
        testRunner.addTestCase(new MethodTestCase<>(BstTestCase.LARGE, "getDepth", 4));
        testRunner.addTestCase(new MethodTestCase<>(BstTestCase.LARGE, "getEdgeWidth", 4));
        testRunner.addTestCase(new MethodTestCase<>(BstTestCase.LARGE, "getMaxWidth", 3));

        testRunner.addTestCase(new MethodTestCase<>(BstTestCase.EMPTY, "getDepth", 0));
        testRunner.addTestCase(new MethodTestCase<>(BstTestCase.EMPTY, "getEdgeWidth", 0));
        testRunner.addTestCase(new MethodTestCase<>(BstTestCase.EMPTY, "getMaxWidth", 0));

        testRunner.addTestCase(new MethodTestCase<>(BstTestCase.SMALL, "getDepth", 2));
        testRunner.addTestCase(new MethodTestCase<>(BstTestCase.SMALL, "getEdgeWidth", 2));
        testRunner.addTestCase(new MethodTestCase<>(BstTestCase.SMALL, "getMaxWidth", 2));

        testRunner.addTestCase(new MethodTestCase<>(BstTestCase.SINGLE, "getDepth", 1));
        testRunner.addTestCase(new MethodTestCase<>(BstTestCase.SINGLE, "getEdgeWidth", 0));
        testRunner.addTestCase(new MethodTestCase<>(BstTestCase.SINGLE, "getMaxWidth", 1));

        testRunner.addTestCase(new MethodTestCase<>(BstTestCase.X_LARGE, "getDepth", 7));
        testRunner.addTestCase(new MethodTestCase<>(BstTestCase.X_LARGE, "getEdgeWidth", 5));
        testRunner.addTestCase(new MethodTestCase<>(BstTestCase.X_LARGE, "getMaxWidth", 3));

        testRunner.addTestCase(new MethodTestCase<>(BstTestCase.STRING, "getDepth", 2));
        testRunner.addTestCase(new MethodTestCase<>(BstTestCase.STRING, "getEdgeWidth", 2));
        testRunner.addTestCase(new MethodTestCase<>(BstTestCase.STRING, "getMaxWidth", 2));

        testRunner.runTests();
    }
}
