package com.zjj.origod.service;

import com.alibaba.fastjson.JSONObject;
import com.zjj.origod.dao.DeliveryMapper;
import com.zjj.origod.pojo.Customer;
import com.zjj.origod.pojo.Delivery;
import com.zjj.origod.service.itfaces.Register;
import com.zjj.origod.utils.RandomName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService implements Register {

    @Autowired
    DeliveryMapper deliveryMapper;
    @Override
    public JSONObject register(String username, String password) {
        JSONObject json = new JSONObject();
        Delivery delivery = deliveryMapper.selectByUsername(username);
        if(delivery!=null){
            json.put("msg","用户名已存在");
            json.put("status",1);
        }else{
            if(username.equals("")){
                json.put("msg","用户名不能为空");
                json.put("status",1);
            }else {
                deliveryMapper.insertDelivery(username, password);
                json.put("msg", "注册成功");
                json.put("status", 0);
            }
        }
        return json;
    }

    public JSONObject Login(String username,String password){
        JSONObject json = new JSONObject();
        Delivery result = deliveryMapper.selectByUsername(username);
        if(result==null){
            json.put("msg","用户名不存在");
            json.put("status",1);
        }else{
            String pwd = result.getD_password();
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
