package com.asrevo.drone.management.domain;

public record Serial(String serial) {
    public Serial {
        if (serial == null) {
            throw new IllegalArgumentException("Serial cannot be null");
        }
        if (serial.isEmpty()) {
            throw new IllegalArgumentException("Serial cannot be empty");
        }
        if (serial.length() != 100) {
            throw new IllegalArgumentException("Serial length must be 100");
        }
    }

    public static Serial of(String serial) {
        return new Serial(serial);
    }
}
