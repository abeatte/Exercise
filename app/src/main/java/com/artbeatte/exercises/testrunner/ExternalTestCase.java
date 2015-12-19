package com.artbeatte.exercises.testrunner;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author art.beatte
 * @version 11/13/15
 */
public class ExternalTestCase implements TestCase {

    public interface ExternalTest {
        /**
         * External TestCase Case to be ran
         * @param outputStream used to write output for the test
         * @return true if the test was successful
         */
        boolean execute(OutputStream outputStream) throws IOException;
    }

    private final String mName;
    private final ExternalTest mExternalTest;

    public ExternalTestCase(String testName, ExternalTest externalTest) {
        mName = testName;
        mExternalTest = externalTest;
    }

    @Override
    public String getName() {
        return mName;
    }

    public boolean execute(OutputStream outputStream) throws IOException {
        return mExternalTest.execute(outputStream);
    }
}
