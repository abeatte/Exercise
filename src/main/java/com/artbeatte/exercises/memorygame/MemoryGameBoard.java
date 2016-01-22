package com.artbeatte.exercises.memorygame;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by csarbora on 1/22/16.
 */
public final class MemoryGameBoard {
    private final int mWidth;
    private final int mHeight;
    private final ArrayList<Card> mCards;
    private int mFlips;
    private boolean mMatched;
    private int mFlippedIndex;
    private int mCardsLeft;

    public MemoryGameBoard(int width, int height) {
        mWidth = width;
        mHeight = height;
        mCardsLeft = width * height;

        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("both x and y must be positive non-zero");
        }
        if (mCardsLeft % 2 != 0) {
            throw new IllegalArgumentException("one of either width or height must be even");
        }

        mCards = new ArrayList<>(mCardsLeft);

        for (int i = 0; i < mCardsLeft; i += 2) {
            mCards.add(new Card(i));
            mCards.add(new Card(i));
        }
        Collections.shuffle(mCards);

        mFlippedIndex = -1;
    }

    public Card flipCard(int x, int y) {
        if (x < 0 || x >= mWidth || y < 0 || y >= mHeight) {
            throw new IndexOutOfBoundsException(String.format("tried to access (%d,%d) on board of size (%d,%d)",
                    x, y, mWidth, mHeight));
        }

        int attemptIndex = y * mWidth + x;
        Card c = mCards.get(attemptIndex);
        if (c != null) {
            mMatched = false;
            mFlips++;

            if (mFlippedIndex >= 0) {
                if (c.equals(mCards.get(mFlippedIndex))) {
                    mMatched = true;
                    mCards.set(mFlippedIndex, null);
                    mCards.set(attemptIndex, null);
                    mCardsLeft -= 2;
                } else {
                    mFlippedIndex = -1;
                }
            }
        }

        return c;
    }

    public int getTotalFlips() {
        return mFlips;
    }

    public boolean didMatch() {
        return mMatched;
    }

    public boolean isGameOver() {
        return mCardsLeft <= 0; // < just for sanity
    }
}
