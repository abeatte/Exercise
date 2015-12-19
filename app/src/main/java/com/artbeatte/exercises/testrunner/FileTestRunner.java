package com.artbeatte.exercises.testrunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author art.beatte
 * @version 11/14/15
 */
public class FileTestRunner extends BaseTestRunner {

    private File mFile;

    public FileTestRunner(String fileName) {
        mFile = new File(fileName);
    }

    @Override
    public void runTests() {
        int failures = 0;
        printToFile(getBanner("   Starting Tests    "));
        for (TestCase test : mTestCases) {
            boolean success = false;
            try {
                success = test.execute(new FileOutputStream(mFile, true));
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!success) failures ++;
            printToFile(test.getName() + " test: " + (success ? "PASSES" : "FAILS") + "\n");
        }
        printToFile(getResults(failures, mTestCases.size()));
        printToFile(getBanner("  Testing Completed  "));
    }

    private void printToFile(String data) {
        try {
            FileOutputStream fos = new FileOutputStream(mFile, true);
            fos.write(data.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
