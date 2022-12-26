package com.kv.demo.jackson.demo.client.impl;

import com.kv.demo.jackson.demo.client.WorldTimeSvc;
import com.kv.demo.jackson.demo.model.DateTimeDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class WorldTimeSvcImpl implements WorldTimeSvc {

    private static final String RESP = """
            {
              "name": "Azure",
              "accessKey": "AKIAJ6CJIOPQ2CS5Z76Q",
              "eventName": "ListEndpoints",
              "eventId": "3a03e3bb-026d-4826-a42c-5155d9622f8e"
            }
            """;

    @Value("${api.worldTime.endpoint}")
    private String endpoint;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public DateTimeDO getAsObject() {
        return restTemplate.getForObject(endpoint, DateTimeDO.class);
    }

    @Override
    public String getAsString() {
        return RESP;
    }
}