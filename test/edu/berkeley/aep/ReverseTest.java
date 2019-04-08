package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseTest {

    @Test
    public void singleLetterReversedShouldReturnItself() {
        assertEquals("a", Reverser.reverse("a"));
    }

    @Test
    public void abcdeReversedShouldEqualedcba() {
        assertEquals("edcba", Reverser.reverse("abcde"));
    }
}
