package com.zjj.origod.control;

import com.alibaba.fastjson.JSONObject;
import com.zjj.origod.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/login")
    public JSONObject login(@RequestParam Map<String,Object> map){
        String username = "";
        String password = "";
        if(map.containsKey("username")){
            username = (String) map.get("username");
        }
        if(map.containsKey("password")){
            password = (String) map.get("password");
        }
        return adminService.login(username,password);
    }
}
