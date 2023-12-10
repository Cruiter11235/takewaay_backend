package com.zjj.origod.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjj.origod.dao.AdminMapper;
import com.zjj.origod.dao.GlobalMapper;
import com.zjj.origod.dao.MerchantMapper;
import com.zjj.origod.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    MerchantMapper merchantMapper;
    @Autowired
    GlobalMapper globalMapper;
    /**
     * /admin/*
     * @return JSONObject
     */
    public JSONObject getMerchant(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("dt",adminMapper.selectMerchant());
        jsonObject.put("status",0);
        return jsonObject;
    }

    public JSONObject getCustomer(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("dt",adminMapper.selectCustomers());
        return jsonObject;
    }

    public JSONObject getDelivery(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("dt",adminMapper.selectDelivery());
        return jsonObject;
    }

    public JSONObject getReports(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("dt",adminMapper.selectReports());
        return jsonObject;
    }
    public JSONObject getReportById(int r_id){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("dt",adminMapper.getReportById(r_id));
        return jsonObject;
    }
    public void deleteMerchant(int m_id){
        adminMapper.deleteMerchant(m_id);
    }
    public void deleteCustomer(int c_id){
        adminMapper.deleteCustomer(c_id);
    }
    public void deleteDelivery(int d_id){
        adminMapper.deleteDelivery(d_id);
    }
    public void updateCustomer(String password,int c_id){
        adminMapper.updateCustomer(password, c_id);
    }
    public void updateDelivery(String password,int d_id){
        adminMapper.updateDelivery(password,d_id);
    }
    public void updateReport(int r_id){
        adminMapper.updateReport(r_id);
    }
    public void LockMerchant(int m_id){
        adminMapper.LockMerchant(m_id);
    }
    public void UnLockMerchant(int m_id){
        adminMapper.UnLockMerchant(m_id);
    }
    public void updateMerchant(int m_id,String m_name,String m_password,String m_phone,String m_address){
        adminMapper.updateMerchant(m_id,m_name,m_password,m_phone,m_address);
    }
    public void lockMerchant(int m_id){
        adminMapper.LockMerchant(m_id);
    }
    public void unlockMerchant(int m_id){
        adminMapper.UnLockMerchant(m_id);
    }

    public void createMerchant(String m_name,String m_username,String m_password,String m_address,String m_phone){
        adminMapper.createMerchant(m_name,m_username,m_password,m_address,m_phone);
    }
}
