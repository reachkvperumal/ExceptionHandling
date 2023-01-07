package com.kv.demo.jackson.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        DemoApplication.main(new String[]{});
        assertTrue(true);
        System.out.println(UUID.randomUUID());
    }
}
