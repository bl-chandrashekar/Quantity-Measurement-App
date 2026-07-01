package com.bridgelabz.quantitymeasurementapp.common;

public enum LengthUnit {
    FEET(1.0),
    INCHES(1.0 / 12.0);

    private final double toFeetFactor;

    LengthUnit(double toFeetFactor) {
        this.toFeetFactor = toFeetFactor;
    }

    public double getToFeetFactor() {
        return toFeetFactor;
    }
}
