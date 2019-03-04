package edu.berkeley.aep;

public enum Unit {

    INCHES(1, UnitType.LENGTH, "Inches"),
    FEET(12, UnitType.LENGTH, "Feet"),
    YARD(36, UnitType.LENGTH, "Yard"),
    MILE(1760 * 36, UnitType.LENGTH, "Mile"),
    TSP(1, UnitType.VOLUME, "Tsp"),
    TBSP(3, UnitType.VOLUME, "Tbsp"),
    OZ(6, UnitType.VOLUME, "Tsp"),
    CUP(48, UnitType.VOLUME, "Tsp");

    private enum UnitType { LENGTH, VOLUME; }

    private final int inBaseUnits;
    private final UnitType type;
    private final String name;

    Unit(int inBaseUnits, UnitType type, String name) {
        this.inBaseUnits = inBaseUnits;
        this.type = type;
        this.name = name;
    }

    int convertTo(Unit unit, int size) throws Exception {
        if (unit.type != type)
            throw new Exception("Cannot compare " + type + " to " + unit.type);
        return size * inBaseUnits / unit.inBaseUnits;
    }

    @Override
    public String toString() {
        return name;
    }
}
