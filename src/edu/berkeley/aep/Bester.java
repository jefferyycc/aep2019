package edu.berkeley.aep;

// Understands how to compare quantities to find the best
public class Bester {

    private final ScaledQuantity[] quantities;

    public Bester(ScaledQuantity... quantities) {
        this.quantities = quantities;
    }

    public ScaledQuantity best() {
        var champion = quantities[0];
        for (ScaledQuantity quantity : quantities) {
            if (quantity.betterThan(champion)) {
                champion = quantity;
            }
        }
        return champion;
    }
}
