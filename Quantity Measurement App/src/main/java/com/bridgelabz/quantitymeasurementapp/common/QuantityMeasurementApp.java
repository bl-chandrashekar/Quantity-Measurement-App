package com.bridgelabz.quantitymeasurementapp.common;


public class QuantityMeasurementApp {

    public static void main(String[] args) {
        printResult(1.0, LengthUnit.YARDS, 3.0, LengthUnit.FEET);
        printResult(1.0, LengthUnit.YARDS, 36.0, LengthUnit.INCHES);
        printResult(2.0, LengthUnit.YARDS, 2.0, LengthUnit.YARDS);
        printResult(2.0, LengthUnit.CENTIMETERS, 2.0, LengthUnit.CENTIMETERS);
        printResult(1.0, LengthUnit.CENTIMETERS, 0.393701, LengthUnit.INCHES);
    }

    public static boolean compareLength(double firstValue, LengthUnit firstUnit, double secondValue, LengthUnit secondUnit) {
        QuantityLength first = new QuantityLength(firstValue, firstUnit);
        QuantityLength second = new QuantityLength(secondValue, secondUnit);
        return first.equals(second);
    }

    private static void printResult(double firstValue, LengthUnit firstUnit, double secondValue, LengthUnit secondUnit) {
        System.out.println("Input: Quantity(" + firstValue + ", " + firstUnit + ") and Quantity(" + secondValue + ", " + secondUnit + ")");
        System.out.println("Output: Equal (" + compareLength(firstValue, firstUnit, secondValue, secondUnit) + ")");
    }
}