package com.zjj.origod.control;


import com.alibaba.fastjson.JSONObject;
import com.zjj.origod.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.zjj.origod.utils.RandomName;

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


    @CrossOrigin
    @PostMapping("uploadImg")
        public JSONObject uploadImg(@RequestParam("file") MultipartFile[] files, @RequestParam("f_id") int f_id){
        JSONObject json=new JSONObject();
        String uploadFilePath = "E:\\githubstore\\My-Easy-Pic-Bed\\pics";
        String baseUrl = "http://127.0.0.1/uploads/";
        for(int i=0;i<1;i++){
            String fileName =  RandomName.MakeFileName(Objects.requireNonNull(files[i].getOriginalFilename()));  // 文件名
            System.out.println(fileName);
            String filepath = uploadFilePath +'\\'+ fileName;
            File dest = new File(filepath);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                files[i].transferTo(dest);
            } catch (Exception e) {
                json.put("success",1);
                json.put("result","程序错误，请重新上传");
                return json;
            }
            merchantService.updateImgUrl(f_id,baseUrl+fileName);
        }
        json.put("success",0);
        json.put("result","文件上传成功");
        return json;
    }
}
