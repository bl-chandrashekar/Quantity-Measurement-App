package com.bridgelabz.quantitymeasurementapp.common;

import java.util.Objects;

public final class QuantityLength {
    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("value must be a finite number");
        }
        this.value = value;
        this.unit = Objects.requireNonNull(unit, "unit must not be null");
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    public QuantityLength convertTo(LengthUnit targetUnit) {
        Objects.requireNonNull(targetUnit, "targetUnit must not be null");
        return new QuantityLength(convert(value, unit, targetUnit), targetUnit);
    }

    public static double convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("value must be a finite number");
        }
        Objects.requireNonNull(sourceUnit, "sourceUnit must not be null");
        Objects.requireNonNull(targetUnit, "targetUnit must not be null");
        double feetValue = value * sourceUnit.getToFeetFactor();
        return feetValue / targetUnit.getToFeetFactor();
    }

    private double toFeet() {
        return value * unit.getToFeetFactor();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        QuantityLength other = (QuantityLength) obj;
        return Double.compare(this.toFeet(), other.toFeet()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(toFeet());
    }

    @Override
    public String toString() {
        return "QuantityLength{" + "value=" + value + ", unit=" + unit + '}';
    }
}