package com.zjj.origod.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjj.origod.dao.CustomerMapper;
import com.zjj.origod.dao.GlobalMapper;
import com.zjj.origod.dao.MerchantMapper;
import com.zjj.origod.pojo.*;
import com.zjj.origod.utils.RandomName;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService{
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    MerchantMapper merchantMapper;
    @Autowired
    GlobalMapper globalMapper;
    public JSONObject getMerchants(){
        JSONObject jsonObject = new JSONObject();
        List<Map<String,Object>> res =customerMapper.selectMerchant();
        jsonObject.put("dt",res);
        return jsonObject;
    }

    public JSONObject getMeals(int m_id){
        JSONObject jsonObject = new JSONObject();
        List<Map<String,Object>> res = customerMapper.selectFoodByM_id(m_id);
        jsonObject.put("dt",res);
        return jsonObject;
    }

    public JSONObject getComments(int m_id){
        JSONObject jsonObject = new JSONObject();
        List<Map<String,Object>> res = merchantMapper.selectCommentByM_id(m_id);
        jsonObject.put("dt",res);
        return jsonObject;
    }

    public void createOrder(int c_id,int m_id,List<OrderItem> infoList){
        Order order = new Order();
        order.setC_id(c_id);
        order.setM_id(m_id);
        globalMapper.insertOrder(order);
        int o_id = order.getO_id();

        for(OrderItem orderItem : infoList){
            int f_id = orderItem.getF_id();
            int f_count = orderItem.getF_count();
            globalMapper.insertFoodInOrder(o_id,f_id,f_count);
        }
    }

    public JSONObject getInfo(int c_id){
        JSONObject jsonObject = new JSONObject();
        Customer customer = customerMapper.selectById(c_id);
        jsonObject.put("dt",customer);
        return jsonObject;
    }

    public void updateInfo(int c_id,String c_password,String c_address,String c_name,String c_phone){
        Customer customer = customerMapper.selectById(c_id);
        customer.setC_password(c_password);
        customer.setC_address(c_address);
        customer.setC_name(c_name);
        customer.setC_phone(c_phone);
        customerMapper.updateById(customer);
    }


    public void createReport(String content,int c_id,int m_id){
        Report report = new Report();
        report.setC_id(c_id);
        report.setContent(content);
        report.setM_id(m_id);
        customerMapper.createReport(report);
    }

    public void createComment(String content,int f_id,double score){
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setScore(score);
        comment.setF_id(f_id);
        customerMapper.createComment(comment);
    }
}
