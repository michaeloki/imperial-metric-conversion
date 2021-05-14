package com.michaeloki.conversion.model;

public class DistanceConversion {

    private final double distance;
    private final String initialUnit;
    private final String convertedUnit;

    public DistanceConversion(double distance, String initialUnit, String convertedUnit) {
        this.distance = distance;
        this.initialUnit = initialUnit;
        this.convertedUnit = convertedUnit;
    }

    public double getDistance() {
        return distance;
    }

    public String getInitialUnit() {
        return initialUnit;
    }

    public String getConvertedUnit() {
        return convertedUnit;
    }

}
