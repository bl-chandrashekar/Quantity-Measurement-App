package com.bridgelabz.quantitymeasurementapp.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void givenSameFeetValues_whenCompared_thenShouldReturnTrue() {
        QuantityMeasurementApp.Feet first = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet second = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(first.equals(second), "Expected equal feet measurements to return true.");
    }

    @Test
    void givenDifferentFeetValues_whenCompared_thenShouldReturnFalse() {
        QuantityMeasurementApp.Feet first = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet second = new QuantityMeasurementApp.Feet(2.0);

        assertFalse(first.equals(second), "Expected different feet measurements to return false.");
    }

    @Test
    void givenFeetMeasurement_whenComparedWithNull_thenShouldReturnFalse() {
        QuantityMeasurementApp.Feet measurement = new QuantityMeasurementApp.Feet(1.0);

        assertFalse(measurement.equals(null), "Expected comparison with null to return false.");
    }

    @Test
    void givenFeetMeasurement_whenComparedWithNonFeetType_thenShouldReturnFalse() {
        QuantityMeasurementApp.Feet measurement = new QuantityMeasurementApp.Feet(1.0);

        assertFalse(measurement.equals("non-numeric input"),
                "Expected comparison with a different type to return false.");
    }

    @Test
    void givenFeetMeasurement_whenComparedWithItself_thenShouldReturnTrue() {
        QuantityMeasurementApp.Feet measurement = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(measurement.equals(measurement), "Expected same reference comparison to return true.");
    }

    @Test
    void givenEqualFeetMeasurements_whenHashCodeCompared_thenShouldBeSame() {
        QuantityMeasurementApp.Feet first = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet second = new QuantityMeasurementApp.Feet(1.0);

        assertEquals(first.hashCode(), second.hashCode(),
                "Expected equal objects to produce the same hash code.");
    }

    @Test
    void givenFeetMeasurements_whenEqualsChecked_thenShouldBeSymmetric() {
        QuantityMeasurementApp.Feet first = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet second = new QuantityMeasurementApp.Feet(1.0);

        assertEquals(first.equals(second), second.equals(first),
                "Expected equals to be symmetric.");
    }

    @Test
    void givenThreeEqualFeetMeasurements_whenCompared_thenShouldBeTransitive() {
        QuantityMeasurementApp.Feet first = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet second = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet third = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(first.equals(second) && second.equals(third) && first.equals(third),
                "Expected equals to be transitive.");
    }

    @Test
    void givenSameFeetMeasurements_whenComparedMultipleTimes_thenShouldBeConsistent() {
        QuantityMeasurementApp.Feet first = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet second = new QuantityMeasurementApp.Feet(1.0);

        boolean firstComparison = first.equals(second);
        boolean secondComparison = first.equals(second);

        assertEquals(firstComparison, secondComparison, "Expected equals to be consistent across invocations.");
    }
}