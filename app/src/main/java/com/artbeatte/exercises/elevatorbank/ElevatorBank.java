package com.artbeatte.exercises.elevatorbank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author art.beatte
 * @version 8/27/15
 */
public class ElevatorBank {

    private int mFloors;
    private List<Elevator> mElevators;
    private List<Passenger> mPeopleWaiting;
    private List<Passenger> mPeopleInTheWorld;

    public ElevatorBank(int numFloors, int numElevators) {
        mFloors = numFloors;
        mElevators = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            mElevators.add(new Elevator());
        }
        mPeopleInTheWorld = new ArrayList<>();
        mPeopleWaiting = new ArrayList<>();
        run();
    }

    private void run() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Display.clearScreen();
                Display.printStatus(mElevators, mFloors, mPeopleInTheWorld);
                while (working()) {
                    for (Elevator e : mElevators) {
                        // Elevator is idle
                        if (e.isIdle()) {
                            Iterator<Passenger> itr = mPeopleWaiting.iterator();
                            while (itr.hasNext()) {
                                Passenger p = itr.next();
                                if (p.isWaiting()) {
//                                    p.setHasHailedElevator(true);
                                    if (e.getFloor() == p.getFloor()) {
                                        e.addPassenger(p);
                                        itr.remove();
                                    } else {
                                        e.requestFloor(p.getFloor());
                                    }
                                }
                            }
                            if (mPeopleWaiting.isEmpty()) {
                                e.goToLobby();
                            }
                        }
                        // Advance Elevators one Turn
                        e.advance();
                    }
                    Iterator<Passenger> itr = mPeopleInTheWorld.iterator();
                    while (itr.hasNext()) {
                        Passenger p = itr.next();
                        if (p.advance()) {
                            itr.remove();
                        } else if (p.isWaiting() && !mPeopleWaiting.contains(p)) { // TODO: bug
                            mPeopleWaiting.add(p);
                        }
                    }
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException ignored) { }
                    Display.clearScreen();
                    Display.printStatus(mElevators, mFloors, mPeopleInTheWorld);
                }
                Display.clearScreen();
                Display.printClosing();
                System.exit(0);
            }
        }).start();
    }

    private boolean working() {
        boolean working = false;
        for (Elevator e : mElevators) {
            working = working || (!e.isIdle() || e.getFloor() != 1);
        }
        return working || !mPeopleInTheWorld.isEmpty();
    }


    private void selectFloor(int fromFloor, int toFloor) {
        Passenger req = new Passenger(fromFloor, toFloor);
        mPeopleInTheWorld.add(req);
    }

    private void selectFloor(int fromFloor, int toFloor, int distance) {
        Passenger req = new Passenger(fromFloor, toFloor, distance);
        mPeopleInTheWorld.add(req);
    }

    public static void main(String[] args) {
        ElevatorBank bank = new ElevatorBank(13, 3);
        bank.selectFloor(1, 13, 3);
        bank.selectFloor(10, 3, 20);
        bank.selectFloor(3, 7, 5);
        bank.selectFloor(1, 5);
        bank.selectFloor(7, 7);
        bank.selectFloor(8, 2);
        bank.selectFloor(3, 8, 5);
    }
}
