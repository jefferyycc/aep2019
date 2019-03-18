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

    @Test
    public void oneShouldBeBestProbability() {
        var probabilityOne = new Chance(1);
        var probabilityHalf = new Chance(0.5);
        var probabilityQuarter = new Chance(0.25);

        var bester = new Bester(probabilityOne, probabilityHalf, probabilityQuarter);
        assertEquals(probabilityOne, bester.best());
    }
}
