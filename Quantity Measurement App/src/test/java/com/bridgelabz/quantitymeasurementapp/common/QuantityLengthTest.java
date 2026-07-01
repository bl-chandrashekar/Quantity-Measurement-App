package com.bridgelabz.quantitymeasurementapp.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthTest {

    private static final double EPSILON = 1e-6;

    @Test
    void givenFeetToInches_whenConverted_thenReturnTwelve() {
        assertEquals(12.0, QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCHES), EPSILON);
    }

    @Test
    void givenInchesToFeet_whenConverted_thenReturnTwo() {
        assertEquals(2.0, QuantityLength.convert(24.0, LengthUnit.INCHES, LengthUnit.FEET), EPSILON);
    }

    @Test
    void givenYardsToInches_whenConverted_thenReturnThirtySix() {
        assertEquals(36.0, QuantityLength.convert(1.0, LengthUnit.YARDS, LengthUnit.INCHES), EPSILON);
    }

    @Test
    void givenInchesToYards_whenConverted_thenReturnTwo() {
        assertEquals(2.0, QuantityLength.convert(72.0, LengthUnit.INCHES, LengthUnit.YARDS), EPSILON);
    }

    @Test
    void givenCentimetersToInches_whenConverted_thenReturnApproximatelyOne() {
        assertEquals(1.0, QuantityLength.convert(2.54, LengthUnit.CENTIMETERS, LengthUnit.INCHES), 1e-4);
    }

    @Test
    void givenFeetToYards_whenConverted_thenReturnTwo() {
        assertEquals(2.0, QuantityLength.convert(6.0, LengthUnit.FEET, LengthUnit.YARDS), EPSILON);
    }

    @Test
    void givenRoundTripConversion_whenConvertedBack_thenPreserveValue() {
        double original = 7.5;
        double converted = QuantityLength.convert(original, LengthUnit.FEET, LengthUnit.INCHES);
        double roundTrip = QuantityLength.convert(converted, LengthUnit.INCHES, LengthUnit.FEET);
        assertEquals(original, roundTrip, EPSILON);
    }

    @Test
    void givenZeroValue_whenConverted_thenReturnZero() {
        assertEquals(0.0, QuantityLength.convert(0.0, LengthUnit.FEET, LengthUnit.INCHES), EPSILON);
    }

    @Test
    void givenNegativeValue_whenConverted_thenPreserveSign() {
        assertEquals(-12.0, QuantityLength.convert(-1.0, LengthUnit.FEET, LengthUnit.INCHES), EPSILON);
    }

    @Test
    void givenSameUnit_whenConverted_thenReturnSameValue() {
        assertEquals(5.0, QuantityLength.convert(5.0, LengthUnit.FEET, LengthUnit.FEET), EPSILON);
    }

    @Test
    void givenNaNValue_whenConverted_thenThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> QuantityLength.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCHES));
    }

    @Test
    void givenInfiniteValue_whenConverted_thenThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> QuantityLength.convert(Double.POSITIVE_INFINITY, LengthUnit.FEET, LengthUnit.INCHES));
    }

    @Test
    void givenNullSourceUnit_whenConverted_thenThrowException() {
        assertThrows(NullPointerException.class,
                () -> QuantityLength.convert(1.0, null, LengthUnit.INCHES));
    }

    @Test
    void givenNullTargetUnit_whenConverted_thenThrowException() {
        assertThrows(NullPointerException.class,
                () -> QuantityLength.convert(1.0, LengthUnit.FEET, null));
    }

    @Test
    void givenInstanceConversion_whenConverted_thenReturnNewQuantityWithTargetUnit() {
        QuantityLength source = new QuantityLength(3.0, LengthUnit.YARDS);
        QuantityLength converted = source.convertTo(LengthUnit.FEET);
        assertEquals(9.0, converted.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, converted.getUnit());
    }

    @Test
    void givenLengthEqualityAndComparisonHelpers_whenCalled_thenReturnExpectedResults() {
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(
                new QuantityLength(1.0, LengthUnit.FEET),
                new QuantityLength(12.0, LengthUnit.INCHES)));
        assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(1.0, LengthUnit.YARDS, 3.0, LengthUnit.FEET));
        assertEquals(12.0, QuantityMeasurementApp.demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES), EPSILON);
    }
}