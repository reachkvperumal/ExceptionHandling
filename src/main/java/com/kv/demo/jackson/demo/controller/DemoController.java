package com.kv.demo.jackson.demo.controller;

import com.kv.demo.jackson.demo.client.WorldTimeSvc;
import com.kv.demo.jackson.demo.functional.ReadJson;
import com.kv.demo.jackson.demo.functional.WriteJson;
import com.kv.demo.jackson.demo.model.DateTimeDO;
import com.kv.demo.jackson.demo.model.ReadDemoResDO;
import com.kv.demo.jackson.demo.model.WriteDemoResDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1")
public class DemoController {

    @Autowired
    private WorldTimeSvc worldTimeSvc;

    @Autowired
    private ReadJson readJson;

    @Autowired
    private WriteJson writeJson;

    @GetMapping(value = "/response", produces = "application/json")
    public DateTimeDO getSubSystemResp() {
        return worldTimeSvc.getAsObject();
    }

    @GetMapping(value = "/read", produces = "application/json")
    public ReadDemoResDO read() {
        return readJson.apply();
    }

    @GetMapping(value = "/write", produces = "application/json")
    public String write() {
        return writeJson.apply();
    }

    @GetMapping(value = "/exception", produces = "application/json")
    public WriteDemoResDO exception() {
        log.info("Exception execution...");
        return readJson.exp();
    }
}
