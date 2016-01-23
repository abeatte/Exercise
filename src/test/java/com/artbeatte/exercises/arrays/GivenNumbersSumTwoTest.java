package com.artbeatte.exercises.arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author art.beatte
 * @version 1/22/16
 */
public class GivenNumbersSumTwoTest {

    private SumInArrayFindable mGNS2;

    @Before
    public void setUp() {
        mGNS2 = new GivenNumbersSumTwo();
    }

    @Test
    public void testGivenSumNumbers() {
        int[] testArray = {1, 2, 4, 7, 11, 15};
        int[] solution = mGNS2.find(testArray, 15);

        assertEquals(solution.length, 2);
        assertTrue(solution[0] != solution[1]);
        assertTrue(solution[0] == 4 || solution[0] == 11);
        assertTrue(solution[1] == 4 || solution[1] == 11);
    }
}
