package com.kv.demo.jackson.demo.util.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kv.demo.jackson.demo.util.ReadJsonWithExceptionHdl;
import com.kv.demo.jackson.demo.util.WriteJsonWithExceptionHdl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RWJJsonWithExceptionHdlImpl {

    private ObjectMapper objectMapper;

    @Autowired
    public RWJJsonWithExceptionHdlImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public <T> String writeValue(T t) {
        return WriteJsonWithExceptionHdl.write(objectMapper::writeValueAsString, t);
    }


    public <T> T readValue(String content, Class<T> type) {
        return ReadJsonWithExceptionHdl.read(objectMapper::readValue, content, type);
    }
}
