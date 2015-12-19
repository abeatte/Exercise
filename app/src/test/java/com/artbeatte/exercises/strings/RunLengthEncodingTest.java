package com.artbeatte.exercises.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author art.beatte
 * @version 11/17/15
 */
public class RunLengthEncodingTest {

    @Test
    public void testEncode() {
        for (String test : RunLengthEncodingTestCase.TESTS.keySet()) {
            RunLengthEncoding rle = new RunLengthEncoding(test);

            assertEquals("Encoding is wrong", rle.encode(), RunLengthEncodingTestCase.TESTS.get(test));
        }
    }

    @Test
    public void testDecode() {
        for (String test : RunLengthEncodingTestCase.TESTS.keySet()) {
            RunLengthEncoding rle = new RunLengthEncoding(test);

            assertEquals("Decoding is wrong", RunLengthEncoding.decode(rle.encode()), test);
        }
    }
}
