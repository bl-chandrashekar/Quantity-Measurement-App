package com.bridgelabz.quantitymeasurementapp.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthTest {

    @Test
    void givenFeetToFeetSameValue_whenCompared_thenReturnTrue() {
        QuantityLength first = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength second = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(first.equals(second));
    }

    @Test
    void givenInchToInchSameValue_whenCompared_thenReturnTrue() {
        QuantityLength first = new QuantityLength(1.0, LengthUnit.INCHES);
        QuantityLength second = new QuantityLength(1.0, LengthUnit.INCHES);
        assertTrue(first.equals(second));
    }

    @Test
    void givenFeetToFeetDifferentValue_whenCompared_thenReturnFalse() {
        QuantityLength first = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength second = new QuantityLength(2.0, LengthUnit.FEET);
        assertFalse(first.equals(second));
    }

    @Test
    void givenInchToInchDifferentValue_whenCompared_thenReturnFalse() {
        QuantityLength first = new QuantityLength(1.0, LengthUnit.INCHES);
        QuantityLength second = new QuantityLength(2.0, LengthUnit.INCHES);
        assertFalse(first.equals(second));
    }

    @Test
    void givenEquivalentFeetAndInches_whenCompared_thenReturnTrue() {
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength inches = new QuantityLength(12.0, LengthUnit.INCHES);
        assertTrue(feet.equals(inches));
    }

    @Test
    void givenEquivalentInchesAndFeet_whenCompared_thenReturnTrue() {
        QuantityLength inches = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(inches.equals(feet));
    }

    @Test
    void givenNullWhenCompared_thenReturnFalse() {
        QuantityLength quantity = new QuantityLength(1.0, LengthUnit.FEET);
        assertFalse(quantity.equals(null));
    }

    @Test
    void givenSameReference_whenCompared_thenReturnTrue() {
        QuantityLength quantity = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(quantity.equals(quantity));
    }

    @Test
    void givenNullUnit_whenConstructed_thenThrowException() {
        assertThrows(NullPointerException.class, () -> new QuantityLength(1.0, null));
    }

    @Test
    void givenCompareHelper_whenCalled_thenReturnExpectedResult() {
        assertTrue(QuantityMeasurementApp.compareLength(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES));
        assertTrue(QuantityMeasurementApp.compareLength(1.0, LengthUnit.INCHES, 1.0, LengthUnit.INCHES));
        assertFalse(QuantityMeasurementApp.compareLength(1.0, LengthUnit.FEET, 2.0, LengthUnit.FEET));
    }
}