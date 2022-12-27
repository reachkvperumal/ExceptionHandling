package com.kv.demo.jackson.demo.controller;

import com.kv.demo.jackson.demo.client.WorldTimeSvc;
import com.kv.demo.jackson.demo.functional.ReadJson;
import com.kv.demo.jackson.demo.functional.WriteJson;
import com.kv.demo.jackson.demo.model.DateTimeDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Clock;
import java.time.OffsetDateTime;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@WebMvcTest(DemoController.class)
public class TestDemoController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WorldTimeSvc worldTimeSvc;

    @MockBean
    private ReadJson readJson;

    @MockBean
    private WriteJson writeJson;


    @BeforeAll
    static void setup() {
        log.info("@BeforeAll - executes once before all test methods in this class");
    }

    @Test
    public void getSubSystemResp() throws Exception {
        when(worldTimeSvc.getAsObject()).thenReturn(new DateTimeDO("EST", "127.0.0.1",
                OffsetDateTime.now(Clock.systemUTC()), "1", 360, false, null,
                0, null, -1800, "America/New_York", 1672107350,
                "2022-12-27T02:15:50.031069+00:00", "-05:00", 52));
        this.mockMvc.perform(get("/api/v1/response")).andDo(print()).andExpect(status().isOk());
    }
}
