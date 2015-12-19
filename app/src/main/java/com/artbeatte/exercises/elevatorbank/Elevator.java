package com.artbeatte.exercises.elevatorbank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author art.beatte
 * @version 8/28/15
 */
public class Elevator {
    private static final int DEFAULT_FLOOR = 1;
    private int mFloor;
    private int mDestination;
    private List<Passenger> mPassengers;

    public Elevator() {
        mFloor = 1;
        mDestination = 1;
        mPassengers = new ArrayList<>();
    }

    public int getFloor() {
        return mFloor;
    }

    public int getDestination() {
        return mDestination;
    }

    public void addPassenger(Passenger passenger) {
        passenger.pickUp(mFloor);
        mPassengers.add(passenger);
        updateDestination(passenger);
    }

    public void requestFloor(int floor) {
        if (isIdle()) {
            mDestination = floor;
        }
    }

    private void updateDestination(Passenger passenger) {
        switch (getDirection()) {
            case UP:
                if (passenger.getDestination() > mDestination) {
                    mDestination = passenger.getDestination();
                }
                break;
            case DOWN:
                if (passenger.getDestination() < mDestination) {
                    mDestination = passenger.getDestination();
                }
                break;
            case STILL:
                mDestination = passenger.getDestination();
                break;
        }
    }

    public Direction getDirection() {
        Direction dir = Direction.STILL;
        if (mDestination > mFloor) {
            dir = Direction.UP;
        } else if (mDestination < mFloor) {
            dir = Direction.DOWN;
        }
        return dir;
    }

    public List<Passenger> getPassengers() {
        return mPassengers;
    }

    public boolean isEmpty() {
        return mPassengers.isEmpty();
    }

    public boolean isIdle() {
        return isEmpty() && mDestination == mFloor;
    }

    void goToLobby() {
        if (isEmpty() && mFloor != DEFAULT_FLOOR) {
            mDestination = DEFAULT_FLOOR;
        }
    }

    private boolean shouldPickUp(Passenger p) {
        boolean pickUp = false;
        switch (getDirection()) {
            case UP:
                if (p.getFloor() == mFloor && p.getDestination() <= mDestination) {
                   pickUp = true;
                }
                break;
            case DOWN:
                if (p.getFloor() == mFloor && p.getDestination() >= mDestination) {
                    pickUp = true;
                }
                break;
            case STILL:
                if (p.getFloor() == mFloor) {
                    pickUp = true;
                }
                break;
        }
        return pickUp;
    }

    private boolean shouldDeliver(Passenger p) {
        return p.getDestination() == mFloor;
    }

    /**
     * Method used to advance an {@link Elevator} one turn in time.
     */
    void advance() {
        if (mFloor < mDestination) {
            mFloor++;
        } else if (mFloor > mDestination){
            mFloor--;
        }
        if (!mPassengers.isEmpty()) {
            // we are ready to begin
            Iterator<Passenger> itr = mPassengers.iterator();
            while (itr.hasNext()) {
                Passenger p = itr.next();
                if (shouldPickUp(p)) {
                    if (p.getFloor() == p.getDestination()) {
                        p.deliver(mFloor);
                    } else {
                        p.pickUp(mFloor);
                        mPassengers.add(p);
                        updateDestination(p);
                    }
                    // we have arrived
                } else if (shouldDeliver(p)) {
                    p.deliver(mFloor);
                    itr.remove();
                }
            }
        }
    }
}
