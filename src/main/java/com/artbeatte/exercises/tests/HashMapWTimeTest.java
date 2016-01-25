package com.artbeatte.exercises.tests;

import com.artbeatte.exercises.hashs.HashMapWTime;
import com.artbeatte.testrunner.ExternalTestCase;
import com.artbeatte.testrunner.MethodTestCase;
import com.artbeatte.testrunner.SystemTestRunner;
import com.artbeatte.testrunner.TestRunner;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author art.beatte
 * @version 11/17/15
 */
public class HashMapWTimeTest {

    public static void main(String[] args) {
        TestRunner testRunner = new SystemTestRunner();
        for (final HashMapWTime<Integer, String> test : TESTS) {
            testRunner.addTestCase(new ExternalTestCase("get", new ExternalTestCase.ExternalTest() {
                @Override
                public boolean execute(OutputStream outputStream) throws IOException {
                    return test.get(3, 200).contentEquals("Two");
                }
            }));
            testRunner.addTestCase(new MethodTestCase<>(test, "isEmpty", false));
            testRunner.addTestCase(new ExternalTestCase("remove", new ExternalTestCase.ExternalTest() {
                @Override
                public boolean execute(OutputStream outputStream) throws IOException {
                    outputStream.write("\nEmptying TimeMap\n".getBytes());
                    test.remove(3, 300);
                    outputStream.write(".".getBytes());
                    test.remove(3, 100);
                    outputStream.write(".".getBytes());
                    test.remove(3, 200);
                    outputStream.write(".".getBytes());
                    test.remove(1, 300);
                    outputStream.write(".".getBytes());
                    test.remove(1, 100);
                    outputStream.write(".".getBytes());
                    test.remove(1, 200);
                    outputStream.write(".".getBytes());
                    // test removing non-present value
                    test.remove(2, 320);
                    test.remove(2, 300);
                    outputStream.write(".".getBytes());
                    test.remove(2, 100);
                    outputStream.write(".".getBytes());
                    test.remove(2, 200);
                    outputStream.write(".\n\n".getBytes());

                    return test.isEmpty();
                }
            }));
        }
        testRunner.runTests();
    }

    private static final HashMapWTime<Integer, String> TIME_MAP = new HashMapWTime<>();
    static {
        TIME_MAP.put(3, 300, "Three");
        TIME_MAP.put(3, 100, "One");
        TIME_MAP.put(3, 200, "Two");
        TIME_MAP.put(1, 300, "Three");
        TIME_MAP.put(1, 100, "One");
        TIME_MAP.put(1, 200, "Two");
        TIME_MAP.put(2, 300, "Three");
        TIME_MAP.put(2, 100, "One");
        TIME_MAP.put(2, 200, "Two");
    }

    private static final List<HashMapWTime<Integer, String>> TESTS = new ArrayList<>();
    static {
        TESTS.add(TIME_MAP);
    }
}
