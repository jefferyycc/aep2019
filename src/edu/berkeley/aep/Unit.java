package edu.berkeley.aep;

public enum Unit {
    INCHES(1), FEET(12);

    private final int inBaseUnits;

    Unit(int inBaseUnits) {
        this.inBaseUnits = inBaseUnits;
    }

    public int inBaseUnits(int size) {
        return size * inBaseUnits;
    }
}
