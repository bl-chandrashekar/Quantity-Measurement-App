package com.bridgelabz.quantitymeasurementapp.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void givenSameFeetValues_whenCompared_thenReturnTrue() {
        QuantityMeasurementApp.Feet first = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet second = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(first.equals(second), "Expected equal feet values to be equal.");
    }

    @Test
    void givenDifferentFeetValues_whenCompared_thenReturnFalse() {
        QuantityMeasurementApp.Feet first = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet second = new QuantityMeasurementApp.Feet(2.0);

        assertFalse(first.equals(second), "Expected different feet values to be not equal.");
    }

    @Test
    void givenNullWhenComparedToFeet_thenReturnFalse() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);

        assertFalse(feet.equals(null), "Expected feet comparison with null to be false.");
    }

    @Test
    void givenNonFeetObjectWhenComparedToFeet_thenReturnFalse() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);

        assertFalse(feet.equals("1.0"), "Expected feet comparison with another type to be false.");
    }

    @Test
    void givenSameFeetReference_whenCompared_thenReturnTrue() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(feet.equals(feet), "Expected same feet reference comparison to be true.");
    }

    @Test
    void givenEqualFeetObjects_whenHashCodesCompared_thenReturnSameHashCode() {
        QuantityMeasurementApp.Feet first = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet second = new QuantityMeasurementApp.Feet(1.0);

        assertEquals(first.hashCode(), second.hashCode(), "Expected equal feet objects to have same hash code.");
    }

    @Test
    void givenSameInchesValues_whenCompared_thenReturnTrue() {
        QuantityMeasurementApp.Inches first = new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches second = new QuantityMeasurementApp.Inches(1.0);

        assertTrue(first.equals(second), "Expected equal inches values to be equal.");
    }

    @Test
    void givenDifferentInchesValues_whenCompared_thenReturnFalse() {
        QuantityMeasurementApp.Inches first = new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches second = new QuantityMeasurementApp.Inches(2.0);

        assertFalse(first.equals(second), "Expected different inches values to be not equal.");
    }

    @Test
    void givenNullWhenComparedToInches_thenReturnFalse() {
        QuantityMeasurementApp.Inches inches = new QuantityMeasurementApp.Inches(1.0);

        assertFalse(inches.equals(null), "Expected inches comparison with null to be false.");
    }

    @Test
    void givenNonInchesObjectWhenComparedToInches_thenReturnFalse() {
        QuantityMeasurementApp.Inches inches = new QuantityMeasurementApp.Inches(1.0);

        assertFalse(inches.equals("1.0"), "Expected inches comparison with another type to be false.");
    }

    @Test
    void givenSameInchesReference_whenCompared_thenReturnTrue() {
        QuantityMeasurementApp.Inches inches = new QuantityMeasurementApp.Inches(1.0);

        assertTrue(inches.equals(inches), "Expected same inches reference comparison to be true.");
    }

    @Test
    void givenEqualInchesObjects_whenHashCodesCompared_thenReturnSameHashCode() {
        QuantityMeasurementApp.Inches first = new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches second = new QuantityMeasurementApp.Inches(1.0);

        assertEquals(first.hashCode(), second.hashCode(), "Expected equal inches objects to have same hash code.");
    }

    @Test
    void givenFeetComparisonHelpers_whenCalled_thenReturnExpectedResult() {
        assertTrue(QuantityMeasurementApp.compareFeetEquality(1.0, 1.0));
        assertFalse(QuantityMeasurementApp.compareFeetEquality(1.0, 2.0));
    }

    @Test
    void givenInchesComparisonHelpers_whenCalled_thenReturnExpectedResult() {
        assertTrue(QuantityMeasurementApp.compareInchesEquality(1.0, 1.0));
        assertFalse(QuantityMeasurementApp.compareInchesEquality(1.0, 2.0));
    }
}