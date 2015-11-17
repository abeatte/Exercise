package com.artbeatte.exercises;

import com.artbeatte.exercises.bowlingball.BowlingBall;
import com.artbeatte.exercises.bst.Bst;
import com.artbeatte.exercises.hashs.HashMapWTime;
import com.artbeatte.exercises.strings.RunLengthEncoding;
import com.artbeatte.exercises.sudoku.Sudoku;

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
        Bst.main(args);
        RunLengthEncoding.main(args);
        Sudoku.main(args);
        HashMapWTime.main(args);
        // MeetingScheduler.main(args);

        // ElevatorBankTest.main(args);

        BowlingBall.main(args);
    }
}
