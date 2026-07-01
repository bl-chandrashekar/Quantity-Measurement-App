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
        if (targetUnit == null) {
            throw new IllegalArgumentException("targetUnit must not be null");
        }
        return new QuantityLength(convert(value, unit, targetUnit), targetUnit);
    }

    public QuantityLength add(QuantityLength other) {
        Objects.requireNonNull(other, "other must not be null");
        return add(this, other, this.unit);
    }

    public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("targetUnit must not be null");
        }
        Objects.requireNonNull(other, "other must not be null");
        return add(this, other, targetUnit);
    }

    public static QuantityLength add(QuantityLength first, QuantityLength second, LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("targetUnit must not be null");
        }
        Objects.requireNonNull(first, "first must not be null");
        Objects.requireNonNull(second, "second must not be null");
        double sumInFeet = first.toFeet() + second.toFeet();
        double resultValue = sumInFeet / targetUnit.getToFeetFactor();
        return new QuantityLength(resultValue, targetUnit);
    }

    public static QuantityLength add(double firstValue, LengthUnit firstUnit, double secondValue, LengthUnit secondUnit, LengthUnit targetUnit) {
        return add(new QuantityLength(firstValue, firstUnit), new QuantityLength(secondValue, secondUnit), targetUnit);
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