package com.michaeloki.conversion.controller;

import com.michaeloki.conversion.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversionController {

    private static final String status = "Server is running";
    private static String unit = "";
    private static String message = "";

    @GetMapping("/status")
    public ServerStatus status() {
        return new ServerStatus(status);
    }

    @GetMapping("/convertTemperature")
    public TemperatureConversion convertTemperature(@RequestParam(value = "temperature", defaultValue = "0.0") Double temperature,
                                              @RequestParam(value = "initialUnitType", defaultValue = "metric") String initialUnitType,
                                              @RequestParam(value = "convertedUnitType", defaultValue = "imperial") String convertedUnitType) {

        if(temperature ==0.0) {
            message = "Temperature, initialUnitType and convertedUnitType parameters are required";
            throw new ConversionNotFoundException(message);
        }
        if(initialUnitType.equals("imperial") && convertedUnitType.equals("metric")  ) {
            temperature = (temperature - 32 )/1.8;
            unit = "celsius";
        }
        if(initialUnitType.equals("metric") && convertedUnitType.equals("imperial")) {
            temperature = 1.8*temperature + 32;
            unit = "Fahrenheit";
        }
        return new TemperatureConversion(temperature, convertedUnitType, unit);
    }

    @GetMapping("/convertDistance")
    public DistanceConversion convertDistance(@RequestParam(value = "distance", defaultValue = "0.0") Double distance,
                                              @RequestParam(value = "initialUnit", defaultValue = "kilometer") String initialUnit,
                                              @RequestParam(value = "convertedUnit", defaultValue = "mile") String convertedUnit) {

        if(distance == 0.0) {
            message = "Distance, initialUnit and convertedUnit parameters are required";
            throw new ConversionNotFoundException(message);
        }
        if(initialUnit.equals("kilometer") && convertedUnit.equals("mile")) {
            distance = distance/1.6093;
        }
        if(initialUnit.equals("mile") && convertedUnit.equals("kilometer")) {
            distance = distance*1.6093;
        }
        if(initialUnit.equals("yard") && convertedUnit.equals("meter")) {
            distance = distance*0.9144;
        }
        if(initialUnit.equals("meter") && convertedUnit.equals("yard")) {
            distance = distance/0.9144;
        }
        if(initialUnit.equals("inch") && convertedUnit.equals("centimeter")) {
            distance = distance*2.54;
        }
        if(initialUnit.equals("centimeter") && convertedUnit.equals("inch")) {
            distance = distance/2.54;
        }
        if(initialUnit.equals("foot") && convertedUnit.equals("meter")) {
            distance = distance*0.3048;
        }
        if(initialUnit.equals("meter") && convertedUnit.equals("foot")) {
            distance = distance/0.3048;
        }
        return new DistanceConversion(distance, initialUnit, convertedUnit);
    }

    @GetMapping("/convertWeight")
    public WeightConversion convertWeight(@RequestParam(value = "mass", defaultValue = "0.0") Double mass,
                                          @RequestParam(value = "initialUnit", defaultValue = "pound") String initialUnit,
                                          @RequestParam(value = "convertedUnit", defaultValue = "kilogram") String convertedUnit) {

        if(mass ==0.0) {
            message = "Mass,initialUnit and convertedUnit parameters are required";
            throw new ConversionNotFoundException(message);
        }
        if(initialUnit.equals("kilogram") && convertedUnit.equals("pound")) {
                mass = mass * 2.2046;
        }
        if(initialUnit.equals("pound") && convertedUnit.equals("kilogram")) {
            mass = mass/2.2046;
        }
        if(initialUnit.equals("ounce") &&  convertedUnit.equals("gram")) {
            mass = mass*28.35;
        }
        if (initialUnit.equals("gram") && convertedUnit.equals("ounce")) {
            mass = mass / 28.35;
        }
        return new WeightConversion(mass, initialUnit, convertedUnit);
    }

    @GetMapping("/convertFluidVolume")
    public FluidConversion convertVolume(@RequestParam(value = "volume", defaultValue = "0.0") Double volume,
                                         @RequestParam(value = "initialUnit", defaultValue = "liter") String initialUnit,
                                         @RequestParam(value = "convertedUnit", defaultValue = "pint") String convertedUnit) {

        if(volume ==0.0) {
            message = "Volume, initialUnit and convertedUnit parameters are required";
            throw new ConversionNotFoundException(message);
        }
        if(initialUnit.equals("pint") && convertedUnit.equals("liter")  ) {
            volume = volume*1.7598;
        }
        if(initialUnit.equals("liter") && convertedUnit.equals("pint")) {
            volume = volume/1.7598;
        }
        if(initialUnit.equals("gallon") && convertedUnit.equals("liter")  ) {
            volume = volume*4.5493;
        }
        if(initialUnit.equals("liter") && convertedUnit.equals("gallon")) {
            volume = volume/4.5493;
        }
        return new FluidConversion(volume, initialUnit, convertedUnit);
    }

    @GetMapping("/convertArea")
    public AreaConversion convertArea(@RequestParam(value = "area", defaultValue = "0.0") Double area,
                                          @RequestParam(value = "initialUnit", defaultValue = "hectare") String initialUnit,
                                          @RequestParam(value = "convertedUnit", defaultValue = "acre") String convertedUnit) {

        if(area ==0.0) {
            message = "Area, initialUnit and convertedUnit parameters are required";
            throw new ConversionNotFoundException(message);
        }
        if(initialUnit.equals("acre") && convertedUnit.equals("hectare")  ) {
            area = area*2.2046;
        }
        if(initialUnit.equals("hectare") && convertedUnit.equals("acre")) {
            area = area/2.2046;
        }
        if(initialUnit.equals("acre") && convertedUnit.equals("meter")  ) {
            area = area*4046.9;
            convertedUnit = "sq. " + convertedUnit;
        }
        if(initialUnit.equals("meter") && convertedUnit.equals("acre")) {
            area = area/4046.9;
        }
        return new AreaConversion(area, initialUnit, convertedUnit);
    }

}