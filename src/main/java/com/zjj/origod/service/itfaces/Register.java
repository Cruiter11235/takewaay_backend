package com.zjj.origod.service.itfaces;

import com.alibaba.fastjson.JSONObject;

public interface Register {
    JSONObject register(String username,String password);
}
