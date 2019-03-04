package edu.berkeley.aep;

import java.util.HashMap;
import java.util.Map;

// Understands a four-sided figure with four right angles
public class Rectangle {

    public final int length;
    public final int width;

    public static Rectangle createSquare(int side) {
        return new Rectangle(side, side);
    }

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    protected int area() {
        return length * width;
    }

    public int perimeter() {
        return 2 * length + 2 * width;
    }
}
