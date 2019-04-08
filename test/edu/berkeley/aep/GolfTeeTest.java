package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GolfTeeTest {
    @Test
    public void shouldGroupSinglePartyIntoOneTeeGroup() {
        var grouper = new GolfTee(new Integer[] { 4 });
        assertEquals(1, grouper.groups());
    }

    @Test
    public void shouldGroupMultiplePartyIntoThreeTeeGroups() {
        var grouper = new GolfTee(new Integer[] { 2, 1, 4, 1, 3 });
        assertEquals(3, grouper.groups());
    }

}
