package com.eminerarslan.kodlama_io_dev.core.utils.results;

public class DataResult<T> extends Result {
    private final T DATA;

    public DataResult(boolean success, String message, T DATA) {
        super(success, message);
        this.DATA = DATA;
    }

    public DataResult(T data, boolean success) {
        super(success);
        DATA = data;
    }

    public T getData() {
        return this.DATA;
    }
}
