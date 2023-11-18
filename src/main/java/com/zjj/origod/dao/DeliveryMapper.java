package com.zjj.origod.dao;

import com.zjj.origod.pojo.Delivery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DeliveryMapper {
    Delivery selectByUsername(@Param("username") String username);

    void insertDelivery(@Param("username")String username,@Param("password")String password);
}
