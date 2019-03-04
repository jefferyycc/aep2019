package edu.berkeley.aep;

// Understands an amount in a given unit
public class Quantity {
    private final int size;
    private final Unit unit;

    public Quantity(int size, Unit unit) {
        this.size = size;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Quantity)) return false;
        return equals((Quantity) other);
    }

    public boolean equals(Quantity other) {
        return this.size == other.convertTo(unit);
    }

    private int convertTo(Unit toUnits) {
        return unit.convertTo(toUnits, size);
    }

    @Override
    public String toString() {
        return size + " " + unit;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(size);
    }

    public Quantity add(Quantity other) {
        return new Quantity(size + other.convertTo(unit), unit);
    }
}
