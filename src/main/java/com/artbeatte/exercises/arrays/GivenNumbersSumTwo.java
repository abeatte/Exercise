package com.artbeatte.exercises.arrays;

/**
 * @author art.beatte
 * @version 1/22/16
 *
 * Given a sorted array and a number s, find two numbers whose sum is s.
 * If there are multiple pairs with sum s, just output any one of them.
 *
 * For example, if the inputs are an array {1, 2, 4, 7, 11, 15} and a number 15, return two numbers 4 and 11 since 4+11=15.
 */
public class GivenNumbersSumTwo implements ArrayFindable {
    @Override
    public int[] find(int[] array, int sum) {
        int[] answer = null;
        int indexSmall = 0;
        int indexLarge = array.length - 1;

        while (indexSmall < indexLarge) {
            int currentSum = array[indexSmall] + array[indexLarge];
            if (currentSum > sum) {
                indexLarge--;
            } else if (currentSum < sum) {
                indexSmall++;
            } else {
                answer = new int[]{array[indexSmall], array[indexLarge]};
                break;
            }
        }

        return answer;
    }
}
