package com.bridgelabz.quantitymeasurementapp.common;

import java.util.Objects;

public class QuantityMeasurementApp {

    public static void main(String[] args) {
        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + compareFeetEquality(1.0, 1.0) + ")");

        System.out.println("Input: 1.0 inch and 1.0 inch");
        System.out.println("Output: Equal (" + compareInchesEquality(1.0, 1.0) + ")");
    }

    public static boolean compareFeetEquality(double firstValue, double secondValue) {
        Feet first = new Feet(firstValue);
        Feet second = new Feet(secondValue);
        return first.equals(second);
    }

    public static boolean compareInchesEquality(double firstValue, double secondValue) {
        Inches first = new Inches(firstValue);
        Inches second = new Inches(secondValue);
        return first.equals(second);
    }

    public static final class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Feet other = (Feet) obj;
            return Double.compare(value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return "Feet{" + "value=" + value + '}';
        }
    }

    public static final class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Inches other = (Inches) obj;
            return Double.compare(value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return "Inches{" + "value=" + value + '}';
        }
    }
}