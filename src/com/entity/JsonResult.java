package com.entity;

public class JsonResult {
    private boolean success;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public JsonResult() {
    }

    public JsonResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
