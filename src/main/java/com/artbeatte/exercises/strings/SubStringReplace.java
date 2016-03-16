package com.artbeatte.exercises.strings;

/**
 * @author art.beatte
 * @version 3/16/16
 */
public class SubStringReplace {

    /* non-instantiable class */
    private SubStringReplace() { }

    public static char[] replace(char[] string, char[] target, char[] replacement) {
        if (string == null || target == null || replacement == null || string.length == 0 || string.length < target.length) {
            return string;
        }

        int wordDifference = replacement.length - target.length;

        int sInd = 0;
        while (sInd < string.length) {
            if (indexStartsWord(string, sInd, target)) {
                string = replaceWord(string, sInd, replacement, wordDifference);
                sInd += replacement.length;
            } else {
                sInd++;
            }
        }

        return string;
    }

    private static boolean indexStartsWord(char[] string, int sInd, char[] target) {
        boolean isWord = (string.length - sInd) >= target.length;

        for (int tInd = 0; isWord && tInd < target.length; tInd++) {
            isWord = string[sInd] == target[tInd];
            sInd++;
        }

        return isWord;
    }

    private static char[] replaceWord(char[] string, int sInd, char[] replacement, int wordDifference) {
        char[] ret = string;
        if (wordDifference < 0) {
            // shrink array
            ret = new char[string.length - wordDifference];
        } else if (wordDifference > 0) {
            // grow array
            ret = new char[string.length + wordDifference];
        }

        // optimization: this will iterate over the entire array even when it's the same size. TODO
        int rInd = 0;
        for (int i = 0; i < ret.length; i++) {
            if (i < sInd) {
                // copy head
                ret[i] = string[i];
            } else if (i >= sInd + replacement.length) {
                // copy tail
                ret[i] = string[i - wordDifference];
            } else {
                // replacement
                ret[i] = replacement[rInd++];
            }
        }

        return ret;
    }
}
