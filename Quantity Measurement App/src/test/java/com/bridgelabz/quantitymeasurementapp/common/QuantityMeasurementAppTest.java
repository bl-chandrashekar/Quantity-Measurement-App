package com.bridgelabz.quantitymeasurementapp.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthTest {

    @Test
    void givenYardToYardSameValue_whenCompared_thenReturnTrue() {
        assertTrue(new QuantityLength(1.0, LengthUnit.YARDS).equals(new QuantityLength(1.0, LengthUnit.YARDS)));
    }

    @Test
    void givenYardToYardDifferentValue_whenCompared_thenReturnFalse() {
        assertFalse(new QuantityLength(1.0, LengthUnit.YARDS).equals(new QuantityLength(2.0, LengthUnit.YARDS)));
    }

    @Test
    void givenYardToFeetEquivalentValue_whenCompared_thenReturnTrue() {
        assertTrue(new QuantityLength(1.0, LengthUnit.YARDS).equals(new QuantityLength(3.0, LengthUnit.FEET)));
    }

    @Test
    void givenFeetToYardEquivalentValue_whenCompared_thenReturnTrue() {
        assertTrue(new QuantityLength(3.0, LengthUnit.FEET).equals(new QuantityLength(1.0, LengthUnit.YARDS)));
    }

    @Test
    void givenYardToInchesEquivalentValue_whenCompared_thenReturnTrue() {
        assertTrue(new QuantityLength(1.0, LengthUnit.YARDS).equals(new QuantityLength(36.0, LengthUnit.INCHES)));
    }

    @Test
    void givenInchesToYardEquivalentValue_whenCompared_thenReturnTrue() {
        assertTrue(new QuantityLength(36.0, LengthUnit.INCHES).equals(new QuantityLength(1.0, LengthUnit.YARDS)));
    }

    @Test
    void givenYardToFeetNonEquivalentValue_whenCompared_thenReturnFalse() {
        assertFalse(new QuantityLength(1.0, LengthUnit.YARDS).equals(new QuantityLength(2.0, LengthUnit.FEET)));
    }

    @Test
    void givenCentimetersToInchesEquivalentValue_whenCompared_thenReturnTrue() {
        assertTrue(new QuantityLength(1.0, LengthUnit.CENTIMETERS).equals(new QuantityLength(0.393701, LengthUnit.INCHES)));
    }

    @Test
    void givenCentimetersToFeetNonEquivalentValue_whenCompared_thenReturnFalse() {
        assertFalse(new QuantityLength(1.0, LengthUnit.CENTIMETERS).equals(new QuantityLength(1.0, LengthUnit.FEET)));
    }

    @Test
    void givenMultiUnitTransitiveScenario_whenCompared_thenReturnTrue() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength b = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength c = new QuantityLength(36.0, LengthUnit.INCHES);
        assertTrue(a.equals(b));
        assertTrue(b.equals(c));
        assertTrue(a.equals(c));
    }

    @Test
    void givenNullUnit_whenConstructed_thenThrowException() {
        assertThrows(NullPointerException.class, () -> new QuantityLength(1.0, null));
    }

    @Test
    void givenSameReference_whenCompared_thenReturnTrue() {
        QuantityLength quantity = new QuantityLength(2.0, LengthUnit.YARDS);
        assertTrue(quantity.equals(quantity));
    }

    @Test
    void givenNullComparison_whenCompared_thenReturnFalse() {
        assertFalse(new QuantityLength(2.0, LengthUnit.YARDS).equals(null));
    }

    @Test
    void givenHelper_whenCalled_thenReturnExpectedResult() {
        assertTrue(QuantityMeasurementApp.compareLength(1.0, LengthUnit.YARDS, 3.0, LengthUnit.FEET));
        assertTrue(QuantityMeasurementApp.compareLength(1.0, LengthUnit.YARDS, 36.0, LengthUnit.INCHES));
        assertTrue(QuantityMeasurementApp.compareLength(2.0, LengthUnit.CENTIMETERS, 2.0, LengthUnit.CENTIMETERS));
        assertFalse(QuantityMeasurementApp.compareLength(1.0, LengthUnit.CENTIMETERS, 1.0, LengthUnit.FEET));
    }
}