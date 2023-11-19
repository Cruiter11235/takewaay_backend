package com.zjj.origod;

import com.zjj.origod.dao.CustomerMapper;
import com.zjj.origod.dao.DeliveryMapper;
import com.zjj.origod.dao.GlobalMapper;
import com.zjj.origod.dao.MerchantMapper;
import com.zjj.origod.pojo.Admin;
import com.zjj.origod.pojo.Customer;
import com.zjj.origod.pojo.Order;
import com.zjj.origod.service.CustomerService;
import com.zjj.origod.utils.RandomName;
import com.zjj.origod.utils.TimeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
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
    @Test
    void contextLoads() {
        System.out.println(RandomName.MakeName());
    }

    @Test
    void testsql(){
        System.out.println(deliveryMapper.selectOrderByD_id(1));
    }
}
