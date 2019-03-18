package edu.berkeley.aep;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ChanceTest {
    @Test
    public void shouldUnderstandThatTheProbabilityOfADieThrowIsNotEqualToTheProbabilityOfACoinToss() {
        var dieThrow = new Chance(1/6);
        var coinToss = new Chance(0.5);
        assertEquals(coinToss, coinToss);
        assertFalse(dieThrow.equals(coinToss));
        assertEquals(coinToss, new Chance(0.5));
    }

    @Test
    public void notShouldProduceTheComplementForADieThrow() {
        var dieThrow = new Chance(1d/6d);
        assertEquals(new Chance(5d/6d), dieThrow.not());
    }

    @Test
    public void probabilityOfTwoHeadsShouldBeOneQuarter() {
        var coinToss = new Chance(0.5);
        assertEquals(new Chance(0.25), coinToss.and(coinToss));
    }

    @Test
    public void probabilityOfHeadsForEitherOfTwoCoinsShouldBeThreeQuarters() {
        var coinToss = new Chance(0.5);
        assertEquals(new Chance(0.75), coinToss.or(coinToss));
    }

}
