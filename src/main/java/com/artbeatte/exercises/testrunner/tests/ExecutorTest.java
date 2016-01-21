package com.artbeatte.exercises.testrunner.tests;

import com.artbeatte.exercises.testrunner.ExternalTestCase;
import com.artbeatte.exercises.testrunner.SystemTestRunner;
import com.artbeatte.exercises.testrunner.TestRunner;
import com.artbeatte.exercises.threadpool.Executor;
import com.artbeatte.exercises.threadpool.ExecutorTestCase;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author art.beatte
 * @version 1/21/16
 */
public class ExecutorTest {

    public static void main(String[] args) {
        TestRunner testRunner = new SystemTestRunner();
        testRunner.addTestCase(new ExternalTestCase("Executor Test", new ExternalTestCase.ExternalTest() {
            @Override
            public boolean execute(OutputStream outputStream) throws IOException {
                Executor executor = new Executor();
                for (Runnable runnable : ExecutorTestCase.EXECUTOR_TEST) {
                    executor.execute(runnable);
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return true;
            }
        }));
        testRunner.runTests();
    }
}
