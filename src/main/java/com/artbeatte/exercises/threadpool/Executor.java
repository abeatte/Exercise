package com.artbeatte.exercises.threadpool;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author art.beatte
 * @version 1/19/16
 */
public class Executor {
    private ConcurrentLinkedQueue<Runnable> mQ;
    private AtomicBoolean initiating;
    private AtomicInteger numThreadsRunning;

    public Executor() {
        mQ = new ConcurrentLinkedQueue<>();
        initiating = new AtomicBoolean(false);
        numThreadsRunning = new AtomicInteger(0);
    }

    public void execute(Runnable r) {
        mQ.offer(r);
        start();
    }

    private void start() {
        if (!initiating.getAndSet(true)) {
            while (!mQ.isEmpty()) {
                if (numThreadsRunning.incrementAndGet() < 5) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Runnable runnable = mQ.poll();
                            while (runnable != null) {
                                runnable.run();
                                runnable = mQ.poll();
                            }
                            numThreadsRunning.decrementAndGet();
                        }
                    }).start();
                } else {
                    numThreadsRunning.decrementAndGet();
                }
            }
            initiating.set(false);
        }
    }
}
