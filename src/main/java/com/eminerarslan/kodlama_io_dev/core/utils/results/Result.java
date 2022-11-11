package com.eminerarslan.kodlama_io_dev.core.utils.results;

public class Result {
    private final boolean SUCCESS;
    private String message;

    public Result(boolean success) {
        SUCCESS = success;
    }

    public Result(boolean success, String message) {
        this.SUCCESS = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return SUCCESS;
    }

    public String getMessage() {
        return message;
    }
}
