package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {
    @Test
    public void rectangleWithSideOneShouldHaveAreaOne() {
        var rectangle = new Rectangle(1, 1);
        assertEquals(1, rectangle.area());
    }

    @Test
    public void rectangleWithSideTwoShouldHaveAreaFour() {
        var rectangle = new Rectangle(2, 2);
        assertEquals(4, rectangle.area());
    }

    @Test
    public void rectangleWithSideTwoShouldHavePerimeterEight() {
        var rectangle = new Rectangle(2, 2);
        assertEquals(8, rectangle.perimeter());
    }

    @Test
    public void rectangleWithSideOneShouldHavePerimeterFour() {
        var rectangle = new Rectangle(1, 1);
        assertEquals(4, rectangle.perimeter());
    }

    @Test
    public void squareOfSideThreeShouldHaveAreaNine() {
        var square = Rectangle.createSquare(3);
        assertEquals(9, square.area());
    }
}
