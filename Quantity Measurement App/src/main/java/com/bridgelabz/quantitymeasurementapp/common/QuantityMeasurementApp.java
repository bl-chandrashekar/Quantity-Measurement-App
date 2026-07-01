package com.bridgelabz.quantitymeasurementapp.common;


public class QuantityMeasurementApp {

    public static void main(String[] args) {
        System.out.println("Input: Quantity(1.0, \"feet\") and Quantity(12.0, \"inches\")");
        System.out.println("Output: Equal (" + compareLength(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES) + ")");

        System.out.println("Input: Quantity(1.0, \"inch\") and Quantity(1.0, \"inch\")");
        System.out.println("Output: Equal (" + compareLength(1.0, LengthUnit.INCHES, 1.0, LengthUnit.INCHES) + ")");
    }

    public static boolean compareLength(double firstValue, LengthUnit firstUnit, double secondValue, LengthUnit secondUnit) {
        QuantityLength first = new QuantityLength(firstValue, firstUnit);
        QuantityLength second = new QuantityLength(secondValue, secondUnit);
        return first.equals(second);
    }
}