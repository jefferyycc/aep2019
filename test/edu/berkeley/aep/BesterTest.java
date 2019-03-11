package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BesterTest {
    @Test
    public void oneYardShouldBeBest() {
        var oneYard = new ArithmeticQuantity(1, Unit.YARD);
        var twoInches = new ArithmeticQuantity(2, Unit.INCHES);
        var twoFeet = new ArithmeticQuantity(2, Unit.FEET);
        var bester = new Bester(oneYard, twoInches, twoFeet);
        assertEquals(oneYard, bester.best());
    }
}
