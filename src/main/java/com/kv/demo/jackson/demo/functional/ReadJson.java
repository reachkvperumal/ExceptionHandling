package com.kv.demo.jackson.demo.functional;

import com.kv.demo.jackson.demo.client.WorldTimeSvc;
import com.kv.demo.jackson.demo.model.ReadDemoResDO;
import com.kv.demo.jackson.demo.model.WriteDemoResDO;
import com.kv.demo.jackson.demo.util.impl.RWJsonWithExceptionHdlImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadJson {

    @Autowired
    private WorldTimeSvc worldTimeSvc;

    @Autowired
    private RWJsonWithExceptionHdlImpl rwjJsonWithExceptionHdl;

    public ReadDemoResDO apply() {
        return rwjJsonWithExceptionHdl.readValue(worldTimeSvc.getAsString(), ReadDemoResDO.class);
    }

    public WriteDemoResDO exp() {
        return rwjJsonWithExceptionHdl.readValue(worldTimeSvc.getAsString(), WriteDemoResDO.class);
    }
}
