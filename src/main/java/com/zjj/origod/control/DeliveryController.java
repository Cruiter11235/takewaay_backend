package com.zjj.origod.control;

import com.alibaba.fastjson.JSONObject;
import com.zjj.origod.dao.DeliveryMapper;
import com.zjj.origod.pojo.Delivery;
import com.zjj.origod.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;

    @PostMapping("getOrders")
    public JSONObject getOrders(@RequestBody JSONObject jsonObject){
        JSONObject json = deliveryService.getOrders();
        return json;
    }

    @PostMapping("getMyOrders")
    public JSONObject getMyOrders(@RequestBody JSONObject jsonObject){
        int d_id = (int)jsonObject.get("d_id");
        JSONObject json = deliveryService.getMyOrders(d_id);
        return json;
    }

    @PostMapping("updateOrder")
    public void updateOrder(@RequestBody JSONObject jsonObject){
        int o_id = (int)jsonObject.get("o_id");
        int d_id = (int)jsonObject.get("d_id");
        deliveryService.updateOrder(o_id,d_id);
    }

    @PostMapping("getOrderMeals")
    public JSONObject getOrderMeals(@RequestBody JSONObject jsonObject){
        int o_id = (int)jsonObject.get("o_id");
        JSONObject json = deliveryService.getOrderMeals(o_id);
        return json;
    }

    @PostMapping("getInfo")
    public JSONObject getInfo(@RequestBody JSONObject jsonObject){
        int d_id = (int)jsonObject.get("d_id");
        JSONObject json = deliveryService.getInfo(d_id);
        return json;
    }

    @PostMapping("updateInfo")
    public void updateInfo(@RequestBody JSONObject jsonObject){
        int d_id = (int)jsonObject.get("d_id");
        String d_password = (String)jsonObject.get("d_password");
        String d_phone = (String)jsonObject.get("d_phone");
        deliveryService.updateInfo(d_id,d_password,d_phone);
    }
}
