package com.artbeatte.exercises.tests;

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
        // exercises
        BstTest.main(args);
        RunLengthEncodingTest.main(args);
        SudokuTest.main(args);
        HashMapWTimeTest.main(args);
//        BowlingBallTest.main(args);
//        RectTest.main(args);
//        LinkedListNodeTest.main(args);
        MeetingSchedulerTest.main(args);
        BinarySearchTest.main(args);
        DijkstraTest.main(args);
        AStarTest.main(args);

        // programs
        // ElevatorBankTest.main(args);
    }
}
