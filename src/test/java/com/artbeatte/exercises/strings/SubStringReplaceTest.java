package com.artbeatte.exercises.strings;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

/**
 * @author art.beatte
 * @version 3/16/16
 */
public class SubStringReplaceTest {

    private static char[] sValidTestString = "Fact: Facebook users enjoy General Motors!".toCharArray();
    private static char[] sEmptyTestString = "".toCharArray();
    private static char[] sUsersTarget = "users".toCharArray();
    private static char[] sPeopleReplace = "people".toCharArray();
    private static char[] sNumberReplace = "12".toCharArray();
    private static char[] sCustsReplace = "custs".toCharArray();

    @Test
    public void testNull() {
        assertNull(SubStringReplace.replace(null, sUsersTarget, sCustsReplace));
    }

    @Test
    public void testEmpty() {
        assertArrayEquals(SubStringReplace.replace(sEmptyTestString, sUsersTarget, sCustsReplace), sEmptyTestString);
    }

    @Test
    public void testSameSize() {
        char[] answer = "Fact: Facebook custs enjoy General Motors!".toCharArray();
        assertArrayEquals(SubStringReplace.replace(sValidTestString, sUsersTarget, sCustsReplace), answer);
    }

    @Test
    public void testSmaller() {
        char[] answer = "Fact: Facebook 12 enjoy General Motors!".toCharArray();
        assertArrayEquals(SubStringReplace.replace(sValidTestString, sUsersTarget, sNumberReplace), answer);
    }

    @Test
    public void testLarger() {
        char[] answer = "Fact: Facebook people enjoy General Motors!".toCharArray();
        assertArrayEquals(SubStringReplace.replace(sValidTestString, sUsersTarget, sPeopleReplace), answer);
    }

    // TODO: test replacement at beginning and end of array.
}
