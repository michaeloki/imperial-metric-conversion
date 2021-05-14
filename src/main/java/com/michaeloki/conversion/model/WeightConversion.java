package com.michaeloki.conversion.model;

public class WeightConversion {

    private final double weight;
    private final String initialUnit;
    private final String convertedUnit;

    public WeightConversion(double weight, String initialUnit, String convertedUnit) {
        this.weight = weight;
        this.initialUnit = initialUnit;
        this.convertedUnit = convertedUnit;
    }

    public double getWeight() {
        return weight;
    }

    public String getInitialUnit() {
        return initialUnit;
    }

    public String getConvertedUnit() {
        return convertedUnit;
    }

}
