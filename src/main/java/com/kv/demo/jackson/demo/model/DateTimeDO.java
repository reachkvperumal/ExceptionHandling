package com.kv.demo.jackson.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;

public record DateTimeDO(

        @JsonProperty("abbreviation") String abbreviation,
        @JsonProperty("client_ip") String client_ip,
        @JsonProperty("datetime") OffsetDateTime datetime,
        @JsonProperty("day_of_week") String day_of_week,
        @JsonProperty("day_of_year") Integer day_of_year,
        @JsonProperty("dst") boolean dst,
        @JsonProperty("dst_from") String dst_from,
        @JsonProperty("dst_offset") Integer dst_offset,
        @JsonProperty("dst_until") String dst_until,
        @JsonProperty("raw_offset") Integer raw_offset,
        @JsonProperty("timezone") String timezone,
        @JsonProperty("unixtime") Integer unixtime,
        @JsonProperty("utc_datetime") String utc_datetime,
        @JsonProperty("utc_offset") String utc_offset,
        @JsonProperty("week_number") Integer week_number
) implements Serializable {
    @Serial
    private static final long serialVersionUID = -6697299060517294890L;
}
