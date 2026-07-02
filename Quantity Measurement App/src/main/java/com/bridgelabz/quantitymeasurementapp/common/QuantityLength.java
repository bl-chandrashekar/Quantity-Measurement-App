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
        double baseValue = unit.convertToBaseUnit(value);
        return new QuantityLength(targetUnit.convertFromBaseUnit(baseValue), targetUnit);
    }

    public QuantityLength add(QuantityLength other) {
        Objects.requireNonNull(other, "other must not be null");
        return add(other, this.unit);
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
        double sumInBaseUnit = first.unit.convertToBaseUnit(first.value) + second.unit.convertToBaseUnit(second.value);
        double resultValue = targetUnit.convertFromBaseUnit(sumInBaseUnit);
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
        return targetUnit.convertFromBaseUnit(sourceUnit.convertToBaseUnit(value));
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
        return Double.compare(this.unit.convertToBaseUnit(this.value), other.unit.convertToBaseUnit(other.value)) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit.convertToBaseUnit(value));
    }

    @Override
    public String toString() {
        return "QuantityLength{" + "value=" + value + ", unit=" + unit + '}';
    }
}