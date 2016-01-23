package com.artbeatte.exercises.arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author art.beatte
 * @version 1/22/16
 */
public class GivenNumbersSumThreeTest {

    private SumInArrayFindable mGNS3;

    @Before
    public void setUp() {
        mGNS3 = new GivenNumbersSumThree();
    }

    @Test
    public void testGivenSumNumbers() {
        int[] testArray = {1, 2, 4, 7, 11, 15};
        int[] solution = mGNS3.find(testArray, 30);

        assertEquals(solution.length, 3);
        assertTrue(solution[0] != solution[1] && solution[1] != solution[2] && solution[2] != solution[0]);
        assertTrue(solution[0] == 4 || solution[0] == 11 || solution[0] == 15);
        assertTrue(solution[1] == 4 || solution[1] == 11 || solution[1] == 15);
    }
}
