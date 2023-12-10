package com.zjj.origod.control;

import com.alibaba.fastjson.JSONObject;
import com.zjj.origod.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RestController
@RequestMapping("/")
@CrossOrigin
public class AccountController {
    @Autowired
    AccountService accountService;
    @PostMapping("login")
    JSONObject login(@RequestBody JSONObject jsonObject){
        String username = "";
        String password = "";
        String role = "";
        if(jsonObject.containsKey("username")){
            username = (String) jsonObject.get("username");
        }
        if(jsonObject.containsKey("password")){
            password = (String) jsonObject.get("password");
        }
        if(jsonObject.containsKey("role")){
            role = (String) jsonObject.get("role");
        }
        return accountService.login(username,password,role);
    }

    @PostMapping("register")
    JSONObject register(@RequestBody JSONObject jsonObject){
        String username = "";
        String password = "";
        String role = "";
        if(jsonObject.containsKey("username")){
            username = (String) jsonObject.get("username");
        }
        if(jsonObject.containsKey("password")){
            password = (String) jsonObject.get("password");
        }
        if(jsonObject.containsKey("role")){
            role = (String) jsonObject.get("role");
        }
        return accountService.register(username,password,role);
    }
}
