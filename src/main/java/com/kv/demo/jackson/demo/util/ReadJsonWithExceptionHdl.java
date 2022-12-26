package com.kv.demo.jackson.demo.util;


import com.kv.demo.jackson.demo.exceptions.DemoAppJsonReadException;

@FunctionalInterface
public interface ReadJsonWithExceptionHdl<P, T, R, E extends Throwable> {

    R apply(P p, T t) throws E;

    static <P, T, R, E extends Throwable> R read(ReadJsonWithExceptionHdl<P, T, R, E> func, P p, T t) {

        try {
            return func.apply(p, t);
        } catch (Throwable e) {
            throw new DemoAppJsonReadException(e);
        }

    }

}
