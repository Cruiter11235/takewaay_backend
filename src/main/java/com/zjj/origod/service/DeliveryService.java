package com.zjj.origod.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjj.origod.dao.DeliveryMapper;
import com.zjj.origod.pojo.Customer;
import com.zjj.origod.pojo.Delivery;
import com.zjj.origod.utils.RandomName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.Map;
import com.zjj.origod.utils.TimeUtil;
@Service
public class DeliveryService {
    @Autowired
    DeliveryMapper deliveryMapper;

    public JSONObject getMyOrders(int d_id){
        JSONObject jsonObject = new JSONObject();
        List<Map<String,Object>> res = deliveryMapper.selectOrderByD_id(d_id);
        jsonObject.put("dt",res);
        return jsonObject;
    }

    public JSONObject getOrders(){
        JSONObject jsonObject = new JSONObject();
        List<Map<String,Object>> res = deliveryMapper.selectAccessibleOrder();
        jsonObject.put("dt",res);
        return jsonObject;
    }


    public void updateOrder(int o_id,int d_id){
        deliveryMapper.UpdateOrder(o_id,d_id,TimeUtil.getCurrentTime());
    }


    public JSONObject getOrderMeals(int o_id){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("dt",deliveryMapper.selectFoodInOrder(o_id));
        return jsonObject;
    }

    public JSONObject getInfo(int d_id){
        JSONObject jsonObject = new JSONObject();
        Delivery delivery = deliveryMapper.getInfo(d_id);
        jsonObject.put("dt",delivery);
        return jsonObject;
    }

    public void updateInfo(int d_id,String password,String d_phone){
        Delivery delivery = new Delivery();
        delivery.setD_password(password);
        delivery.setD_phone(d_phone);
        delivery.setD_id(d_id);
        deliveryMapper.updateInfo(delivery);
    }

    public void finishOrder(int o_id){
        deliveryMapper.finishOrder(o_id);
    }
}
