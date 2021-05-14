package com.michaeloki.conversion.controller;

import com.michaeloki.conversion.model.*;
import org.junit.Assert;
import org.junit.Test;

public class ConversionControllerTest {
    ConversionController conversionController = new ConversionController();

    @Test
    public void testStatus() throws Exception {
        ServerStatus result = conversionController.status();
        Assert.assertEquals(result.getStatus(), "Server is running");
    }

    @Test
    public void testConvertTemperature() throws Exception {
        TemperatureConversion result = conversionController.convertTemperature((double) 10, "metric", "imperial");
        Assert.assertNotNull(result.getTemperature());
    }

    @Test
    public void testConvertDistance() throws Exception {
        DistanceConversion result = conversionController.convertDistance((double) 10, "initialUnit", "convertedUnit");
        Assert.assertSame("initialUnit", result.getInitialUnit());
    }

    @Test
    public void testConvertWeight() throws Exception {
        WeightConversion result = conversionController.convertWeight(10.0, "initialUnit", "convertedUnit");
        Assert.assertSame("convertedUnit", result.getConvertedUnit());
    }

    @Test
    public void testConvertVolume() throws Exception {
        FluidConversion result = conversionController.convertVolume((double) 10, "initialUnit", "convertedUnit");
        Assert.assertNotSame(result.getVolume(), 10);
    }

    @Test
    public void testConvertArea() throws Exception {
        AreaConversion result = conversionController.convertArea((double) 5, "initialUnit", "convertedUnit");
        Assert.assertNotSame(result.getArea(), 1.0);
    }

}
