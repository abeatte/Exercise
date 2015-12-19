package com.artbeatte.exercises.testrunner;

import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * @author art.beatte
 * @version 11/13/15
 */
public class MethodParameterTestCase<T, V> extends MethodTestCase<V> {

    private final Class<T> mMethodParameterClass;
    private final T mMethodParameter;

    public MethodParameterTestCase(Object testClass, String testMethod, Class<T> methodParameterClass, T methodParameter, V successResult) {
        super(testClass, testMethod, successResult);
        mMethodParameterClass = methodParameterClass;
        mMethodParameter = methodParameter;
    }

    @Override
    public boolean execute(OutputStream outputStream) {
        try {
            return isSuccess(mTestClass.getClass().getMethod(mTestMethod, mMethodParameterClass)
                    .invoke(mTestClass, mMethodParameter));
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return false; // TODO: throw TestCaseException
    }
}
