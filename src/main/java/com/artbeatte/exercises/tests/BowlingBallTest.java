package com.artbeatte.exercises.tests;

import com.artbeatte.exercises.bowlingball.BowlingBall;
import com.artbeatte.testrunner.ExternalTestCase;
import com.artbeatte.testrunner.SystemTestRunner;
import com.artbeatte.testrunner.TestRunner;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author art.beatte
 * @version 11/17/15
 */
public class BowlingBallTest {

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
                                if (BowlingBall.maxHeight(height, a, b) != i - 1)
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
                                if (BowlingBall.maxHeight(height, a, b) != i - 1)
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
                                if (BowlingBall.maxHeight(height, a, b) != i - 1)
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
                                if (BowlingBall.maxHeight(height, a, b) != i - 1)
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
