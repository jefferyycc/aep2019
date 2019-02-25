package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuantityTest {

    @Test
    public void twelveInchesShouldEqualOneFoot() {
        var twelveInches = new Quantity(12, Unit.INCHES);
        var oneFoot = new Quantity(1, Unit.FEET);
        assertEquals(twelveInches, oneFoot);
    }
}
