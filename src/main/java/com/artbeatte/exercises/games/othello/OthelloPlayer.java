package com.artbeatte.exercises.games.othello;

import java.util.Scanner;

/**
 * @author art.beatte
 * @version 1/27/16
 */
public class OthelloPlayer implements Player {

    private Color mColor;

    public OthelloPlayer(Color color) {
        mColor = color;
    }

    @Override
    public void takeTurn(Othello board) {
        Scanner scan = new Scanner(System.in);
        char[] input = null;
        while (input == null) {
            System.out.print(String.format("%s move: ", mColor.toString()));
            input = scan.next().toUpperCase().toCharArray();
            if (input.length != 2 || input[0] < 'A' || input[0] > ('A' + 7) || input[1] < '1' || input[1] > ('8')) {
                System.out.println("\nPlease enter your move on the board in the format 'B5'.");
                input = null;
            } else {
                int y = input[0] - 'A';
                int x = input[1] - '1';
                if (!board.placePiece(x, y, this)) {
                    System.out.println("That is not a valid move. Try again.");
                    input = null;
                }
            }
        }
    }

    @Override
    public Color getColor() {
        return mColor;
    }
}
