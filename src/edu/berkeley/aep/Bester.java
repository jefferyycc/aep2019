package edu.berkeley.aep;

// Understands how to compare quantities to find the best
public class Bester {

    private final Bestable[] quantities;

    public Bester(Bestable... quantities) {
        this.quantities = quantities;
    }

    public Bestable best() {
        var champion = quantities[0];
        for (Bestable quantity : quantities) {
            if (quantity.betterThan(champion)) {
                champion = quantity;
            }
        }
        return champion;
    }
}
