package com.dexdev.loansimulation.shared.exceptions;

public class CustomErrorResponse {
    private int statusCode;
    private String message;

    public CustomErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
