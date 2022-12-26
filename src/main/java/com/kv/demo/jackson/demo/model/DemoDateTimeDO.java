package com.kv.demo.jackson.demo.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public final class DemoDateTimeDO implements Serializable {
    @Serial
    private static final long serialVersionUID = 2617021845636290498L;
    private LocalDateTime utc_datetime;
    private String timezone;
    private String client_ip;


}
