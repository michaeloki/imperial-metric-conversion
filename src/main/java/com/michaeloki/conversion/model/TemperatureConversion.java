package com.michaeloki.conversion.model;

public class TemperatureConversion {

    private final double temperature;
    private final String unitType;
    private final String unit;

    public TemperatureConversion(double temperature, String unitType, String unit) {
        this.temperature = temperature;
        this.unitType = unitType;
        this.unit = unit;
    }

    public Double getTemperature() {
        return temperature;
    }

    public String getUnitType() {
        return unitType;
    }

    public String getUnit() {
        return unit;
    }
}
