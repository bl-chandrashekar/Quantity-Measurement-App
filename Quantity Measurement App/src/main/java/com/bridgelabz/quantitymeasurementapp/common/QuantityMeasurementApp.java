package com.bridgelabz.quantitymeasurementapp.common;

public class QuantityMeasurementApp {

    public static void main(String[] args) {
        demonstrateLengthAddition(new QuantityLength(1.0, LengthUnit.FEET), new QuantityLength(12.0, LengthUnit.INCHES), LengthUnit.FEET);
        demonstrateLengthAddition(new QuantityLength(1.0, LengthUnit.FEET), new QuantityLength(12.0, LengthUnit.INCHES), LengthUnit.INCHES);
        demonstrateLengthAddition(new QuantityLength(1.0, LengthUnit.FEET), new QuantityLength(12.0, LengthUnit.INCHES), LengthUnit.YARDS);
        demonstrateLengthAddition(new QuantityLength(1.0, LengthUnit.YARDS), new QuantityLength(3.0, LengthUnit.FEET), LengthUnit.YARDS);
        demonstrateLengthAddition(new QuantityLength(36.0, LengthUnit.INCHES), new QuantityLength(1.0, LengthUnit.YARDS), LengthUnit.FEET);
        demonstrateLengthAddition(new QuantityLength(2.54, LengthUnit.CENTIMETERS), new QuantityLength(1.0, LengthUnit.INCHES), LengthUnit.CENTIMETERS);
        demonstrateLengthAddition(new QuantityLength(5.0, LengthUnit.FEET), new QuantityLength(0.0, LengthUnit.INCHES), LengthUnit.YARDS);
        demonstrateLengthAddition(new QuantityLength(5.0, LengthUnit.FEET), new QuantityLength(-2.0, LengthUnit.FEET), LengthUnit.INCHES);
    }

    public static QuantityLength demonstrateLengthAddition(QuantityLength first, QuantityLength second, LengthUnit targetUnit) {
        QuantityLength result = QuantityLength.add(first, second, targetUnit);
        System.out.println("Input: add(" + first + ", " + second + ", " + targetUnit + ")");
        System.out.println("Output: " + result);
        return result;
    }

    public static QuantityLength demonstrateLengthAddition(double firstValue, LengthUnit firstUnit, double secondValue, LengthUnit secondUnit, LengthUnit targetUnit) {
        QuantityLength result = QuantityLength.add(firstValue, firstUnit, secondValue, secondUnit, targetUnit);
        System.out.println("Input: add(" + firstValue + ", " + firstUnit + ", " + secondValue + ", " + secondUnit + ", " + targetUnit + ")");
        System.out.println("Output: " + result);
        return result;
    }
}