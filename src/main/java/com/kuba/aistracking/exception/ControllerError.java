package com.kuba.aistracking.exception;

public enum ControllerError {

    ROCKET_NOT_FOUND("Rocket does not exist"),
    BASE_NOT_FOUND("Base does not exist");

    private String message;

    ControllerError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
