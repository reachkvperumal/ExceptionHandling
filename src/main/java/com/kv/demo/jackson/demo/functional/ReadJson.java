package com.kv.demo.jackson.demo.functional;

import com.kv.demo.jackson.demo.client.WorldTimeSvc;
import com.kv.demo.jackson.demo.model.ReadDemoDORes;
import com.kv.demo.jackson.demo.model.WriteDemoDORes;
import com.kv.demo.jackson.demo.util.impl.RWJJsonWithExceptionHdlImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadJson {

    @Autowired
    private WorldTimeSvc worldTimeSvc;

    @Autowired
    private RWJJsonWithExceptionHdlImpl rwjJsonWithExceptionHdl;

    public ReadDemoDORes apply() {
        return rwjJsonWithExceptionHdl.readValue(worldTimeSvc.getAsString(), ReadDemoDORes.class);
    }

    public WriteDemoDORes exp() {
        return rwjJsonWithExceptionHdl.readValue(worldTimeSvc.getAsString(), WriteDemoDORes.class);
    }
}
