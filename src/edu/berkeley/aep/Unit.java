package edu.berkeley.aep;

// Understands how to convert between units
public enum Unit {

    INCHES(1, 0, UnitType.LENGTH, "Inches"),
    FEET(12, 0, UnitType.LENGTH, "Feet"),
    YARD(36, 0, UnitType.LENGTH, "Yard"),
    MILE(1760 * 36, 0, UnitType.LENGTH, "Mile"),
    TSP(1, 0, UnitType.VOLUME, "Tsp"),
    TBSP(3, 0, UnitType.VOLUME, "Tbsp"),
    OZ(6, 0, UnitType.VOLUME, "Tsp"),
    CUP(48, 0, UnitType.VOLUME, "Tsp"),
    CELSIUS(9, 0, UnitType.TEMPERATURE, "C"),
    FAHRENHEIT(5, -32, UnitType.TEMPERATURE, "F");

    private enum UnitType { LENGTH, VOLUME, TEMPERATURE; }

    private final int inBaseUnits;
    private final int offset;
    private final UnitType type;
    private final String name;

    Unit(int inBaseUnits, int offset, UnitType type, String name) {
        this.inBaseUnits = inBaseUnits;
        this.offset = offset;
        this.type = type;
        this.name = name;
    }

    int convertTo(Unit unit, int size) {
        if (unit.type != type)
            throw new IllegalArgumentException("Cannot compare " + type + " to " + unit.type);
        return (size + offset) * inBaseUnits / unit.inBaseUnits - unit.offset;
    }

    @Override
    public String toString() {
        return name;
    }
}
