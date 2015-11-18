package com.artbeatte.exercises.testrunner;

import com.artbeatte.exercises.testrunner.tests.*;

/**
 * @author art.beatte
 * @version 11/14/15
 */
public class TestAll {

    /**
     * Kicks off test suites for all enrolled projects
     * @param args system args
     */
    public static void main(String[] args) {
        BstTest.main(args);
        RunLengthEncodingTest.main(args);
        SudokuTest.main(args);
        HashMapWTimeTest.main(args);
        BowlingBallTest.main(args);
        RectTest.main(args);
        LinkedListNodeTest.main(args);
        // MeetingSchedulerTest.main(args);

        // ElevatorBankTest.main(args);
    }
}
