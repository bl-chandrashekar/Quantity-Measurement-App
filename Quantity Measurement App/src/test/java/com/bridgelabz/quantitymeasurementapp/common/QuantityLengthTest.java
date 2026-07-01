package com.bridgelabz.quantitymeasurementapp.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthTest {

    private static final double EPSILON = 1e-6;

    @Test
    void givenSameUnitFeetPlusFeet_whenAdded_thenReturnThreeFeet() {
        QuantityLength result = new QuantityLength(1.0, LengthUnit.FEET).add(new QuantityLength(2.0, LengthUnit.FEET));
        assertEquals(3.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void givenSameUnitInchPlusInch_whenAdded_thenReturnTwelveInches() {
        QuantityLength result = new QuantityLength(6.0, LengthUnit.INCHES).add(new QuantityLength(6.0, LengthUnit.INCHES));
        assertEquals(12.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test
    void givenCrossUnitFeetPlusInches_whenAdded_thenReturnTwoFeet() {
        QuantityLength result = new QuantityLength(1.0, LengthUnit.FEET).add(new QuantityLength(12.0, LengthUnit.INCHES));
        assertEquals(2.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void givenCrossUnitInchesPlusFeet_whenAdded_thenReturnTwentyFourInches() {
        QuantityLength result = new QuantityLength(12.0, LengthUnit.INCHES).add(new QuantityLength(1.0, LengthUnit.FEET));
        assertEquals(24.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test
    void givenCrossUnitYardPlusFeet_whenAdded_thenReturnTwoYards() {
        QuantityLength result = new QuantityLength(1.0, LengthUnit.YARDS).add(new QuantityLength(3.0, LengthUnit.FEET));
        assertEquals(2.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.YARDS, result.getUnit());
    }

    @Test
    void givenCrossUnitCentimeterPlusInch_whenAdded_thenReturnApproximatelyFivePointZeroEightCentimeters() {
        QuantityLength result = new QuantityLength(2.54, LengthUnit.CENTIMETERS).add(new QuantityLength(1.0, LengthUnit.INCHES));
        assertEquals(5.08, result.getValue(), 1e-2);
        assertEquals(LengthUnit.CENTIMETERS, result.getUnit());
    }

    @Test
    void givenAdditionCommutativity_whenCompared_thenReturnSameResult() {
        QuantityLength first = new QuantityLength(1.0, LengthUnit.FEET).add(new QuantityLength(12.0, LengthUnit.INCHES));
        QuantityLength second = new QuantityLength(12.0, LengthUnit.INCHES).add(new QuantityLength(1.0, LengthUnit.FEET));
        assertEquals(first.getValue(), second.getValue(), EPSILON);
        assertEquals(first.getUnit(), LengthUnit.FEET);
        assertEquals(second.getUnit(), LengthUnit.INCHES);
    }

    @Test
    void givenZero_whenAdded_thenReturnSameValue() {
        QuantityLength result = new QuantityLength(5.0, LengthUnit.FEET).add(new QuantityLength(0.0, LengthUnit.INCHES));
        assertEquals(5.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void givenNegativeValues_whenAdded_thenReturnCorrectSum() {
        QuantityLength result = new QuantityLength(5.0, LengthUnit.FEET).add(new QuantityLength(-2.0, LengthUnit.FEET));
        assertEquals(3.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void givenNullSecondOperand_whenAdded_thenThrowException() {
        assertThrows(NullPointerException.class, () -> new QuantityLength(1.0, LengthUnit.FEET).add(null));
    }

    @Test
    void givenLargeValues_whenAdded_thenReturnExpectedSum() {
        QuantityLength result = new QuantityLength(1e6, LengthUnit.FEET).add(new QuantityLength(1e6, LengthUnit.FEET));
        assertEquals(2e6, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void givenSmallValues_whenAdded_thenReturnExpectedSum() {
        QuantityLength result = new QuantityLength(0.001, LengthUnit.FEET).add(new QuantityLength(0.002, LengthUnit.FEET));
        assertEquals(0.003, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void givenStaticAddition_whenCalled_thenReturnExpectedResult() {
        QuantityLength result = QuantityLength.add(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES, LengthUnit.FEET);
        assertEquals(2.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void givenInstanceOperands_whenAdded_thenOriginalObjectsRemainUnchanged() {
        QuantityLength first = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength second = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength result = first.add(second);
        assertEquals(1.0, first.getValue(), EPSILON);
        assertEquals(12.0, second.getValue(), EPSILON);
        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    void givenConversionAndAdditionHelpers_whenCalled_thenReturnExpectedResults() {
        assertEquals(12.0, QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCHES), EPSILON);
        assertEquals(2.0, QuantityMeasurementApp.demonstrateLengthAddition(new QuantityLength(1.0, LengthUnit.FEET), new QuantityLength(12.0, LengthUnit.INCHES)).getValue(), EPSILON);
        assertEquals(2.0, QuantityMeasurementApp.demonstrateLengthAddition(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES, LengthUnit.FEET).getValue(), EPSILON);
    }
}