package com.zjj.origod.control;


import com.alibaba.fastjson.JSONObject;
import com.zjj.origod.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/merchant")
public class MerchantController {
    @Autowired
    MerchantService merchantService;

    @PostMapping("getMeal")
    public JSONObject getMeal(@RequestBody JSONObject jsonObject){
        int m_id = (int)jsonObject.get("m_id");
        JSONObject json = merchantService.getMeal(m_id);
        return json;
    }

    @PostMapping("createMeal")
    public void createMeal(@RequestBody JSONObject jsonObject){
        int m_id = (int)jsonObject.get("m_id");
        String food_name = (String)jsonObject.get("food_name");
        String food_class = (String)jsonObject.get("food_class");
        double price = (double)jsonObject.get("price");
        int is_available = (int)jsonObject.get("is_available");
        merchantService.createMeal(m_id,food_class,food_name,price,is_available);
    }

    @PostMapping("getComments")
    public JSONObject getComments(@RequestBody JSONObject jsonObject){
        int m_id = (int)jsonObject.get("m_id");
        JSONObject json = merchantService.getComments(m_id);
        return json;
    }


    @PostMapping("getOrders")
    public JSONObject getOrders(@RequestBody JSONObject jsonObject){
        int m_id = (int)jsonObject.get("m_id");
        JSONObject json = merchantService.getOrders(m_id);
        return json;
    }

    @PostMapping("deleteMeal")
    public void deleteMeal(@RequestBody JSONObject jsonObject){
        int f_id = (int)jsonObject.get("f_id");
        merchantService.deleteMeal(f_id);
    }

    @PostMapping("updateMeal")
    public void updateMeal(@RequestBody JSONObject jsonObject){
        int f_id = (int)jsonObject.get("f_id");
        String f_class = (String)jsonObject.get("f_class");
        String f_name = (String)jsonObject.get("f_name");
        double price = (double)jsonObject.get("price");
        int is_available = (int)jsonObject.get("is_available");
        merchantService.updateMeal(f_id,f_class,f_name,is_available,price);
    }
}
