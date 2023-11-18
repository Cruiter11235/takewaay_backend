package com.zjj.origod.service;

import com.alibaba.fastjson.JSONObject;
import com.zjj.origod.dao.AdminMapper;
import com.zjj.origod.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;

    public JSONObject login(String username, String password){
        System.out.println(username);
        Admin admin = adminMapper.selectByUsername(username);
        JSONObject json = new JSONObject();
        if(admin==null){
            json.put("msg","用户名不存在");
            json.put("status",1);
        }else{
            if(!admin.getA_password().equals(password)){
                json.put("msg","密码错误");
                json.put("status",1);
            }else{
                json.put("msg","登陆成功");
                json.put("status",0);
                json.put("dt",admin);
            }
        }
        return json;
    }
}
