package com.bridgelabz.quantitymeasurementapp.common;

import com.bridgelabz.quantitymeasurementapp.weight.QuantityWeight;
import com.bridgelabz.quantitymeasurementapp.weight.WeightUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementTest {
    private static final double EPSILON = 1e-6;

    @Test
    void testEquality_KilogramToKilogram_SameValue()
    {
        assertTrue(new QuantityWeight(1.0, WeightUnit.KILOGRAM).equals(new QuantityWeight(1.0, WeightUnit.KILOGRAM)));
    }
    @Test
    void testEquality_KilogramToKilogram_DifferentValue() {
        assertFalse(new QuantityWeight(1.0, WeightUnit.KILOGRAM).equals(new QuantityWeight(2.0, WeightUnit.KILOGRAM)));
    }
    @Test
    void testEquality_KilogramToGram_EquivalentValue() {
        assertTrue(new QuantityWeight(1.0, WeightUnit.KILOGRAM).equals(new QuantityWeight(1000.0, WeightUnit.GRAM)));
    }
    @Test
    void testEquality_GramToKilogram_EquivalentValue() {
        assertTrue(new QuantityWeight(1000.0, WeightUnit.GRAM).equals(new QuantityWeight(1.0, WeightUnit.KILOGRAM)));
    }
    @Test
    void testEquality_WeightVsLength_Incompatible() {
        assertFalse(new QuantityWeight(1.0, WeightUnit.KILOGRAM).equals(new QuantityLength(1.0, LengthUnit.FEET)));
    }
    @Test
    void testEquality_NullComparison() {
        assertFalse(new QuantityWeight(1.0, WeightUnit.KILOGRAM).equals(null));
    }
    @Test
    void testEquality_SameReference() {
        QuantityWeight q = new QuantityWeight(1.0, WeightUnit.KILOGRAM); assertTrue(q.equals(q));
    }
    @Test
    void testEquality_NullUnit() {
        assertThrows(NullPointerException.class, () -> new QuantityWeight(1.0, null));
    }
    @Test
    void testConversion_KilogramToPound() {
        assertEquals(2.2046244202, QuantityWeight.convert(1.0, WeightUnit.KILOGRAM, WeightUnit.POUND), 1e-5);
    }
    @Test
    void testConversion_PoundToKilogram() {
        assertEquals(1.0, QuantityWeight.convert(2.20462, WeightUnit.POUND, WeightUnit.KILOGRAM), 1e-5);
    }
    @Test
    void testConversion_RoundTrip() {
        double v = 1.5;
        double g = QuantityWeight.convert(v, WeightUnit.KILOGRAM, WeightUnit.GRAM);
        assertEquals(v, QuantityWeight.convert(g, WeightUnit.GRAM, WeightUnit.KILOGRAM), EPSILON);
    }
    @Test
    void testAddition_SameUnit_KilogramPlusKilogram() {
        QuantityWeight r = new QuantityWeight(1.0, WeightUnit.KILOGRAM).add(new QuantityWeight(2.0, WeightUnit.KILOGRAM));
        assertEquals(3.0, r.getValue(), EPSILON); assertEquals(WeightUnit.KILOGRAM, r.getUnit());
    }
    @Test
    void testAddition_CrossUnit_KilogramPlusGram() {
        QuantityWeight r = new QuantityWeight(1.0, WeightUnit.KILOGRAM).add(new QuantityWeight(1000.0, WeightUnit.GRAM));
        assertEquals(2.0, r.getValue(), EPSILON); assertEquals(WeightUnit.KILOGRAM, r.getUnit());
    }
    @Test
    void testAddition_CrossUnit_PoundPlusKilogram() {
        QuantityWeight r = new QuantityWeight(2.20462, WeightUnit.POUND).add(new QuantityWeight(1.0, WeightUnit.KILOGRAM));
        assertEquals(4.40924, r.getValue(), 1e-4); assertEquals(WeightUnit.POUND, r.getUnit());
    }
    @Test
    void testAddition_ExplicitTargetUnit_Kilogram() {
        QuantityWeight r = QuantityWeight.add(new QuantityWeight(1.0, WeightUnit.KILOGRAM), new QuantityWeight(1000.0, WeightUnit.GRAM), WeightUnit.GRAM);
        assertEquals(2000.0, r.getValue(), EPSILON); assertEquals(WeightUnit.GRAM, r.getUnit());
    }
    @Test
    void testAddition_Commutativity() {
        QuantityWeight a = QuantityWeight.add(new QuantityWeight(1.0, WeightUnit.KILOGRAM), new QuantityWeight(1000.0, WeightUnit.GRAM), WeightUnit.KILOGRAM);
        QuantityWeight b = QuantityWeight.add(new QuantityWeight(1000.0, WeightUnit.GRAM), new QuantityWeight(1.0, WeightUnit.KILOGRAM), WeightUnit.KILOGRAM);
        assertEquals(a.getValue(), b.getValue(), EPSILON);
    }
    @Test
    void testAddition_WithZero() {
        QuantityWeight r = new QuantityWeight(5.0, WeightUnit.KILOGRAM).add(new QuantityWeight(0.0, WeightUnit.GRAM));
        assertEquals(5.0, r.getValue(), EPSILON);
    }
    @Test
    void testAddition_NegativeValues() {
        QuantityWeight r = new QuantityWeight(5.0, WeightUnit.KILOGRAM).add(new QuantityWeight(-2000.0, WeightUnit.GRAM));
        assertEquals(3.0, r.getValue(), EPSILON);
    }
    @Test
    void testAddition_LargeValues() {
        QuantityWeight r = new QuantityWeight(1e6, WeightUnit.KILOGRAM).add(new QuantityWeight(1e6, WeightUnit.KILOGRAM));
        assertEquals(2e6, r.getValue(), EPSILON);
    }
}