package com.artbeatte.exercises.threadpool;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author art.beatte
 * @version 1/21/16
 */
public class ExecutorTestCase {

    public static final long SECOND = 1000;

    public static final List<Runnable> EXECUTOR_TEST = new LinkedList<>();
    static {
        for (int i = 1; i < 50; i++) {
            final int finalI = i;
            EXECUTOR_TEST.add(new Runnable() {
                @Override
                public void run() {
                    try {
                        long wait = SECOND * (new Random().nextInt(4) + 1);
                        Thread.sleep(wait);
                        System.out.println("Ran(" + finalI + ") and waited for " + wait / SECOND);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
