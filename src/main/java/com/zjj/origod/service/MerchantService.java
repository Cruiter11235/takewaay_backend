package com.zjj.origod.service;

import com.alibaba.fastjson.JSONObject;
import com.zjj.origod.dao.GlobalMapper;
import com.zjj.origod.dao.MerchantMapper;
import com.zjj.origod.pojo.Customer;
import com.zjj.origod.pojo.Merchant;
import com.zjj.origod.utils.RandomName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class MerchantService{
    @Autowired
    MerchantMapper merchantMapper;
    @Autowired
    GlobalMapper globalMapper;

    public JSONObject getMeal(int m_id){
        JSONObject jsonObject = new JSONObject();
        List<Map<String,Object>> res = merchantMapper.selectFoodByM_id(m_id);
        jsonObject.put("dt",res);
        return jsonObject;
    }

    public void createMeal(int m_id,String food_class,String food_name,double price,int is_available){
        int c_id = merchantMapper.getClassIdByName(food_class);
        merchantMapper.insertFoodOnM_id(m_id,c_id,food_name,is_available,price);
    }

    public JSONObject getComments(int m_id){
        JSONObject jsonObject = new JSONObject();
        List<Map<String,Object>> res = merchantMapper.selectCommentByM_id(m_id);
        jsonObject.put("dt",res);
        return jsonObject;
    }

    public JSONObject getOrders(int m_id){
        JSONObject jsonObject = new JSONObject();
        List<Map<String,Object>> res = merchantMapper.selectOrderByM_id(m_id);
        jsonObject.put("dt",res);
        return jsonObject;
    }

    public void deleteMeal(int f_id){
        merchantMapper.deleteFoodById(f_id);
    }

    public void updateMeal(int f_id,String f_class,String f_name,int is_available,double price){
        int class_id = merchantMapper.getClassIdByName(f_class);
        merchantMapper.updateFoodById(f_id,class_id,f_name,is_available,price);
    }


    public void updateImgUrl(int f_id,String url){
        merchantMapper.updateFoodImgUrl(url,f_id);
    }
}
