package com.artbeatte.exercises.arrays;

/**
 * @author art.beatte
 * @version 1/22/16
 *
 * Given a sorted array and a number s, find 3 numbers whose sum is s.
 * If there are multiple sets with sum s, just output any one of them.
 *
 * For example, if the inputs are an array {1, 2, 4, 7, 11, 15} and a number 30, return out the numbers 4, 11 and 15 since 4+11+15=30.
 */
public class GivenNumbersSumThree implements ArrayFindable {
    @Override
    public int[] find(int[] array, int sum) {
        int[] answer = null;

        for (int i = 0; i < array.length; i++) {
            int[] tmp = sum(array, sum - array[i], i);
            if (tmp != null)  {
                answer = new int[]{array[i], tmp[0], tmp[1]};
            }
        }

        return answer;
    }

    private int[] sum(int[] array, int sum, int ignoreIndex) {
        int[] answer = null;
        int indexSmall = 0;
        int indexLarge = array.length - 1;
        while (indexSmall < indexLarge) {
            // skip ignoreIndex
            if (indexSmall == ignoreIndex) {
                indexSmall++;
            } else if (indexLarge == ignoreIndex) {
                indexLarge--;
            }

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
