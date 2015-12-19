package com.artbeatte.exercises.sudoku;

import java.util.HashMap;

/**
 * @author art.beatte
 * @version 10/9/15
 */
@SuppressWarnings("SpellCheckingInspection")
public class Sudoku {

    @SuppressWarnings("unused")
    public static boolean isValid(int[][] board) {
        // check board size
        if (board.length != 9) return false;
        for (int i = 0; i < 9; i++) {
            int[] row = board[i];
            if (row.length != 9) return false;
            // check rows
            if (!isGroupValid(row)) return false;
            // check columns
            int[] col = new int[9];
            for (int j = 0; j < 9; j++) {
                col[j] = board[j][i];
                // check squares
                if (i % 3 == 0 && j % 3 == 0 && !isGroupValid(getSquare(board, i, j))) return false;
            }
            if (!isGroupValid(col)) return false;
        }

        return true;
    }

    private static int[] getSquare(int[][] grid, int baseRow, int baseCol) {
        int index = 0;
        int[] square = new int[9];
        for (int row = baseRow; row < (baseRow + 3); ++row)
        {
            for (int col = baseCol; col < (baseCol + 3); ++col)
            {
                square[index++] = grid[row][col];
            }
        }
        return square;
    }

    private static boolean isGroupValid(int[] row) {
        HashMap<Integer, Integer> buckets = new HashMap<>();
        for (int k : row) {
            Integer valid = buckets.put(k, k);
            if (valid != null && valid > 0) return false;
        }
        return true;
    }
}
