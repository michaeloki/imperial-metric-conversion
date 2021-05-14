package com.michaeloki.conversion.controller;

public class ConversionNotFoundException extends RuntimeException {

    public ConversionNotFoundException(String exception) {
        super(exception);
    }

}