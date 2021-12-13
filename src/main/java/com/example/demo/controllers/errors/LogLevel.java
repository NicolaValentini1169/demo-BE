package com.example.demo.controllers.errors;

public enum LogLevel {
    ERROR("ERROR"),
    WARN("WARN"),
    INFO("INFO"),
    DEBUG("DEBUG"),
    TRACE("TRACE");

    private final String value;

    LogLevel(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
