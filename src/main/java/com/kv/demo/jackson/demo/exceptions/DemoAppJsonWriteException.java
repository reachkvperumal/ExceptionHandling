package com.kv.demo.jackson.demo.exceptions;

public class DemoAppJsonWriteException extends DemoException {

    public DemoAppJsonWriteException() {
    }

    public DemoAppJsonWriteException(String message) {
        super(message);
    }

    public DemoAppJsonWriteException(String message, Throwable cause) {
        super(message, cause);
    }

    public DemoAppJsonWriteException(Throwable cause) {
        super(cause);
    }

    public DemoAppJsonWriteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
