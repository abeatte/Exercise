package com.artbeatte.exercises.testrunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author art.beatte
 * @version 11/14/15
 */
abstract class BaseTestRunner implements TestRunner {

    List<TestCase> mTestCases;

    public BaseTestRunner() {
        mTestCases = new ArrayList<>();
    }

    @Override
    public void addTestCase(TestCase test) {
        mTestCases.add(test);
    }

    protected static String getBanner(String msg) {
        StringBuilder sb = new StringBuilder();
        String divider = "";
        for (int i = 0; i < msg.length(); i++) {
            divider += "=";
        }
        sb.append("\n")
                .append(divider)
                .append("\n")
                .append(msg)
                .append("\n")
                .append(divider)
                .append("\n")
                .append("\n");
        return sb.toString();
    }

    protected static String getResults(int numFailures, int numTotalTests) {
        StringBuilder sb = new StringBuilder();
        String results;
        if (numFailures > 0) {
            results = " TestCase Failures: " + numFailures + "/" + numTotalTests + "  ";
        } else {
            results = "All Tests Pass! (" + numTotalTests + "/" + numTotalTests + ")";
        }
        String divider = "";
        for (int i = 0; i < results.length(); i++) {
            divider += "-";
        }
        sb.append("\n")
                .append(divider)
                .append("\n")
                .append(results);
        return sb.toString();
    }
}
