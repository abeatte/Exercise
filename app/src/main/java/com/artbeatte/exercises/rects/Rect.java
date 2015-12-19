package com.artbeatte.exercises.rects;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author sarbs
 * @version 11/16/15
 */
public class Rect {
    private final double x;
    private final double y;
    private final double width;
    private final double height;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    /**
     * Creates a Rect object.
     * @param x The x-coordinate of the upper left corner.
     * @param y The y-coordinate of the upper left corner.
     * @param width The width of the rectangle. Must be >0.
     * @param height The height of the rectangle. Must be >0.
     */
    public Rect(double x, double y, double width, double height) {
        throw new NotImplementedException();
    }

    /**
     * Calculates the intersection (overlapping area) of two rectangles.
     *
     * @param a A rectangle
     * @param b Another rectangle
     * @return A new Rect object holding the overlapping area of the two given rectangles,
     *         OR null if the two rectangles do not intersect.
     * @throws IllegalArgumentException if either parameter is null.
     */
    public static Rect intersection(Rect a, Rect b)  {
        throw new NotImplementedException();
    }
}
