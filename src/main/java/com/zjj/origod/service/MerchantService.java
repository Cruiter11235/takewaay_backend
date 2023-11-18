package com.zjj.origod.service;

import com.alibaba.fastjson.JSONObject;
import com.zjj.origod.dao.MerchantMapper;
import com.zjj.origod.pojo.Customer;
import com.zjj.origod.pojo.Merchant;
import com.zjj.origod.service.itfaces.Register;
import com.zjj.origod.utils.RandomName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Set;

@Service
public class MerchantService implements Register {
    @Autowired
    MerchantMapper merchantMapper;

    @Override
    public JSONObject register(String username,String password){
        JSONObject json = new JSONObject();
        Merchant result = merchantMapper.selectByUsername(username);
        if(result!=null){
            json.put("msg","用户名已存在");
            json.put("status",1);
        }else{
            if(username.equals("")){
                json.put("msg","用户名不能为空");
                json.put("status",1);
            }else {
                merchantMapper.insertMerchant(RandomName.MakeName(), username, password);
                json.put("msg", "注册成功");
                json.put("status", 0);
            }
        }
        return json;
    }

    public JSONObject Login(String username,String password){
        JSONObject json = new JSONObject();
        Merchant result = merchantMapper.selectByUsername(username);
        if(result==null){
            json.put("msg","用户名不存在");
            json.put("status",1);
        }else{
            String pwd = result.getM_password();
            if(!pwd.equals(password)){
                json.put("msg","密码错误");
                json.put("status",1);
            }else{
                json.put("dt",result);
                json.put("status",0);
                json.put("msg","登陆成功");
            }
        }
        return json;
    }
}
