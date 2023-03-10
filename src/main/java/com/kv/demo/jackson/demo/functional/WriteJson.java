package com.kv.demo.jackson.demo.functional;

import com.kv.demo.jackson.demo.model.WriteDemoResDO;
import com.kv.demo.jackson.demo.util.impl.RWJsonWithExceptionHdlImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriteJson {

    @Autowired
    private RWJsonWithExceptionHdlImpl rwjJsonWithExceptionHdl;

    public String apply() {
        WriteDemoResDO res = new WriteDemoResDO();
        res.setFirstName("Demo");
        res.setLastName("Application");
        return rwjJsonWithExceptionHdl.writeValue(res);
    }
}
