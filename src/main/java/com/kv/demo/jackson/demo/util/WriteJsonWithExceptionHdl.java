package com.kv.demo.jackson.demo.util;

import com.kv.demo.jackson.demo.exceptions.DemoAppJsonWriteException;

@FunctionalInterface
public interface WriteJsonWithExceptionHdl<T, R, E extends Throwable> {
    R apply(T t) throws E;

    static <T, R, E extends Throwable> R write(WriteJsonWithExceptionHdl<T, R, E> func, T t) {
        try {
            return func.apply(t);
        } catch (Throwable e) {
            throw new DemoAppJsonWriteException(e);
        }
    }
}
