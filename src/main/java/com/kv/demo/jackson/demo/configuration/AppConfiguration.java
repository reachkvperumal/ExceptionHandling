package com.kv.demo.jackson.demo.configuration;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Slf4j
@Configuration
public class AppConfiguration {

    @Value("${api.dateTimeFormat}")
    private String dateTimeFormat;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public ObjectMapper tolerantObjectMapper() {
        log.info("Creating Object mapper");

        final JsonFactory jsonFactory = new JsonFactory();
        jsonFactory.disable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
        ObjectMapper objectMapper = new ObjectMapper(jsonFactory);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        DateFormat df = new SimpleDateFormat(dateTimeFormat);
        objectMapper.setDateFormat(df);
        return objectMapper;
    }
}
