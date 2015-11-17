package com.artbeatte.exercises.bowlingball;

import com.artbeatte.exercises.testing.ExternalTestCase;
import com.artbeatte.exercises.testing.SystemTestRunner;
import com.artbeatte.exercises.testing.TestRunner;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by sarbs on 11/16/15.
 */
public class BowlingBall {
    private final int breakingHeight;
    private boolean broken;
    private int drops;

    public BowlingBall(int breakingHeight) {
        this.breakingHeight = breakingHeight;
    }

    /**
     * Tests if a ball will break when dropped from a particular height. The ball will never break at 0 height.
     *
     * @param height Height to test the ball from.
     * @return Whether or not the ball broke during the test.
     * @throws IllegalStateException if the ball is already broken.
     */
    public boolean drop(int height) {
        if (broken)
            throw new IllegalStateException("ball is already broken!");

        drops++;

        broken = height >= breakingHeight;
        return broken;
    }

    public boolean isBroken() {
        return broken;
    }

    /**
     * @return The number of times this ball has been dropped.
     */
    public int getDrops() {
        return drops;
    }

    /**
     * Finds the maximum height at which a pair of identical {@link BowlingBall}s can be dropped without the balls
     * breaking.
     *
     * @param maxDropPossible The maximum height at which it is possible to drop a ball from, regardless of whether the
     *                        ball will break at that height or not. ("Max height of the building being tested")
     * @param first A {@link BowlingBall} that will break at a predetermined height
     * @param second Another {@link BowlingBall} that will break at the same height
     * @return The maximum height at which more identical balls can be dropped without them breaking.
     */
    public static int maxHeight(int maxDropPossible, BowlingBall first, BowlingBall second) {
        throw new NotImplementedException();
    }

    public static void main(String args[]) {
        TestRunner tr = new SystemTestRunner();

        int[] heights = new int[] { 15, 100, 256, 291, 10068 };
        for (final int height : heights) {
            tr.addTestCase(new ExternalTestCase("findsCorrectHeight" + height,
                    new ExternalTestCase.ExternalTest() {
                        @Override
                        public boolean execute(OutputStream outputStream) throws IOException {
                            for (int i = 1; i <= height; i++) {
                                BowlingBall a = new BowlingBall(i);
                                BowlingBall b = new BowlingBall(i);
                                if (maxHeight(height, a, b) != i - 1)
                                    return false;
                            }
                            return true;
                        }
                    }));

            tr.addTestCase(new ExternalTestCase("findsCorrectHeightAtLeastLinearly" + height,
                    new ExternalTestCase.ExternalTest() {
                        @Override
                        public boolean execute(OutputStream outputStream) throws IOException {
                            int maxDropCount = Integer.MIN_VALUE;
                            for (int i = 1; i <= height; i++) {
                                BowlingBall a = new BowlingBall(i);
                                BowlingBall b = new BowlingBall(i);
                                if (maxHeight(height, a, b) != i - 1)
                                    return false;
                                maxDropCount = Math.max(maxDropCount, a.getDrops() + b.getDrops());
                            }
                            return maxDropCount <= height;
                        }
                    }));

            tr.addTestCase(new ExternalTestCase("beatsLinear" + height,
                    new ExternalTestCase.ExternalTest() {
                        @Override
                        public boolean execute(OutputStream outputStream) throws IOException {
                            int maxDropCount = Integer.MIN_VALUE;
                            for (int i = 1; i <= height; i++) {
                                BowlingBall a = new BowlingBall(i);
                                BowlingBall b = new BowlingBall(i);
                                if (maxHeight(height, a, b) != i - 1)
                                    return false;
                                maxDropCount = Math.max(maxDropCount, a.getDrops() + b.getDrops());
                            }
                            return maxDropCount < Math.ceil(Math.sqrt(height) * 2 - 1);
                        }
                    }));

            tr.addTestCase(new ExternalTestCase("achievesOptimal" + height,
                    new ExternalTestCase.ExternalTest() {
                        @Override
                        public boolean execute(OutputStream outputStream) throws IOException {
                            int maxDropCount = Integer.MIN_VALUE;
                            for (int i = 1; i <= height; i++) {
                                BowlingBall a = new BowlingBall(i);
                                BowlingBall b = new BowlingBall(i);
                                if (maxHeight(height, a, b) != i - 1)
                                    return false;
                                maxDropCount = Math.max(maxDropCount, a.getDrops() + b.getDrops());
                            }
                            return maxDropCount <= Math.ceil((Math.sqrt(8 * height - 1) + 1) / 2);
                        }
                    }));
        }

        tr.runTests();
    }
}
