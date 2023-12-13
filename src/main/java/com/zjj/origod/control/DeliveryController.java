package com.zjj.origod.control;

import com.alibaba.fastjson.JSONObject;
import com.zjj.origod.dao.DeliveryMapper;
import com.zjj.origod.pojo.Delivery;
import com.zjj.origod.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.Inet4Address;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/delivery")
@CrossOrigin
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
        int d_id = Integer.parseInt(jsonObject.get("d_id").toString());
        JSONObject json = deliveryService.getMyOrders(d_id);
        return json;
    }

    @PostMapping("updateOrder")
    public void updateOrder(@RequestBody JSONObject jsonObject){
        int o_id = Integer.parseInt(jsonObject.get("o_id").toString());
        int d_id = Integer.parseInt(jsonObject.get("d_id").toString());
        deliveryService.updateOrder(o_id,d_id);
    }

    @PostMapping("getOrderMeals")
    public JSONObject getOrderMeals(@RequestBody JSONObject jsonObject){
        int o_id = Integer.parseInt(jsonObject.get("o_id").toString());
        JSONObject json = deliveryService.getOrderMeals(o_id);
        return json;
    }

    @PostMapping("getInfo")
    public JSONObject getInfo(@RequestBody JSONObject jsonObject){
        int d_id = Integer.parseInt(jsonObject.get("d_id").toString());
        JSONObject json = deliveryService.getInfo(d_id);
        return json;
    }

    @PostMapping("updateInfo")
    public void updateInfo(@RequestBody JSONObject jsonObject){
        int d_id = Integer.parseInt(jsonObject.get("d_id").toString());
        String d_password = (String)jsonObject.get("d_password");
        String d_phone = (String)jsonObject.get("d_phone");
        deliveryService.updateInfo(d_id,d_password,d_phone);
    }


    @PostMapping("finishOrder")
    public void finishOrder(@RequestBody JSONObject jsonObject){
        int o_id = Integer.parseInt(jsonObject.get("o_id").toString());
        deliveryService.finishOrder(o_id);
    }



    @PostMapping("getFinishedOrderCount")
    public JSONObject getFinishedOrderCount(@RequestBody JSONObject jsonObject){
        int d_id = Integer.parseInt(jsonObject.get("d_id").toString());
        return deliveryService.getFinishedOrderCounts(d_id);
    }
}
