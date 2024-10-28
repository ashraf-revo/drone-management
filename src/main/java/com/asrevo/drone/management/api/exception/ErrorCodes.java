package com.asrevo.drone.management.api.exception;

public class ErrorCodes {
    public static final ErrorCode DRONE_SERIAL_EXIST = new ErrorCode("00", "drone with this serial already exists");
    public static final ErrorCode INVALID_DRONE_STATE = new ErrorCode("00", "invalid drone state");
    public static final ErrorCode INVALID_SERIAL = new ErrorCode("00", "invalid serial");
    public static final ErrorCode INVALID_BATTERY_CAPACITY = new ErrorCode("00", "invalid battery capacity");
    public static final ErrorCode INVALID_WIGHT_LIMIT = new ErrorCode("00", "invalid wight limit");
    public static final ErrorCode NO_DRONE_EXIST_WITH_THIS_ID = new ErrorCode("00", "no drone exist with this id");
    public static final ErrorCode DRONE_NOT_LOADED_WITH_PACKAGE = new ErrorCode("00", "drone not loaded with package");
    public static final ErrorCode INVALID_PACKAGE_CODE = new ErrorCode("00", "invalid package code");
    public static final ErrorCode INVALID_PACKAGE_NAME = new ErrorCode("00", "invalid package name");

}
