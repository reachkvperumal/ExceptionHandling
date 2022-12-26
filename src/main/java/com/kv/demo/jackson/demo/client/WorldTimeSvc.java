package com.kv.demo.jackson.demo.client;


import com.kv.demo.jackson.demo.model.DateTimeDO;

public interface WorldTimeSvc {

    DateTimeDO getAsObject();

    String getAsString();
}
