package com.michaeloki.conversion.model;

public class ServerStatus {

    private final String message;

    public ServerStatus(String message) {
        this.message = message;
    }

    public String getStatus() {
        return message;
    }
}
