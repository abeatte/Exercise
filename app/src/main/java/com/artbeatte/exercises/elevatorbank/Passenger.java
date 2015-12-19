package com.artbeatte.exercises.elevatorbank;

/**
 * @author art.beatte
 * @version 8/28/15
 */
class Passenger {
    private static final int DISTANCE_FROM_BANK = 10;
    private int mFloor;
    private int mDestination;
    private boolean mHasHailedElevator;
    private int mDistanceFromBank;

    Passenger(int origin, int destination, int distanceFromBank) {
        mFloor = origin;
        mDestination = destination;
        mHasHailedElevator = false;
        mDistanceFromBank = distanceFromBank;
    }

    Passenger(int origin, int destination) {
        this(origin, destination, DISTANCE_FROM_BANK);
    }

    public int getFloor() {
        return mFloor;
    }

    public int getDestination() {
        return mDestination;
    }

    public void setHasHailedElevator(boolean hailed) {
        mHasHailedElevator = hailed;
    }

    public boolean hasHailedElevator() {
        return mHasHailedElevator;
    }

    public boolean isWaiting() {
        return !isInElevator() && mFloor != mDestination && mDistanceFromBank == 0;
    }

    public boolean isInElevator() {
        return mFloor < 0;
    }

    public void pickUp(int floor) {
        mFloor = -1;
    }

    public void deliver(int floor) {
        mFloor = floor;
    }

    int getDistanceFromBank() {
        return mDistanceFromBank;
    }

    /**
     * Method used to advance an {@link Passenger} one turn in time.
     * @return true if the {@link Passenger} has advanced out of play
     */
    boolean advance() {
        if (!isInElevator()) {
            if (mFloor == mDestination) {
                if (mDistanceFromBank < DISTANCE_FROM_BANK) {
                    mDistanceFromBank++;
                } else {
                    return true;
                }
            } else {
                if (mDistanceFromBank > 0) {
                    mDistanceFromBank--;
                }
            }
        }
        return false;
    }
}
