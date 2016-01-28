package com.artbeatte.exercises.games.othello;

/**
 * @author art.beatte
 * @version 1/27/16
 */
public interface Player {

    void takeTurn(Othello board);
    Color getColor();
}
