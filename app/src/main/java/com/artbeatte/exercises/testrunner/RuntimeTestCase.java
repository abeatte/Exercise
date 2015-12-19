package com.artbeatte.exercises.testrunner;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author art.beatte
 * @version 12/15/15
 */
public class RuntimeTestCase implements TestCase {

    public interface RuntimeTest {
        /**
         * External TestCase Case to be ran
         * @return true if the test was successful
         */
        boolean execute() throws IOException;

        /**
         * Results to the TestCase Case that was ran
         * @param outputStream used to write output for the test
         * @param runtime the length of time the test took to run
         */
        void result(OutputStream outputStream, long runtime) throws IOException;
    }

    private final String mName;
    private final RuntimeTest mRuntimeTest;

    public RuntimeTestCase(String testName, RuntimeTest externalTest) {
        mName = testName;
        mRuntimeTest = externalTest;
    }

    @Override
    public String getName() {
        return mName;
    }

    public boolean execute(OutputStream outputStream) throws IOException {
        long startTime = System.currentTimeMillis();
        boolean outcome = mRuntimeTest.execute();
        mRuntimeTest.result(outputStream, System.currentTimeMillis() - startTime);
        return outcome;
    }
}
