package com.zjj.origod;

import com.zjj.origod.dao.*;
import com.zjj.origod.pojo.*;
import com.zjj.origod.service.*;
import com.zjj.origod.utils.RandomName;
import com.zjj.origod.utils.TimeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@SpringBootTest
class OriGodApplicationTests {
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    GlobalMapper globalMapper;
    @Autowired
    CustomerService customerService;
    @Autowired
    MerchantMapper merchantMapper;
    @Autowired
    DeliveryMapper deliveryMapper;
    @Autowired
    AccountService accountService;
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    AdminService adminService;
    @Autowired
    MerchantService merchantService;
    @Autowired
    DeliveryService deliveryService;
    @Test
    void contextLoads() {
        System.out.println(RandomName.MakeName());
    }

    @Test
    void testsql(){
        List<OrderItem> orderItemList = new ArrayList<>();
        OrderItem orderItem= new OrderItem();
        orderItem.setF_id(1);
        orderItem.setF_count(1);
        orderItemList.add(orderItem);
        customerService.createOrder(1,1,orderItemList);
    }

    @Test
    void testsql2(){
        accountService.register("test1","test2","customer");
    }
}
