package com.zjj.origod.control;

import com.alibaba.fastjson.JSONObject;
import com.zjj.origod.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
@RestController
@RequestMapping("/")
public class AccountController {
    @Autowired
    AccountService accountService;
    @PostMapping("login")
    JSONObject login(@RequestParam Map<String,Object> map){
        String username = "";
        String password = "";
        String role = "";
        if(map.containsKey("username")){
            username = (String) map.get("username");
        }
        if(map.containsKey("password")){
            password = (String) map.get("password");
        }
        if(map.containsKey("role")){
            role = (String) map.get("role");
        }
        return accountService.login(username,password,role);
    }

    @PostMapping("register")
    JSONObject register(@RequestParam Map<String,Object> map){
        String username = "";
        String password = "";
        String role = "";
        if(map.containsKey("username")){
            username = (String) map.get("username");
        }
        if(map.containsKey("password")){
            password = (String) map.get("password");
        }
        if(map.containsKey("role")){
            role = (String) map.get("role");
        }
        return accountService.register(username,password,role);
    }
}
