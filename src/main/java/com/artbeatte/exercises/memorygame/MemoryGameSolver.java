package com.artbeatte.exercises.memorygame;

import java.util.HashMap;
import java.util.Map;

/**
 * @author art.beatte
 * @version 1/22/16
 */
public class MemoryGameSolver implements Solver {

    private class CardIndex{
        int width, height;

        public CardIndex(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }

    Map<Card, CardIndex> mFound;
    int mTurn;

    public MemoryGameSolver() {
        mFound = new HashMap<>();
        mTurn = 0;
    }

    @Override
    public void solve(MemoryGameBoard board) {

        for (int w = 0; w < board.getWidth(); w++) {
            for (int h = 0; h < board.getHeight(); h++) {
                Card c = board.flipCard(w, h);
                mTurn++;
                CardIndex pair = mFound.get(c);
                mFound.put(c, new CardIndex(w, h));
                if (pair != null) {
                    if (mTurn % 2 == 0) { // 2st card turnover
                        board.flipCard(w, h);
                        mTurn++;
                    }
                    board.flipCard(pair.width, pair.height);
                    mTurn++;
                    mFound.remove(c);
                }
            }
        }
    }
}
