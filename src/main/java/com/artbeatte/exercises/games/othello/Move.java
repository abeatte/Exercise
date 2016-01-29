package com.artbeatte.exercises.games.othello;

import java.util.Date;

/**
 * @author art.beatte
 * @version 1/27/16
 */
public class Move {

    private int mX;
    private int mY;
    private Player mPlayer;
    private long mTimeStamp;

    public Move(Player player, int x, int y, Date dateTime) {
        mPlayer = player;
        mX = x;
        mY = y;
        mTimeStamp = dateTime.getTime();
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

    public long getTimeStamp() {
        return mTimeStamp;
    }
}
