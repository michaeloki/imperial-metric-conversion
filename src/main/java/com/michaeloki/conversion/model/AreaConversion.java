package com.michaeloki.conversion.model;

public class AreaConversion {

    private final double area;
    private final String initialUnit;
    private final String convertedUnit;

    public AreaConversion(double area, String initialUnit, String convertedUnit) {
        this.area = area;
        this.initialUnit = initialUnit;
        this.convertedUnit = convertedUnit;
    }

    public double getArea() {
        return area;
    }

    public String getInitialUnit() {
        return initialUnit;
    }

    public String getConvertedUnit() {
        return convertedUnit;
    }

}

