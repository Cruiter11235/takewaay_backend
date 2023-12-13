package com.zjj.origod.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zjj.origod.pojo.OrderItem;
import com.zjj.origod.service.CustomerService;
import com.zjj.origod.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    DeliveryService deliveryService;

    @PostMapping("getMerchants")
    public JSONObject getMerchants(@RequestBody JSONObject jsonObject){
        JSONObject json = customerService.getMerchants();
        return json;
    }

    @PostMapping("getMeals")
    public JSONObject getMeals(@RequestBody JSONObject jsonObject){
        int m_id = Integer.parseInt(jsonObject.get("m_id").toString());
        JSONObject json = customerService.getMeals(m_id);
        return json;
    }

    @PostMapping("getComments")
    public JSONObject getComments(@RequestBody JSONObject jsonObject){
        int m_id = Integer.parseInt(jsonObject.get("m_id").toString());
        JSONObject json = customerService.getComments(m_id);
        return json;
    }

    @PostMapping("createOrder")
    public void createOrder(@RequestBody JSONObject json){
        int c_id = Integer.parseInt(json.get("c_id").toString());
        int m_id = Integer.parseInt(json.get("m_id").toString());
        ArrayList<Map<String,Object>> arrayList = (ArrayList<Map<String,Object>>) json.get("food_list");
        List<OrderItem> orderItemList = new ArrayList<>();
        for(Map<String,Object> map:arrayList){
            int f_id = Integer.parseInt(map.get("f_id").toString());
            int f_count = Integer.parseInt(map.get("f_count").toString());
            OrderItem orderItem = new OrderItem();
            orderItem.setF_count(f_count);
            orderItem.setF_id(f_id);
            orderItemList.add(orderItem);
        }
        customerService.createOrder(c_id,m_id,orderItemList);
    }


    @PostMapping("getInfo")
    public JSONObject getInfo(@RequestBody JSONObject jsonObject){
        int c_id = Integer.parseInt(jsonObject.get("c_id").toString());
        return customerService.getInfo(c_id);
    }

    @PostMapping("updateInfo")
    public void updateInfo(@RequestBody JSONObject jsonObject){
        int c_id = Integer.parseInt(jsonObject.get("c_id").toString());
        String c_password = (String)jsonObject.get("c_password");
        String c_address = (String)jsonObject.get("c_address");
        String c_name = (String)jsonObject.get("c_name");
        String c_phone = (String)jsonObject.get("c_phone");
        customerService.updateInfo(c_id,c_password,c_address,c_name,c_phone);
    }

    @PostMapping("createReport")
    public void createReport(@RequestBody JSONObject jsonObject){
        int c_id = Integer.parseInt(jsonObject.get("c_id").toString());
        int m_id = Integer.parseInt(jsonObject.get("m_id").toString());
        String content = (String)jsonObject.get("content");
        customerService.createReport(content,c_id,m_id);
    }

    @PostMapping("createComment")
    public void createComment(@RequestBody JSONObject jsonObject){
        int f_id = Integer.parseInt(jsonObject.get("f_id").toString());
        String content = (String)jsonObject.get("content");
        double score = Double.parseDouble(jsonObject.get("score").toString());
        customerService.createComment(content,f_id,score);
    }


    @PostMapping("getMyOrders")
    public JSONObject getMyOrders(@RequestBody JSONObject jsonObject){
        int c_id = Integer.parseInt(jsonObject.get("c_id").toString());
        return customerService.getMyOrders(c_id);
    }

    @PostMapping("getOrderMeals")
    public JSONObject getOrderMeals(@RequestBody JSONObject jsonObject){
        System.out.println(jsonObject);
        int o_id = Integer.parseInt(jsonObject.get("o_id").toString());
        return customerService.getOrderMeals(o_id);
    }


}
