package edu.berkeley.aep;

// Understands an amount in a ratio scale in a given unit
public class ArithmeticQuantity extends ScaledQuantity {

    public ArithmeticQuantity(int size, Unit unit) {
        super(size, unit);
    }

    public ArithmeticQuantity add(ArithmeticQuantity other) {
        return new ArithmeticQuantity(size + other.convertTo(unit), unit);
    }
}
