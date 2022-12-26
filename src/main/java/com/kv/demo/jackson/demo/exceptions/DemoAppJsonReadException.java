package com.kv.demo.jackson.demo.exceptions;

public class DemoAppJsonReadException extends DemoException {

    public DemoAppJsonReadException() {
    }

    public DemoAppJsonReadException(String message) {
        super(message);
    }

    public DemoAppJsonReadException(String message, Throwable cause) {
        super(message, cause);
    }

    public DemoAppJsonReadException(Throwable cause) {
        super(cause);
    }

    public DemoAppJsonReadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
