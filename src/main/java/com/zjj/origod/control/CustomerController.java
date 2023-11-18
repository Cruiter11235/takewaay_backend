package com.zjj.origod.control;

import com.alibaba.fastjson.JSONObject;
import com.zjj.origod.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("register")
    public Object register(@RequestParam Map<String,Object>map){
        String Rusername = "";
        String Rpassword = "";
        Set<String> keys = map.keySet();
        if(keys.contains("username")){
            Rusername = (String)(map.get("username"));
        }
        if(keys.contains("password")){
            Rpassword = (String)(map.get("password"));
        }
        return customerService.register(Rusername,Rpassword);
    }

    @PostMapping("login")
    public Object login(@RequestParam Map<String,Object> map){
        String Lusername = "";
        String Lpassword = "";
        Set<String> keys = map.keySet();
        if(keys.contains("username")){
            Lusername = (String)(map.get("username"));
        }
        if(keys.contains("password")){
            Lpassword = (String)(map.get("password"));
        }
        return customerService.Login(Lusername,Lpassword);
    }
}
