package com.artbeatte.exercises.conwaysgameoflife;

import java.util.concurrent.TimeUnit;

/**
 * @author art.beatte
 * @version 12/11/15
 */
public class GameOfLife {

    private static final int BOARD_LENGTH   = 5;
    private static final int BOARD_WIDTH    = 5;
    private int[][] board;

    public GameOfLife() {
        board = new int[BOARD_LENGTH][BOARD_WIDTH];
        board[3][1] = 1;
        board[3][2] = 1;
        board[3][3] = 1;
    }

    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                updateScreen();
                while(running()) {
                    advanceBoard();
                    updateScreen();
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.exit(0);
            }
        }).start();
    }

    private boolean running() {
        return true;
    }

    private void advanceBoard() {
        int[][] newBoard = new int[BOARD_LENGTH][BOARD_WIDTH];
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j ++) {
                newBoard[i][j] = advanceCell(board, i, j);
            }
        }
        board = newBoard;
    }

    private int advanceCell(int[][] board, int i, int j) {
        int neighbors = 0;
        neighbors += getCell(board, i - 1, j - 1);
        neighbors += getCell(board, i - 1, j);
        neighbors += getCell(board, i - 1, j + 1);
        neighbors += getCell(board, i, j - 1);
        neighbors += getCell(board, i, j + 1);
        neighbors += getCell(board, i + 1, j - 1);
        neighbors += getCell(board, i + 1, j);
        neighbors += getCell(board, i + 1, j + 1);
        if (board[i][j] == 1) {
            return (neighbors >= 2 && neighbors <= 3) ? 1 : 0;
        } else {
            return neighbors == 3 ? 1 : 0;
        }
    }

    private int getCell(int[][] board, int i, int j) {
        if (i < 0 || i >= board.length) return 0;
        if (j < 0 || j >= board[i].length) return 0;
        return board[i][j];
    }

    private void updateScreen() {
        StringBuilder topBoarder = new StringBuilder();
        StringBuilder bottomBoarder = new StringBuilder();
        for (int[] ignored : board) {
            topBoarder.append("__");
            bottomBoarder.append("--");
        }
        System.out.println(" " + topBoarder.toString());
        for (int[] row : board) {
            StringBuilder printRow = new StringBuilder().append("|");
            for (int cell : row) {
                printRow.append(cell == 0 ? "  " : "x ");
            }
            printRow.append("|");
            System.out.println(printRow.toString());
        }
        System.out.println(" " + bottomBoarder.toString());

        System.out.println();
    }

    public static void main(String[] args) {
        GameOfLife game = new GameOfLife();
        game.start();
    }
}
