package com.artbeatte.exercises.games.othello;

/**
 * @author art.beatte
 * @version 1/27/16
 */
public class Move {

    private int mX;
    private int mY;
    private Player mPlayer;

    public Move(Player player, int x, int y) {
        mPlayer = player;
        mX = x;
        mY = y;
    }

    public int getX() {
        return mX;
    }

    public int getY() {
        return mY;
    }

    public Player getPlayer() {
        return mPlayer;
    }
}
