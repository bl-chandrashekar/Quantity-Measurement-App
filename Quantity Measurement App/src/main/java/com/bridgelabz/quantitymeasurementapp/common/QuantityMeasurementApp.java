package com.bridgelabz.quantitymeasurementapp.common;


public class QuantityMeasurementApp {

    public static void main(String[] args) {
        demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES);
        demonstrateLengthConversion(3.0, LengthUnit.YARDS, LengthUnit.FEET);
        demonstrateLengthConversion(36.0, LengthUnit.INCHES, LengthUnit.YARDS);
        demonstrateLengthConversion(1.0, LengthUnit.CENTIMETERS, LengthUnit.INCHES);
        demonstrateLengthConversion(0.0, LengthUnit.FEET, LengthUnit.INCHES);

        demonstrateLengthEquality(new QuantityLength(1.0, LengthUnit.FEET), new QuantityLength(12.0, LengthUnit.INCHES));
        demonstrateLengthComparison(1.0, LengthUnit.YARDS, 3.0, LengthUnit.FEET);
    }

    public static double demonstrateLengthConversion(double value, LengthUnit sourceUnit, LengthUnit targetUnit) {
        double convertedValue = QuantityLength.convert(value, sourceUnit, targetUnit);
        System.out.println("Input: convert(" + value + ", " + sourceUnit + ", " + targetUnit + ") -> Output: " + convertedValue);
        return convertedValue;
    }

    public static double demonstrateLengthConversion(QuantityLength quantityLength, LengthUnit targetUnit) {
        QuantityLength converted = quantityLength.convertTo(targetUnit);
        System.out.println("Input: convert(" + quantityLength + ", " + targetUnit + ") -> Output: " + converted.getValue());
        return converted.getValue();
    }

    public static boolean demonstrateLengthEquality(QuantityLength first, QuantityLength second) {
        boolean result = first.equals(second);
        System.out.println("Equality: " + result);
        return result;
    }

    public static boolean demonstrateLengthComparison(double firstValue, LengthUnit firstUnit, double secondValue, LengthUnit secondUnit) {
        return demonstrateLengthEquality(new QuantityLength(firstValue, firstUnit), new QuantityLength(secondValue, secondUnit));
    }
}