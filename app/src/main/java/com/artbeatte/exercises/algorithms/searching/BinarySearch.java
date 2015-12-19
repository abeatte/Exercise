package com.artbeatte.exercises.algorithms.searching;

/**
 * @author art.beatte
 * @version 12/15/15
 */
public class BinarySearch {

    public BinarySearch() { /* no instances */ }

    // region search1
    /**
     * Day 1 impl
     * @param arr the array to search
     * @param target the target to search for
     * @return the index of the target in the array
     */
    public static int search1(int[] arr, int target) {
        if (arr == null) return -1;
        return search1(arr, target, 0, arr.length - 1);
    }

    private static int search1(int[] arr, int target, int bottomIndex, int topIndex) {
        if (bottomIndex > topIndex) return -1;
        int checkedIndex = (int) (bottomIndex + Math.ceil(((topIndex - bottomIndex)/2.0)));
        int comp = target - arr[checkedIndex];
        if (comp < 0) {
            return search1(arr, target, bottomIndex, checkedIndex - 1);
        } else if (comp > 0) {
            return search1(arr, target, checkedIndex + 1, topIndex);
        } else {
            return checkedIndex;
        }
    }
    // endregion

    //region search2
    /**
     * Day 2 impl
     * @param arr the array to search
     * @param target the target to search for
     * @return the index of the target in the array
     */
    public static int search2(int[] arr, int target) {
        for (int i = 0; i < arr.length; i ++) {
            if (arr[i] == target) return i;
        }

        return -1;
    }
    // endregion

    // region search3
    /**
     * Day 3 impl
     * @param arr the array to search
     * @param target the target to search for
     * @return the index of the target in the array
     */
    public static int search3(int[] arr, int target) {
        return -1;
    }
    // endregion

    // region search4
    /**
     * Day 4 impl
     * @param arr the array to search
     * @param target the target to search for
     * @return the index of the target in the array
     */
    public static int search4(int[] arr, int target) {
        return -1;
    }
    // endregion

    // region search5
    /**
     * Day 5 impl
     * @param arr the array to search
     * @param target the target to search for
     * @return the index of the target in the array
     */
    public static int search5(int[] arr, int target) {
        return -1;
    }
    // endregion

}
