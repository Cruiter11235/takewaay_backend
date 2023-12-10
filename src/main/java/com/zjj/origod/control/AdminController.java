package com.zjj.origod.control;

import com.alibaba.fastjson.JSONObject;
import com.zjj.origod.pojo.Report;
import com.zjj.origod.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin/")
@CrossOrigin
public class AdminController {
    @Autowired
    AdminService adminService;


    @PostMapping("getMerchant")
    JSONObject getMerchant(@RequestBody JSONObject jsonObject){
        return adminService.getMerchant();
    }


    @PostMapping("getCustomer")
    JSONObject getCustomer(@RequestBody JSONObject jsonObject){
        return adminService.getCustomer();
    }

    @PostMapping("getDelivery")
    JSONObject getDelivery(@RequestBody JSONObject jsonObject){
        return adminService.getDelivery();
    }

    @PostMapping("getReport")
    JSONObject getReport(@RequestBody JSONObject jsonObject){
        return adminService.getReports();
    }


    @PostMapping("deleteMerchant")
    void deleteMerchant(@RequestBody JSONObject jsonObject){
        int m_id = Integer.parseInt(jsonObject.get("m_id").toString());
        adminService.deleteMerchant(m_id);
    }

    @PostMapping("deleteCustomer")
    void deleteCustomer(@RequestBody JSONObject jsonObject){
        int c_id=  Integer.parseInt(jsonObject.get("c_id").toString());
        adminService.deleteCustomer(c_id);
    }

    @PostMapping("deleteDelivery")
    void deleteDelivery(@RequestBody JSONObject jsonObject){
        int d_id = Integer.parseInt(jsonObject.get("d_id").toString());
        adminService.deleteDelivery(d_id);
    }

    @PostMapping("updateCustomer")
    void updateCustomer(@RequestBody JSONObject jsonObject){
        String password = (String)jsonObject.get("password");
        int c_id = Integer.parseInt(jsonObject.get("c_id").toString());
        adminService.updateCustomer(password,c_id);
    }

    @PostMapping("updateMerchant")
    void updateMerchant(@RequestBody JSONObject jsonObject){
        int m_id = Integer.parseInt(jsonObject.get("m_id").toString());
        String m_password = (String)jsonObject.get("m_password");
        String m_name = (String)jsonObject.get("m_name");
        String m_phone = (String)jsonObject.get("m_phone");
        String m_address = (String)jsonObject.get("m_address");
        adminService.updateMerchant(m_id,m_name,m_password,m_phone,m_address);
    }


    @PostMapping("updateDelivery")
    void updateDelivery(@RequestBody JSONObject jsonObject){
        int d_id = Integer.parseInt(jsonObject.get("d_id").toString());
        String password = (String)jsonObject.get("password");
        adminService.updateDelivery(password,d_id);
    }

    @PostMapping("updateReport")
    void updateReport(@RequestBody JSONObject jsonObject){
        int r_id = (int)jsonObject.get("r_id");
        String tag = (String)jsonObject.get("tag");
        adminService.updateReport(r_id);
        Report report = (Report) adminService.getReportById(r_id).get("dt");
        int m_id = report.getM_id();
        if(tag.equals("yes")){
            adminService.lockMerchant(m_id);
        }
    }


    @PostMapping("createMerchant")
    void createMerchant(@RequestBody JSONObject jsonObject){
        String m_name = (String)jsonObject.get("m_name");
        String m_password = (String)jsonObject.get("m_password");
        String m_username = (String)jsonObject.get("m_username");
        String m_address = (String)jsonObject.get("m_address");
        String m_phone = (String)jsonObject.get("m_phone");
        adminService.createMerchant(m_name,m_username,m_password,m_address,m_phone);
    }
}
