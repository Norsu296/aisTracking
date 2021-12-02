package com.kuba.aistracking.exception;

public class ControllerException extends RuntimeException{

    private ControllerError controllerError;

    public ControllerException(ControllerError controllerError){
        this.controllerError = controllerError;
    }
    public ControllerError getControllerError(){
        return controllerError;
    }

}
