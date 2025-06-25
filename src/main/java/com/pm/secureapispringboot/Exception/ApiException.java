package com.pm.secureapispringboot.Exception;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    } public ApiException() {
        super("An Error Occurred: " );
    }
}
