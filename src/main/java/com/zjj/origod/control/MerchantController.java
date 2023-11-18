package com.zjj.origod.control;


import com.zjj.origod.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/merchant")
public class MerchantController {
    @Autowired
    MerchantService merchantService;

    @PostMapping("register")
    public Object register(@RequestParam Map<String,Object> map){
        String Rusername = "";
        String Rpassword = "";
        Set<String> keys = map.keySet();
        if(keys.contains("username")){
            Rusername = (String)(map.get("username"));
        }
        if(keys.contains("password")){
            Rpassword = (String)(map.get("password"));
        }
        return merchantService.register(Rusername,Rpassword);
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
        return merchantService.Login(Lusername,Lpassword);
    }
}
