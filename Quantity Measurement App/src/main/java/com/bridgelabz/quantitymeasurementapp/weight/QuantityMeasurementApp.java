package com.bridgelabz.quantitymeasurementapp.weight;

import com.bridgelabz.quantitymeasurementapp.common.LengthUnit;
import com.bridgelabz.quantitymeasurementapp.common.QuantityLength;

public class QuantityMeasurementApp {
    public static void main(String[] args) {
        System.out.println(new QuantityWeight(1.0, WeightUnit.KILOGRAM).equals(new QuantityWeight(1000.0, WeightUnit.GRAM)));
        System.out.println(new QuantityWeight(1.0, WeightUnit.KILOGRAM).convertTo(WeightUnit.GRAM));
        System.out.println(new QuantityWeight(1.0, WeightUnit.KILOGRAM).add(new QuantityWeight(1000.0, WeightUnit.GRAM)));
        System.out.println(new QuantityWeight(1.0, WeightUnit.KILOGRAM).add(new QuantityWeight(1000.0, WeightUnit.GRAM), WeightUnit.GRAM));
        System.out.println(new QuantityLength(1.0, LengthUnit.FEET).equals(new QuantityLength(12.0, LengthUnit.INCHES)));
    }
}