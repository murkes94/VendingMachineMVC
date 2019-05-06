package com.vendingmachine.model.action;

/**
 * This class creates responses for different actions
 */
public class ActionJsonResponse {

    private String message;
    private boolean success;

    public ActionJsonResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
