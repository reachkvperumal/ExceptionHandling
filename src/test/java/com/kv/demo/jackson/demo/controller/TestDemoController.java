package com.kv.demo.jackson.demo.controller;

import com.kv.demo.jackson.demo.client.WorldTimeSvc;
import com.kv.demo.jackson.demo.exceptions.DemoAppJsonReadException;
import com.kv.demo.jackson.demo.functional.ReadJson;
import com.kv.demo.jackson.demo.functional.WriteJson;
import com.kv.demo.jackson.demo.model.DateTimeDO;
import com.kv.demo.jackson.demo.model.ReadDemoResDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

    private static final String endpointPrefix = "/api/v1";

    private static final String writeResp = """
            {
                "firstName": "Demo",
                "lastName": "Application"
            }
            """;

    @BeforeAll
    static void setup() {
        log.info("@BeforeAll - executes once before all test methods in this class");
    }

    @Test
    @DisplayName("/response")
    public void getSubSystemResp() throws Exception {
        when(worldTimeSvc.getAsObject()).thenReturn(new DateTimeDO("EST", "127.0.0.1",
                OffsetDateTime.now(Clock.systemUTC()), "1", 360, false, null,
                0, null, -1800, "America/New_York", 1672107350,
                "2022-12-27T02:15:50.031069+00:00", "-05:00", 52));
        this.mockMvc.perform(get(endpointPrefix + "/response")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @DisplayName("/read")
    public void read() throws Exception {
        when(readJson.apply()).thenReturn(new ReadDemoResDO("Azure", "AKIAJ6CJIOPQ2CS5Z76Q",
                "ListEndpoints", "3a03e3bb-026d-4826-a42c-5155d9622f8e"));
        this.mockMvc.perform(get(endpointPrefix + "/read")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Azure"))
                .andExpect(jsonPath("$.accessKey").value("AKIAJ6CJIOPQ2CS5Z76Q"))
                .andExpect(jsonPath("$.eventName").value("ListEndpoints"))
                .andExpect(jsonPath("$.eventId").value("3a03e3bb-026d-4826-a42c-5155d9622f8e"));
    }

    @Test
    @DisplayName("/write")
    public void write() throws Exception {
        when(writeJson.apply()).thenReturn(writeResp);
        this.mockMvc.perform(get(endpointPrefix + "/write")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Demo"))
                .andExpect(jsonPath("$.lastName").value("Application"));

    }

    @Test
    @DisplayName("/exception")
    public void exception() throws Exception {
        when(readJson.exp()).thenThrow(new DemoAppJsonReadException());
        this.mockMvc.perform(get(endpointPrefix + "/exception")).andDo(print())
                .andExpect(status().is5xxServerError())
                .andExpect(content().string("Application failed to process this request"));
    }
}
