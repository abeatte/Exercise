package com.artbeatte.exercises.tests;

import com.artbeatte.exercises.strings.RunLengthEncoding;
import com.artbeatte.exercises.strings.RunLengthEncodingTestCase;
import com.artbeatte.testrunner.MethodParameterTestCase;
import com.artbeatte.testrunner.MethodTestCase;
import com.artbeatte.testrunner.SystemTestRunner;
import com.artbeatte.testrunner.TestRunner;

/**
 * @author art.beatte
 * @version 11/17/15
 */
public class RunLengthEncodingTest {

    public static void main(String[] args) {
        TestRunner testRunner = new SystemTestRunner();
        for (String test : RunLengthEncodingTestCase.TESTS.keySet()) {
            RunLengthEncoding rle = new RunLengthEncoding(test);
            testRunner.addTestCase(new MethodTestCase<>(rle, "encode", RunLengthEncodingTestCase.TESTS.get(test)));
            testRunner.addTestCase(
                    new MethodParameterTestCase<>(rle, "decode", String.class, rle.encode(), test));
        }
        testRunner.runTests();
    }
}
