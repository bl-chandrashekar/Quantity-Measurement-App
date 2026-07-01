package com.bridgelabz.quantitymeasurementapp.common;

import java.util.Objects;

/**
 * Entry point and domain container for quantity measurement use cases.
 *
 * <p>UC-01 currently supports equality comparison for measurements in feet.
 */
public class QuantityMeasurementApp {

    public static void main(String[] args) {
        Feet firstMeasurement = new Feet(1.0);
        Feet secondMeasurement = new Feet(1.0);

        boolean isEqual = firstMeasurement.equals(secondMeasurement);

        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + isEqual + ")");
    }

    /**
     * Immutable value object representing a measurement in feet.
     */
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
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return "Feet{" +
                    "value=" + value +
                    '}';
        }
    }
}
