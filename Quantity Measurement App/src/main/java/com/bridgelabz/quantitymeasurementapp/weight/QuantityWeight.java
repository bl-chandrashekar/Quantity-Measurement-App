package com.bridgelabz.quantitymeasurementapp.weight;

import java.util.Objects;

public final class QuantityWeight {
    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("value must be a finite number");
        }
        this.value = value;
        this.unit = Objects.requireNonNull(unit, "unit must not be null");
    }

    public double getValue() { return value; }
    public WeightUnit getUnit() { return unit; }

    public QuantityWeight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("targetUnit must not be null");
        return new QuantityWeight(targetUnit.convertFromBaseUnit(unit.convertToBaseUnit(value)), targetUnit);
    }

    public QuantityWeight add(QuantityWeight other) {
        Objects.requireNonNull(other, "other must not be null");
        return add(this, other, this.unit);
    }

    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("targetUnit must not be null");
        Objects.requireNonNull(other, "other must not be null");
        return add(this, other, targetUnit);
    }

    public static QuantityWeight add(QuantityWeight first, QuantityWeight second, WeightUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("targetUnit must not be null");
        Objects.requireNonNull(first, "first must not be null");
        Objects.requireNonNull(second, "second must not be null");
        double sum = first.unit.convertToBaseUnit(first.value) + second.unit.convertToBaseUnit(second.value);
        return new QuantityWeight(targetUnit.convertFromBaseUnit(sum), targetUnit);
    }

    public static double convert(double value, WeightUnit sourceUnit, WeightUnit targetUnit) {
        if (!Double.isFinite(value)) throw new IllegalArgumentException("value must be a finite number");
        Objects.requireNonNull(sourceUnit, "sourceUnit must not be null");
        Objects.requireNonNull(targetUnit, "targetUnit must not be null");
        return targetUnit.convertFromBaseUnit(sourceUnit.convertToBaseUnit(value));
    }

    @Override public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuantityWeight other = (QuantityWeight) obj;
        return Double.compare(unit.convertToBaseUnit(value), other.unit.convertToBaseUnit(other.value)) == 0;
    }

    @Override public int hashCode() { return Objects.hash(unit.convertToBaseUnit(value)); }

    @Override public String toString() { return "QuantityWeight{" + "value=" + value + ", unit=" + unit + '}'; }
}