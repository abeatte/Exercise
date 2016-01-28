package com.artbeatte.exercises.games.othello;

import java.util.LinkedList;
import java.util.List;

/**
 * @author art.beatte
 * @version 1/27/16
 */
public class Othello {

    private static final int INITIAL_SETUP_SIZE = 4;

    public static void main(String[] args) {
        new Othello();
    }

    private Player mWhite;
    private Player mBlack;
    private int mWidth;
    private int mHeight;
    private Color[] mBoard;
    private List<Move> mMoves;
    private Player mCurrentTurn;

    public Othello() {
        mWhite = new OthelloPlayer(Color.White);
        mBlack = new OthelloPlayer(Color.Black);
        initBoard(8, 8);
        mMoves = new LinkedList<>();
        mCurrentTurn = mWhite;

        intro();

        updateBoard();
        while (!isGameOver()) {
            if (hasValidMove(mCurrentTurn)) {
                mCurrentTurn.takeTurn(this);
            } else {
                System.out.println(String.format("%s has no valid moves.", mCurrentTurn.getColor().toString()));
                advanceTurn();
            }
            updateBoard();
        }

        gameOver();
    }

    /**
     * Initializes the Othello board to official game play standards
     * @param width the width of the board
     * @param height the height of the board
     */
    private void initBoard(int width, int height) {
        mWidth = width;
        mHeight = height;
        mBoard = new Color[width * height];

        mBoard[3 * mWidth + 3] = Color.White;
        mBoard[4 * mWidth + 3] = Color.Black;
        mBoard[4  * mWidth + 4] = Color.White;
        mBoard[3 * mWidth + 4] = Color.Black;
    }

    public boolean placePiece(int x, int y, Player player) {
        if (mCurrentTurn != player) {
            throw new IllegalArgumentException(String.format("%s attempted to place a piece when it is %s's turn",
                    player.getColor().toString(), player.getColor().toString()));
        }

        boolean isValid = isValidMove(x, y, player.getColor());
        if (isValid) {
            placePieceAndUpdate(x, y, player.getColor());
            mMoves.add(new Move(player, x, y));
            advanceTurn();
        }

        return isValid;
    }

    private void placePieceAndUpdate(int x, int y, Color color) {
        mBoard[y * mWidth + x] = color;
        scanBoard(x, y - 1, Direction.North, color, true);
        scanBoard(x + 1, y - 1, Direction.NorthEast, color, true);
        scanBoard(x + 1, y, Direction.East, color, true);
        scanBoard(x + 1, y + 1, Direction.SouthEast, color, true);
        scanBoard(x, y + 1, Direction.South, color, true);
        scanBoard(x - 1, y + 1, Direction.SouthWest, color, true);
        scanBoard(x - 1, y, Direction.West, color, true);
        scanBoard(x - 1, y - 1, Direction.NorthWest, color, true);
    }

    /**
     * Checks if the player has a valid move.
     * A player can only make a move if there is an open space to place a piece that 'sandwiches' one or more of the
     * opponent's piece's between another of their pieces.
     * @param player the player to check
     * @return true if the player has a valid move; otherwise false;
     */
    private boolean hasValidMove(Player player) {
        for (int i = 0; i < mHeight; i++) {
            for (int j = 0; j < mWidth; j++) {
                if (isValidMove(j, i, player.getColor())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Determines if the proposed move is a valid and legal one
     * @param x the x coordinate
     * @param y the y coordinate
     * @param color the color of the player attempting the move
     * @return true if the move is valid and legal.
     */
    private boolean isValidMove(int x, int y, Color color) {
        return mBoard[getBoardIndex(x, y)] == null &&
                (scanBoard(x, y - 1, Direction.North, color, false) ||
                scanBoard(x + 1, y - 1, Direction.NorthEast, color, false) ||
                scanBoard(x + 1, y, Direction.East, color, false) ||
                scanBoard(x +1, y + 1, Direction.SouthEast, color, false) ||
                scanBoard(x, y + 1, Direction.South, color, false) ||
                scanBoard(x - 1, y + 1, Direction.SouthWest, color, false) ||
                scanBoard(x - 1, y, Direction.West, color, false) ||
                scanBoard(x - 1, y - 1, Direction.NorthWest, color, false));
    }

    /**
     * Determines if the proposed move is a valid and legal one
     * @param x the x coordinate
     * @param y the y coordinate
     * @param d the direction to check the move for validity in
     * @param color the color of the player attempting the move
     * @param update true to change all opponent pieces found in the path to the provided {@link Color}
     * @return true if the move is valid and legal.
     */
    private boolean scanBoard(int x, int y, Direction d, Color color, boolean update) { 
        if (x < 1 || x >= mWidth || y < 1 || y >= mHeight || mBoard[getBoardIndex(x, y)] == null) {
            return false;
        }
        boolean valid = false;
        switch (d) {
            case North:
                valid = mBoard[getBoardIndex(x, y)] != color && (mBoard[getBoardIndex(x, y - 1)] == color) || scanBoard(x, y - 1, d, color, update);
                if (update && valid) {
                    mBoard[getBoardIndex(x, y)] = color;
                }
                break;
            case NorthEast:
                valid = mBoard[getBoardIndex(x, y)] != color && (mBoard[getBoardIndex(x + 1, y - 1)] == color) || scanBoard(x + 1, y - 1, d, color, update);
                if (update && valid) {
                    mBoard[getBoardIndex(x, y)] = color;
                }
                break;
            case East:
                valid = mBoard[getBoardIndex(x, y)] != color && (mBoard[getBoardIndex(x + 1, y)] == color) || scanBoard(x + 1, y, d, color, update);
                if (update && valid) {
                    mBoard[getBoardIndex(x, y)] = color;
                }
                break;
            case SouthEast:
                valid = mBoard[getBoardIndex(x, y)] != color && (mBoard[getBoardIndex(x + 1, y + 1)] == color) || scanBoard(x + 1, y + 1, d, color, update);
                if (update && valid) {
                    mBoard[getBoardIndex(x, y)] = color;
                }
                break;
            case South:
                valid = mBoard[getBoardIndex(x, y)] != color && (mBoard[getBoardIndex(x, y + 1)] == color) || scanBoard(x, y + 1, d, color, update);
                if (update && valid) {
                    mBoard[getBoardIndex(x, y)] = color;
                }
                break;
            case SouthWest:
                valid = mBoard[getBoardIndex(x, y)] != color && (mBoard[getBoardIndex(x - 1, y + 1)] == color) || scanBoard(x - 1, y + 1, d, color, update);
                if (update && valid) {
                    mBoard[getBoardIndex(x, y)] = color;
                }
                break;
            case West:
                valid = mBoard[getBoardIndex(x, y)] != color && (mBoard[getBoardIndex(x - 1, y)] == color) || scanBoard(x - 1, y, d, color, update);
                if (update && valid) {
                    mBoard[getBoardIndex(x, y)] = color;
                }
                break;
            case NorthWest:
                valid = mBoard[getBoardIndex(x, y)] != color && (mBoard[getBoardIndex(x - 1, y - 1)] == color) || scanBoard(x - 1, y - 1, d, color, update);
                if (update && valid) {
                    mBoard[getBoardIndex(x, y)] = color;
                }
                break;
        }
        return valid;
    }

    private void intro() {
        System.out.println("====================================");
        System.out.println("Welcome to Othello (console edition)");
        System.out.println("        By Art Beatte IV            ");
        System.out.println("       http://artbeatte.com         ");
        System.out.println("====================================");
    }

    private void updateBoard() {
        System.out.println("  _______________________________");
        for (int y = 0; y < mHeight; y++) {
            System.out.println(" |   |   |   |   |   |   |   |   |");
            System.out.print(((char)('A' + y)) + "|");
            for (int x = 0; x < mWidth; x++) {
                if (x != 0)  System.out.print("|");
                if (mBoard[y * mWidth + x] == Color.Black) {
                    System.out.print(" X ");
                } else if (mBoard[y * mWidth + x] == Color.White) {
                    System.out.print(" O ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println("|");
            System.out.println(" |___|___|___|___|___|___|___|___|");
        }
        System.out.println("   1   2   3   4   5   6   7   8  ");
    }

    /**
     * Swaps the current player
     */
    private void advanceTurn() {
        mCurrentTurn = mCurrentTurn == mWhite ? mBlack : mWhite;
    }

    private boolean isGameOver() {
        return (mMoves.size() + INITIAL_SETUP_SIZE) >= (mWidth * mHeight);
    }

    private void gameOver() {
        // TODO: game is over; display stats
        System.out.println("===============================================");
        System.out.println("Thank you for playing Othello (console edition)");
        System.out.println("              By Art Beatte IV                 ");
        System.out.println("             http://artbeatte.com              ");
        System.out.println("===============================================");
    }

    private int getBoardIndex(int x, int y) {
        return y * mWidth + x;
    }
}
