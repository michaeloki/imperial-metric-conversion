package com.michaeloki.conversion;

import com.michaeloki.conversion.controller.ConversionController;
import com.michaeloki.conversion.model.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(ConversionController.class)
public class ConversionControllerIntegrationTest {

    @Test
    public void checkServerStatus() {
        ServerStatus serverStatus = new ConversionController().status();
        assertThat(serverStatus.getStatus()).isEqualTo("Server is running");
    }

    @Test
    public void TemperatureConversion() {
        TemperatureConversion tempConversion = new ConversionController().convertTemperature(100.0, "metric", "imperial");
        Assert.assertEquals(tempConversion.getUnitType(), "imperial");
    }

    @Test
    public void WeightConversion() {
        WeightConversion weightConversion = new ConversionController().convertWeight(100.0, "kilogram", "pound");
        Assert.assertEquals(weightConversion.getInitialUnit(), "kilogram");
    }

    @Test
    public void DistanceConversion() {
        DistanceConversion distanceConversion = new ConversionController().convertDistance(10.0, "meter", "mile");
        Assert.assertEquals(distanceConversion.getConvertedUnit(), "mile");
    }

    @Test
    public void FluidConversion() {
        FluidConversion fluidConversion = new ConversionController().convertVolume(50.0, "liter", "gallon");
        Assert.assertEquals(fluidConversion.getInitialUnit(), "liter");
    }

    @Test
    public void AreaConversion() {
        AreaConversion areaConversion = new ConversionController().convertArea(25.0, "hectare", "acre");
        Assert.assertEquals(areaConversion.getConvertedUnit(), "acre");
    }

}