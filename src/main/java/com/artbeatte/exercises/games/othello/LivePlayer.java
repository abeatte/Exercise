package com.artbeatte.exercises.games.othello;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author art.beatte
 * @version 1/27/16
 */
public class LivePlayer implements Player {

    private static final Set<String> COMMANDS = new HashSet<>(Arrays.asList(new String[] { "HELP", "SUGGEST", "SUGGESTION", "QUIT" }));

    private Color mColor;
    private boolean isTurn;

    public LivePlayer(Color color) {
        mColor = color;
    }

    @Override
    public void takeTurn(Othello board) {
        Scanner scan = new Scanner(System.in);
        isTurn = true;
        while (isTurn) {
            System.out.print(String.format("%s move: ", mColor.toString()));
            String input = scan.next().toUpperCase();
            if (COMMANDS.contains(input)) {
                handleCommand(input, board);
            } else {
                char[] position = input.toCharArray();
                if (position.length != 2 || position[0] < 'A' || position[0] > ('A' + 7) || position[1] < '1' || position[1] > ('8')) {
                    System.out.println("\nPlease enter your move on the board in the format 'B5'.");
                } else {
                    int y = position[0] - 'A';
                    int x = position[1] - '1';
                    if (!board.placePiece(x, y, this)) {
                        System.out.println("That is not a valid move. Try again.");
                    } else {
                        isTurn = false;
                    }
                }
            }
        }
    }

    private void handleCommand(String cmd, Othello board) {
        switch (cmd) {
            case "SUGGEST":
            case "SUGGESTION":
                Point p = board.findValidMove(this);
                String suggestion = Character.toString((char) (p.y + 'A')) + String.valueOf(p.x + 1);
                System.out.println(suggestion);
                break;
            case "QUIT":
                isTurn = false;
                board.quit();
                break;
            case "HELP":
            default:
                printHelpMenu();
                break;
        }
    }

    private void printHelpMenu() {
        System.out.println("List of commands:");
        System.out.println("SUGGEST / SUGGESTION : suggests a move");
        System.out.println("QUIT : quits the game");
        System.out.println("HELP : displays the help menu");
    }

    @Override
    public Color getColor() {
        return mColor;
    }
}
