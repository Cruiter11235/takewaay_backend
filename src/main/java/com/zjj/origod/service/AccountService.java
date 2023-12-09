package com.zjj.origod.service;
import com.zjj.origod.utils.RandomName;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjj.origod.dao.*;
import com.zjj.origod.pojo.Admin;
import com.zjj.origod.pojo.Customer;
import com.zjj.origod.pojo.Delivery;
import com.zjj.origod.pojo.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AdminMapper adminMapper;

    @Autowired
    MerchantMapper merchantMapper;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    DeliveryMapper deliveryMapper;

    @Autowired
    GlobalMapper globalMapper;


    public JSONObject login(String username,String password,String role){
        JSONObject jsonObject = new JSONObject();
        if(role.equals("merchant")){
            jsonObject.put("status",1);
            Merchant merchant = merchantMapper.selectByUsername(username);
            if(merchant!=null&&merchant.getM_password().equals(password)){
                jsonObject.put("status",0);
                jsonObject.put("m_id",merchant.getM_id());
            }
        }else if(role.equals("admin")){
            Admin admin = adminMapper.selectByUsername(username);
            jsonObject.put("status",1);
            if(admin!=null&&admin.getA_password().equals(password)){
                jsonObject.put("status",0);
            }
        }else if(role.equals("delivery")){
            jsonObject.put("status",1);
            Delivery delivery = deliveryMapper.selectByUsername(username);
            if(delivery!=null&&delivery.getD_password().equals(password)){
                jsonObject.put("status",0);
                jsonObject.put("d_id",delivery.getD_id());
            }
        }else if(role.equals("customer")){
            jsonObject.put("status",1);
            Customer customer = customerMapper.selectByUsername(username);
            if(customer!=null&&customer.getC_password().equals(password)){
                jsonObject.put("status",0);
                jsonObject.put("c_id",customer.getC_id());
            }
        }
        return jsonObject;
    }

    public JSONObject register(String username,String password,String role){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",1);
        if(role.equals("merchant")){
            Merchant merchant = merchantMapper.selectByUsername(username);
            if(merchant==null){
                jsonObject.put("status",0);
                merchantMapper.insertMerchant("merchant",username,password);
            }
        }else if(role.equals("admin")){
            Admin admin  = adminMapper.selectByUsername(username);
            if(admin==null){
                jsonObject.put("status",0);
            }
        }else if(role.equals("delivery")){
            Delivery delivery = deliveryMapper.selectByUsername(username);
            if(delivery==null){
                jsonObject.put("status",0);
                delivery = new Delivery();
                delivery.setD_username(username);
                delivery.setD_password(password);
                deliveryMapper.insertDelivery(delivery);
            }
        }else if(role.equals("customer")){
            Customer customer = customerMapper.selectByUsername(username);
            if(customer==null){
                jsonObject.put("status",0);
                customer = new Customer();
                customer.setC_username(username);
                customer.setC_password(password);
                customer.setC_name(RandomName.MakeName());
                customerMapper.insertCustomer(customer);
            }
        }
        return jsonObject;
    }
}
