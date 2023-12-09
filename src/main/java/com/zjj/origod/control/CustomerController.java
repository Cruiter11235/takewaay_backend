package com.zjj.origod.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zjj.origod.pojo.OrderItem;
import com.zjj.origod.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;


    @PostMapping("getMerchants")
    public JSONObject getMerchants(@RequestBody JSONObject jsonObject){
        JSONObject json = customerService.getMerchants();
        return json;
    }

    @PostMapping("getMeals")
    public JSONObject getMeals(@RequestBody JSONObject jsonObject){
        int m_id = (int)jsonObject.get("m_id");
        JSONObject json = customerService.getMeals(m_id);
        return json;
    }

    @PostMapping("getComments")
    public JSONObject getComments(@RequestBody JSONObject jsonObject){
        int m_id = (int)jsonObject.get("m_id");
        JSONObject json = customerService.getComments(m_id);
        return json;
    }

    @PostMapping("createOrder")
    public void createOrder(@RequestBody JSONObject json){
        int c_id = (int)json.get("c_id");
        int m_id = (int)json.get("m_id");
        ArrayList<Map<String,Object>> arrayList = (ArrayList<Map<String,Object>>) json.get("food_list");
        List<OrderItem> orderItemList = new ArrayList<>();
        for(Map<String,Object> map:arrayList){
            int f_id = (int)map.get("f_id");
            int f_count = (int)map.get("f_count");
            OrderItem orderItem = new OrderItem();
            orderItem.setF_count(f_count);
            orderItem.setF_id(f_id);
            orderItemList.add(orderItem);
        }
        customerService.createOrder(c_id,m_id,orderItemList);
    }


    @PostMapping("getInfo")
    public JSONObject getInfo(@RequestBody JSONObject jsonObject){
        int c_id = (int)jsonObject.get("c_id");
        return customerService.getInfo(c_id);
    }

    @PostMapping("updateInfo")
    public void updateInfo(@RequestBody JSONObject jsonObject){
        int c_id = (int)jsonObject.get("c_id");
        String c_password = (String)jsonObject.get("c_password");
        String c_address = (String)jsonObject.get("c_address");
        String c_name = (String)jsonObject.get("c_name");
        String c_phone = (String)jsonObject.get("c_phone");
        customerService.updateInfo(c_id,c_password,c_address,c_name,c_phone);
    }

    @PostMapping("creataReport")
    public void createReport(@RequestBody JSONObject jsonObject){
        int c_id = (int)jsonObject.get("c_id");
        int m_id = (int)jsonObject.get("m_id");
        String content = (String)jsonObject.get("content");
        customerService.createReport(content,c_id,m_id);
    }

    @PostMapping("createComment")
    public void createComments(@RequestBody JSONObject jsonObject){
        int f_id = (int)jsonObject.get("f_id");
        String content = (String)jsonObject.get("content");
        double score = (double)jsonObject.get("score");
        customerService.createComment(content,f_id,score);
    }


}
