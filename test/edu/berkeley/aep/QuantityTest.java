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

    @Test
    public void threeFeetShouldEqualOneYard() {
        var twelveInches = new Quantity(3, Unit.FEET);
        var oneFoot = new Quantity(1, Unit.YARD);
        assertEquals(twelveInches, oneFoot);
    }

    @Test
    public void oneThousandSevenHundredAndSixtyYardsShouldEqualOneMile() {
        var oneK760Yards = new Quantity(1760, Unit.YARD);
        var oneMile = new Quantity(1, Unit.MILE);
        assertEquals(oneK760Yards, oneMile);
    }

    @Test
    public void oneTbspShouldEqualThreeTsp() {
        var oneTbsp = new Quantity(1, Unit.TBSP);
        var threeTsp = new Quantity(3, Unit.TSP);
        assertEquals(oneTbsp, threeTsp);
    }

    @Test
    public void twoTbspShouldEqualOneOz() {
        var twoTbsp = new Quantity(2, Unit.TBSP);
        var oneOz = new Quantity(1, Unit.OZ);
        assertEquals(twoTbsp, oneOz);
    }

    @Test
    public void eightOzShouldEqualOneCup() {
        var twoTbsp = new Quantity(8, Unit.OZ);
        var oneOz = new Quantity(1, Unit.CUP);
        assertEquals(twoTbsp, oneOz);
    }

    @Test(expected = RuntimeException.class)
    public void shouldNotBeAbleToCompareTeaspoonsAndFeet() {
        var oneTbsp = new Quantity(1, Unit.TBSP);
        var threeFeet = new Quantity(3, Unit.FEET);
        assertEquals(oneTbsp, threeFeet);
    }

    @Test
    public void twoInchesPlusTwoInchesShouldEqualFourInches() {
        var twoInches = new Quantity(2, Unit.INCHES);
        assertEquals(new Quantity(4, Unit.INCHES), twoInches.add(twoInches));
    }

    @Test
    public void twoTablespoonsPlusOneOzShouldEqualTwelveTeaspoons() {
        var twoTbsp = new Quantity(2, Unit.TBSP);
        var oneOz = new Quantity(1, Unit.OZ);
        assertEquals(new Quantity(12, Unit.TSP), twoTbsp.add(oneOz));
    }

    @Test
    public void oneHundredCelsiusShouldEqual212F() {
        var oneHundredCelsius = new Quantity(100, Unit.CELSIUS);
        var twoHundredTwelveF = new Quantity(212, Unit.FAHRENHEIT);
        assertEquals(oneHundredCelsius, twoHundredTwelveF);
    }

    @Test
    public void thirtyTwoFahrenheitShouldEqualZeroCelsius() {
        var thirtyTwoFahrenheit = new Quantity(32, Unit.FAHRENHEIT);
        var zeroCelsius = new Quantity(0, Unit.CELSIUS);
        assertEquals(thirtyTwoFahrenheit, zeroCelsius);
    }

}
