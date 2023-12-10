package com.zjj.origod.control;


import com.alibaba.fastjson.JSONObject;
import com.zjj.origod.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/merchant")
@CrossOrigin
public class MerchantController {
    @Autowired
    MerchantService merchantService;

    @PostMapping("getMeal")
    public JSONObject getMeal(@RequestBody JSONObject jsonObject){
        int m_id = Integer.parseInt(jsonObject.get("m_id").toString());
        JSONObject json = merchantService.getMeal(m_id);
        return json;
    }

    @PostMapping("createMeal")
    public void createMeal(@RequestBody JSONObject jsonObject){
        int m_id = Integer.parseInt(jsonObject.get("m_id").toString());
        String food_name = (String)jsonObject.get("f_name");
        String food_class = (String)jsonObject.get("f_class");
        double price = Double.parseDouble(jsonObject.get("price").toString());
        int is_available = jsonObject.get("is_available").toString().equals("yes")?1:0;
        merchantService.createMeal(m_id,food_class,food_name,price,is_available);
    }

    @PostMapping("getComments")
    public JSONObject getComments(@RequestBody JSONObject jsonObject){
        int m_id = Integer.parseInt(jsonObject.get("m_id").toString());
        JSONObject json = merchantService.getComments(m_id);
        return json;
    }


    @PostMapping("getOrders")
    public JSONObject getOrders(@RequestBody JSONObject jsonObject){
        int m_id = Integer.parseInt(jsonObject.get("m_id").toString());
        JSONObject json = merchantService.getOrders(m_id);
        return json;
    }

    @PostMapping("deleteMeal")
    public void deleteMeal(@RequestBody JSONObject jsonObject){
        int f_id = Integer.parseInt(jsonObject.get("f_id").toString());
        merchantService.deleteMeal(f_id);
    }

    @PostMapping("updateMeal")
    public void updateMeal(@RequestBody JSONObject jsonObject){
        int f_id = Integer.parseInt(jsonObject.get("f_id").toString());
        String f_class = (String)jsonObject.get("f_class");
        String f_name = (String)jsonObject.get("f_name");
        double price = Double.parseDouble(jsonObject.get("price").toString());
        int is_available = jsonObject.get("is_available").toString().equals("yes")?1:0;
        merchantService.updateMeal(f_id,f_class,f_name,is_available,price);
    }
}
