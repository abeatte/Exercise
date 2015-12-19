package com.artbeatte.exercises.bowlingball;

/**
 * @author sarbs
 * @version 11/16/15
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
        // TODO: implement;
        return -1;
    }
}
