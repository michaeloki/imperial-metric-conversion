package com.michaeloki.conversion.model;

public class FluidConversion {

    private final double volume;
    private final String initialUnit;
    private final String convertedUnit;

    public FluidConversion(double volume, String initialUnit, String convertedUnit) {
        this.volume = volume;
        this.initialUnit = initialUnit;
        this.convertedUnit = convertedUnit;
    }

    public double getVolume() {
        return volume;
    }

    public String getInitialUnit() {
        return initialUnit;
    }

    public String getConvertedUnit() {
        return convertedUnit;
    }

}

