package com.zjj.origod.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjj.origod.pojo.Admin;
import com.zjj.origod.pojo.Customer;
import com.zjj.origod.pojo.Order;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface CustomerMapper{
    Customer selectByUsername(@Param("username")String username);

    void insertCustomer(@Param("name")String name,@Param("username")String username,@Param("password")String password);

    void updateCustomerById(
         @Param("c_id")int c_id,
         @Param("c_name")String c_name,
         @Param("c_password")String c_password,
         @Param("c_phone")String c_phone,
         @Param("c_address")String c_address
    );

    @MapKey("m_id")
    List<Map<String,Object>> selectMerchant();

    @MapKey("m_id")
    List<Map<String,Object>> selectMerchantByClass_name(
            @Param("class_name")String class_name
    );

    @MapKey("f_id")
    List<Map<String,Object>> selectFoodByM_id(
            @Param("m_id")int m_id
    );

    int createOrder(
            @Param("order")Order order
            );


    void addFoodToOrder(
            @Param("o_id")int o_id,
            @Param("f_id")int f_id,
            @Param("f_count")int f_count
    );

    @MapKey("o_id")
    List<Map<String,Object>> selectOrderByC_id(
            @Param("c_id")int c_id
    );
}
