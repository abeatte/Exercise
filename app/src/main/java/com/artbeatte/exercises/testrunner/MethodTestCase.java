package com.artbeatte.exercises.testrunner;

import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * @author art.beatte
 * @version 11/13/15
 */
public class MethodTestCase<V> implements TestCase {

    protected final Object mTestClass;
    protected final String mTestMethod;
    protected final V mSuccessResult;

    public MethodTestCase(Object testClass, String testMethod, V successResult) {
        mTestClass = testClass;
        mTestMethod = testMethod;
        mSuccessResult = successResult;
    }

    @Override
    public String getName() {
        return mTestMethod;
    }

    @Override
    public boolean execute(OutputStream outputStream) {
        try {
            return isSuccess(mTestClass.getClass().getMethod(mTestMethod).invoke(mTestClass));
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return false; // TODO: throw TestCaseException
    }

    public boolean isSuccess(Object result) {
        return result.equals(mSuccessResult); // TODO: user compareTo
    }
}
