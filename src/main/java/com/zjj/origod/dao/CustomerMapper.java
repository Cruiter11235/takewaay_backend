package com.zjj.origod.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjj.origod.pojo.*;
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

    void insertCustomer(@Param("c")Customer customer);


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


    Customer selectById(@Param("c_id")int c_id);

    void updateById(@Param("c")Customer customer);


    void createReport(@Param("r")Report report);
    void createComment(@Param("t")Comment comment);
}
