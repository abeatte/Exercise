package com.artbeatte.exercises.tests;

import com.artbeatte.exercises.algorithms.searching.BinarySearch;
import com.artbeatte.testrunner.RuntimeTestCase;
import com.artbeatte.testrunner.SystemTestRunner;
import com.artbeatte.testrunner.TestRunner;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author art.beatte
 * @version 12/15/15
 */
public class BinarySearchTest {

    public static void main(String[] args) {
        TestRunner testRunner = new SystemTestRunner();
        //  region day 1 impl test
        testRunner.addTestCase(new RuntimeTestCase("BinarySearch1: NULL", new RuntimeTestCase.RuntimeTest() {
            @Override
            public boolean execute() throws IOException {
                return BinarySearch.search1(ArrayTestCases.NULL, 0) == -1;
            }

            @Override
            public void result(OutputStream outputStream, long runtime) throws IOException {
                outputStream.write(("runtime: " + runtime + "\n").getBytes());
            }
        }));
        testRunner.addTestCase(new RuntimeTestCase("BinarySearch1: EMPTY", new RuntimeTestCase.RuntimeTest() {
            @Override
            public boolean execute() throws IOException {
                return BinarySearch.search1(ArrayTestCases.EMPTY, 0) == -1;
            }

            @Override
            public void result(OutputStream outputStream, long runtime) throws IOException {
                outputStream.write(("runtime: " + runtime + "\n").getBytes());
            }
        }));
        testRunner.addTestCase(new RuntimeTestCase("BinarySearch1: SMALL", new RuntimeTestCase.RuntimeTest() {
            @Override
            public boolean execute() throws IOException {
                boolean success = BinarySearch.search1(ArrayTestCases.SMALL, 9) == -1;
                success = success && BinarySearch.search1(ArrayTestCases.SMALL, 6) == 3;

                return success;
            }

            @Override
            public void result(OutputStream outputStream, long runtime) throws IOException {
                outputStream.write(("runtime: " + runtime + "\n").getBytes());
            }
        }));
        testRunner.addTestCase(new RuntimeTestCase("BinarySearch1: MEDIUM", new RuntimeTestCase.RuntimeTest() {
            @Override
            public boolean execute() throws IOException {
                boolean success = BinarySearch.search1(ArrayTestCases.MEDIUM, 9) == -1;
                success = success && BinarySearch.search1(ArrayTestCases.MEDIUM, 6) == 3;
                success = success && BinarySearch.search1(ArrayTestCases.MEDIUM, 100) == 50;

                return success;
            }

            @Override
            public void result(OutputStream outputStream, long runtime) throws IOException {
                outputStream.write(("runtime: " + runtime + "\n").getBytes());
            }
        }));
        testRunner.addTestCase(new RuntimeTestCase("BinarySearch1: LARGE", new RuntimeTestCase.RuntimeTest() {
            @Override
            public boolean execute() throws IOException {
                boolean success = BinarySearch.search1(ArrayTestCases.LARGE, 9) == -1;
                success = success && BinarySearch.search1(ArrayTestCases.LARGE, 20) == 10;
                success = success && BinarySearch.search1(ArrayTestCases.LARGE, 16) == 8;
                success = success && BinarySearch.search1(ArrayTestCases.LARGE, 60) == 30;

                return success;
            }

            @Override
            public void result(OutputStream outputStream, long runtime) throws IOException {
                outputStream.write(("runtime: " + runtime + "\n").getBytes());
            }
        }));
        testRunner.addTestCase(new RuntimeTestCase("BinarySearch1: EXTRA_LARGE", new RuntimeTestCase.RuntimeTest() {
            @Override
            public boolean execute() throws IOException {
                boolean success = BinarySearch.search1(ArrayTestCases.EXTRA_LARGE, 9) == -1;
                success = success && BinarySearch.search1(ArrayTestCases.EXTRA_LARGE, 20) == 10;
                success = success && BinarySearch.search1(ArrayTestCases.EXTRA_LARGE, 16) == 8;
                success = success && BinarySearch.search1(ArrayTestCases.EXTRA_LARGE, 60) == 30;

                return success;
            }

            @Override
            public void result(OutputStream outputStream, long runtime) throws IOException {
                outputStream.write(("runtime: " + runtime + "\n").getBytes());
            }
        }));
        // endregion

        //  region day 2 impl test
        testRunner.addTestCase(new RuntimeTestCase("BinarySearch1: NULL", new RuntimeTestCase.RuntimeTest() {
            @Override
            public boolean execute() throws IOException {
                return BinarySearch.search1(ArrayTestCases.NULL, 0) == -1;
            }

            @Override
            public void result(OutputStream outputStream, long runtime) throws IOException {
                outputStream.write(("runtime: " + runtime + "\n").getBytes());
            }
        }));
        testRunner.addTestCase(new RuntimeTestCase("BinarySearch2: EMPTY", new RuntimeTestCase.RuntimeTest() {
            @Override
            public boolean execute() throws IOException {
                return BinarySearch.search2(ArrayTestCases.EMPTY, 0) == -1;
            }

            @Override
            public void result(OutputStream outputStream, long runtime) throws IOException {
                outputStream.write(("runtime: " + runtime + "\n").getBytes());
            }
        }));
        testRunner.addTestCase(new RuntimeTestCase("BinarySearch2: SMALL", new RuntimeTestCase.RuntimeTest() {
            @Override
            public boolean execute() throws IOException {
                boolean success = BinarySearch.search2(ArrayTestCases.SMALL, 9) == -1;
                success = success && BinarySearch.search2(ArrayTestCases.SMALL, 6) == 3;

                return success;
            }

            @Override
            public void result(OutputStream outputStream, long runtime) throws IOException {
                outputStream.write(("runtime: " + runtime + "\n").getBytes());
            }
        }));
        testRunner.addTestCase(new RuntimeTestCase("BinarySearch2: MEDIUM", new RuntimeTestCase.RuntimeTest() {
            @Override
            public boolean execute() throws IOException {
                boolean success = BinarySearch.search2(ArrayTestCases.MEDIUM, 9) == -1;
                success = success && BinarySearch.search2(ArrayTestCases.MEDIUM, 6) == 3;
                success = success && BinarySearch.search2(ArrayTestCases.MEDIUM, 100) == 50;

                return success;
            }

            @Override
            public void result(OutputStream outputStream, long runtime) throws IOException {
                outputStream.write(("runtime: " + runtime + "\n").getBytes());
            }
        }));
        testRunner.addTestCase(new RuntimeTestCase("BinarySearch2: LARGE", new RuntimeTestCase.RuntimeTest() {
            @Override
            public boolean execute() throws IOException {
                boolean success = BinarySearch.search2(ArrayTestCases.LARGE, 9) == -1;
                success = success && BinarySearch.search2(ArrayTestCases.LARGE, 20) == 10;
                success = success && BinarySearch.search2(ArrayTestCases.LARGE, 16) == 8;
                success = success && BinarySearch.search2(ArrayTestCases.LARGE, 60) == 30;

                return success;
            }

            @Override
            public void result(OutputStream outputStream, long runtime) throws IOException {
                outputStream.write(("runtime: " + runtime + "\n").getBytes());
            }
        }));
        testRunner.addTestCase(new RuntimeTestCase("BinarySearch2: EXTRA_LARGE", new RuntimeTestCase.RuntimeTest() {
            @Override
            public boolean execute() throws IOException {
                boolean success = BinarySearch.search2(ArrayTestCases.EXTRA_LARGE, 9) == -1;
                success = success && BinarySearch.search2(ArrayTestCases.EXTRA_LARGE, 20) == 10;
                success = success && BinarySearch.search2(ArrayTestCases.EXTRA_LARGE, 16) == 8;
                success = success && BinarySearch.search2(ArrayTestCases.EXTRA_LARGE, 60) == 30;

                return success;
            }

            @Override
            public void result(OutputStream outputStream, long runtime) throws IOException {
                outputStream.write(("runtime: " + runtime + "\n").getBytes());
            }
        }));
        // endregion
        testRunner.runTests();
    }
}
